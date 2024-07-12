package com.aluracurso.challengeliteratura.repository;

import com.aluracurso.challengeliteratura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    boolean existsByTitulo(String titulo);

    Optional <Libro> findByTituloContainsIgnoreCase(String titulo);

    List<Libro> findByIdioma(String idioma);

}
