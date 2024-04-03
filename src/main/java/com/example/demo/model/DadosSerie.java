package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosSerie(@JsonAlias("Title")String titulo,
                         @JsonAlias("totalSeason") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacoes) {
}