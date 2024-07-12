package com.aluracurso.challengeliteratura.repository;

import com.aluracurso.challengeliteratura.model.Autores;
import com.aluracurso.challengeliteratura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository<Autores, Long> {
    List<Autores> findAll();

    List<Autores> findByFechaNacimientoLessThanOrFechaMuerteGreaterThanEqual(int nacimiento, int muerte);

    Optional<Autores> findFirstByNombreContainsIgnoreCase(String escritor);
}
