package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTipos(@JsonAlias("codigo") String codigo,
                         @JsonAlias("nome") String nome){
}
