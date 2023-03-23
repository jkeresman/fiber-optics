package com.jk.optics.fiberoptics.converter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ConverterRequest {

    @JsonProperty("vati")
    private Double value;

    @JsonProperty("jedinica")
    private Double djelitelj;
}
