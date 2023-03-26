package com.jk.optics.fiberoptics.zadatak43;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Zadatak43Request {

    @JsonProperty("Pod")
    private Double snagaOdasiljaca;

    @JsonProperty("b")
    private Double brzinaPrijenosa;

    @JsonProperty("l")
    private Double Udaljenost;

    @JsonProperty("lambda")
    private Double lambda;

    @JsonProperty("alpha")
    private Double gubici;

    @JsonProperty("alpha-s")
    private Double gubicSpojeva;

    @JsonProperty("alpha-k")
    private Double gubiciKonektora;

    @JsonProperty("nb")
    private Integer brojFotonaPoBitu;

    @JsonProperty("ls")
    private Double dionicaUKm;

    @JsonProperty("la")
    private Double udaljenostPojacala;

    @JsonProperty("ms")
    private Double marginaSustava;
}
