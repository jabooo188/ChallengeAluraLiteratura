package com.aluracurso.challengeliteratura.model;


import jakarta.persistence.*;
import com.aluracurso.challengeliteratura.repository.LibroRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idLibro;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autores autor;

    @Enumerated(EnumType.STRING)
    private Generos generos;
    private String idioma;

    public Libro() {
    }

    public Libro(DatosLibro datosLibro){
        this.idLibro = datosLibro.libroID();
        this.titulo = datosLibro.titulo();

        if (datosLibro.autor() != null && datosLibro.autor().isEmpty()){
            this.autor = new Autores(datosLibro.autor().get(0));
        } else {
            this.autor = null;
        }

        this.generos = generoIngresado(datosLibro.generos());
        this.idioma = idiomaIngresado(datosLibro.idiomas());
    }

    private Generos generoIngresado(List<String> generos) {
        if (generos == null || generos.isEmpty()){
            return Generos.NOENCONTRADO;
        }
        Optional<String> unGenero = generos.stream()
                .map(e -> {
                    int index = e.indexOf("--");
                    return index != -1 ? e.substring(index + 2).trim() : null;
                })
                .filter(Objects::nonNull)
                .findFirst();
        return unGenero.map(Generos::generoString).orElse(Generos.NOENCONTRADO);
    }

    private String idiomaIngresado(List<String> idiomas) {
        if (idiomas == null || idiomas.isEmpty()){
            return "No hay libros con ese lenguaje";
        }
        return idiomas.get(0);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutores() {
        return autor;
    }

    public void setAutores(Autores autores) {
        this.autor = autor;
    }

    public Generos getGeneros() {
        return generos;
    }

    public void setGeneros(Generos generos) {
        this.generos = generos;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autor +
                ", generos=" + generos +
                ", idioma='" + idioma + '\'';
    }
}
