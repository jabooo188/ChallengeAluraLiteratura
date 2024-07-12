package com.aluracurso.challengeliteratura.model;

public enum Generos {
    DRAMA ("Drama"),
    CRIMEN ("Crime"),
    FICCION ("Fiction"),
    AVENTURA("Adventure"),
    ROMANCE("Romance"),
    NOENCONTRADO("Genero no encontrado");

    private String genero;

    Generos(String generoLibro){
        this.genero=generoLibro;
    }

    public static Generos generoString (String text){
        for (Generos generosEnum: Generos.values()){
            if (generosEnum.genero.equals(text)){
                return generosEnum;
            }
        } return NOENCONTRADO;
    }

}
