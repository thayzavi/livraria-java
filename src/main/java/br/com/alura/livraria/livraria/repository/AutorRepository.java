package br.com.alura.livraria.livraria.repository;

import br.com.alura.livraria.livraria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("""
            SELECT a FROM Autor a
            WHERE a.anoNascimento <= :ano
            And (a.anoFalecimento IS NULL OR a.anoFalecimento >= :ano)
            """)
    List<Autor> buscarAutoresVivosNoAno(Integer ano);

    List<Autor> findByNomeContainingIgnoreCase(String nome);

}
