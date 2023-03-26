package com.jk.optics.fiberoptics.zadatak43;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Zadatak43Response {

    private BigDecimal rjesenjeGa;
    private Double rjesenjeNa;
    private Double rjesenjeNs;
    private BigDecimal rjesenjePpr;
}
