package br.com.alura.livraria.livraria;

import br.com.alura.livraria.livraria.repository.AutorRepository;
import br.com.alura.livraria.livraria.repository.LivroRepository;
import br.com.alura.livraria.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LivrariaApplication.class, args);
    }


    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("""
                    
                    ===== LIVRARIA =====
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros em determinado idioma
                    0 - Sair
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    livroService.buscarESalvarLivro(titulo);
                }

                case 2 -> livroRepository.findAll()
                        .forEach(l -> System.out.println(l.getTitulo()));

                case 3 -> autorRepository.findAll()
                        .forEach(a -> System.out.println(a.getNome()));

                case 4 -> {
                    System.out.print("Digite o ano: ");
                    int ano = scanner.nextInt();
                    autorRepository.buscarAutoresVivosNoAno(ano)
                            .forEach(a -> System.out.println(a.getNome()));
                }

                case 5 -> {
                    System.out.print("Digite o idioma (pt, en, es, fr): ");
                    String idioma = scanner.nextLine();
                    livroRepository.findByIdioma(idioma)
                            .forEach(l -> System.out.println(l.getTitulo()));
                }

                case 0 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}