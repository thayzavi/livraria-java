package br.com.alura.livraria.livraria.repository;

import br.com.alura.livraria.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByIdioma(String idioma);

    List<Livro> findByTituloContainingIgnoreCase(String titulo);
}
