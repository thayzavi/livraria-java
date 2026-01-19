package br.com.alura.livraria.livraria.service;

import br.com.alura.livraria.livraria.dto.AutorDTO;
import br.com.alura.livraria.livraria.dto.GutendexResponse;
import br.com.alura.livraria.livraria.dto.LivroDTO;
import br.com.alura.livraria.livraria.model.Autor;
import br.com.alura.livraria.livraria.model.Livro;
import br.com.alura.livraria.livraria.repository.AutorRepository;
import br.com.alura.livraria.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final  GutendexService gutendexService;
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(GutendexService gutendexService,
                        LivroRepository livroRepository,
                        AutorRepository autorRepository){
        this.gutendexService = gutendexService;
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void buscarESalvarLivro(String titulo) {
        GutendexResponse response = gutendexService.buscarLivroPorTitulo(titulo);

        if (response.getResults().isEmpty()) {
            System.out.println("Livro não encontrado");
            return;
        }

        LivroDTO livroDTO = response.getResults().get(0);

        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitle());
        livro.setIdioma(livroDTO.getLanguages().get(0));
        livro.setDownloads(livroDTO.getDownloadCount());

        List<Autor> autores = new ArrayList<>();

        for (AutorDTO autorDTO : livroDTO.getAuthors()) {
            Autor autor = autorRepository
                    .findByNomeContainingIgnoreCase(autorDTO.getName())
                    .stream()
                    .findFirst()
                    .orElseGet(() -> {
                        Autor novoAutor = new Autor();
                        novoAutor.setNome(autorDTO.getName());
                        novoAutor.setAnoNascimento(autorDTO.getBirthYear());
                        novoAutor.setAnoFalecimento(autorDTO.getDeathYear());
                        return autorRepository.save(novoAutor);

                    });
            autores.add(autor);
        }

        livro.setAutores(autores);
        livroRepository.save(livro);

        System.out.println("Livro salvo com sucesso!");
    }

}
