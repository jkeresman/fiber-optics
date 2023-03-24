package com.jk.optics.fiberoptics.zadatak42;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Zadatak42Request {

    @JsonProperty("ls")
    private Double dionica;

    @JsonProperty("as")
    private Double gubiciFiksongSpoja;

    @JsonProperty("ak")
    private Double gubiciKonektora;

    @JsonProperty("la")
    private Double optickoPojacaloUdaljenost;

    @JsonProperty("ga")
    private Double pojacanjePojacala;

    @JsonProperty("ms")
    private Double marginaSustava;
}
