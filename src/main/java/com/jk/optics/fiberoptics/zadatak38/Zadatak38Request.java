package com.jk.optics.fiberoptics.zadatak38;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Zadatak38Request {

    @JsonProperty("Pod")
    private Double snagaOdasiljacadbW;

    @JsonProperty("b")
    private Double brzinaPrijenosa;

    @JsonProperty("delta-lambda")
    private Double deltaLambda;

    @JsonProperty("lambda")
    private Double lambda;

    @JsonProperty("alpha")
    private Double gubici;

    @JsonProperty("alpha-s")
    private Double gubiciSpojeva;

    @JsonProperty("alpha-k")
    private Double gubiciKonektora;

    @JsonProperty("nb")
    private Double brojFotonaPoBitu;

    @JsonProperty("l1")
    private Double dionicaKm;

    @JsonProperty("d")
    private Double materijalnaDisperzija;

    @JsonProperty("ms")
    private Double marginaSustava;

}
