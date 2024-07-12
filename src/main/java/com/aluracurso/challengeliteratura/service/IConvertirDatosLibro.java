package com.aluracurso.challengeliteratura.service;

public interface IConvertirDatosLibro {
    <T> T convertirDatosJson (String json , Class<T> clase);
}
