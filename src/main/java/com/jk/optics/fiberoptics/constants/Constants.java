package com.jk.optics.fiberoptics.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Constants {

    PLANCK_CONSTANT(6.62606896e-34),
    SPEED_OF_LIGHT(3e8),
    MIKRO(1e-6),
    NANO(1e-9),
    PIKO(1e-12),
    MEGA_BITA_PO_SEKUNDI(1e6),
    GIGA_BITA_PO_SEKUNDI(1e9);

    private final double value;


}