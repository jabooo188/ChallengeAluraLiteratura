package com.aluracurso.challengeliteratura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.print.attribute.standard.Media;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Long libroID,
        @JsonAlias("title")String titulo,
        @JsonAlias("authors")List<Autores> autor,
        @JsonAlias("subjects")List<String> generos,
        @JsonAlias("languages")List<String> idiomas

) {
}
