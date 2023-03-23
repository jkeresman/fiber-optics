package com.jk.optics.fiberoptics.converter;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterService {
    public BigDecimal convertToDbW(ConverterRequest converterRequest) {
        return BigDecimal.valueOf(
                10 * Math.log10(converterRequest.getValue()/converterRequest.getDjelitelj())
        );
    }
}
