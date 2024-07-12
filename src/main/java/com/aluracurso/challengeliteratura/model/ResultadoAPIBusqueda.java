package com.aluracurso.challengeliteratura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoAPIBusqueda {
    @JsonAlias("results")
    List<DatosLibro> resultado;
    List<Autores> resultadoAutores;

    public List<Autores> getResultadoAutores() {
        return resultadoAutores;
    }

    public void setResultadoAutores(List<Autores> resultadoAutores) {
        this.resultadoAutores = resultadoAutores;
    }

    public List<DatosLibro> getResultado() {
        return resultado;
    }

    public void setResultado(List<DatosLibro> resultado) {
        this.resultado = resultado;
    }
}
