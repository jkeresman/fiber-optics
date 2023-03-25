package com.jk.optics.fiberoptics.zadatak38;

import com.jk.optics.fiberoptics.converter.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.jk.optics.fiberoptics.constants.Constants.PLANCK_CONSTANT;
import static com.jk.optics.fiberoptics.constants.Constants.SPEED_OF_LIGHT;

@Service
@AllArgsConstructor
public class Zadatak38Service {

    private final ConverterService converterService;

    public Zadatak38Response solve(Zadatak38Request Zadatak38Request) {
        BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(
                Zadatak38Request.getBrojFotonaPoBitu(),
                Zadatak38Request.getLambda(),
                Zadatak38Request.getBrzinaPrijenosa()
        );

        BigDecimal rjesenjeA = rijesiPodzadatakA(
                snagaPrijemnika,
                Zadatak38Request.getSnagaOdasiljacadbW(),
                Zadatak38Request.getGubici()
        );

        BigDecimal rjesenjeB = new BigDecimal("10");
        BigDecimal rjesenjeC = new BigDecimal("20");
        return new Zadatak38Response(rjesenjeA, rjesenjeB, rjesenjeC, snagaPrijemnika);
    }

    private BigDecimal izracunajSnaguPrijemnikauDbW(Double brojFotonaPoBitu, Double lambda, Double brzinaKojuZelimoPostici) {
        Double snagaUW = brojFotonaPoBitu * ((PLANCK_CONSTANT * SPEED_OF_LIGHT) / (lambda/1_000_000) * brzinaKojuZelimoPostici * 1_000_000);
        return converterService.convertToDbW(snagaUW);
    }

    private BigDecimal rijesiPodzadatakA(BigDecimal snagaOdasiljaca, Double snagaPrijemnika, Double gubici) {
        Double rjesenjeA = Math.abs(snagaOdasiljaca.doubleValue() - snagaPrijemnika) / gubici;
        return new BigDecimal(rjesenjeA);
    }


}
