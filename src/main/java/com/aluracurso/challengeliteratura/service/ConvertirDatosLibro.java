package com.aluracurso.challengeliteratura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatosLibro implements IConvertirDatosLibro {

    public final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T convertirDatosJson(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
