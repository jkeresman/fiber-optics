package com.jk.optics.fiberoptics.converter;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterService {

    private static final Integer TO_DBM = 30;

    public BigDecimal convertToDbW(ConverterRequest converterRequest) {
        return BigDecimal.valueOf(
                10 * Math.log10(converterRequest.getValue()/converterRequest.getDjelitelj())
        );
    }
    public BigDecimal convertToDbW(Double vati) {
        return BigDecimal.valueOf(10 * Math.log10(vati));
    }

    public BigDecimal convertWToDbm(Double vati) {
        return convertToDbW(vati).add(new BigDecimal(TO_DBM));
    }
    public BigDecimal convertDbWToDbm(Double dbw) {
        return  new BigDecimal(dbw + TO_DBM);
    }
}
