package com.jk.optics.fiberoptics.zadatak38;

import com.jk.optics.fiberoptics.converter.ConverterRequest;
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

    public Zadatak38Response solve(zadatak38 zadatak38) {
        BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(
                zadatak38.getBrojFotonaPoBitu(),
                zadatak38.getLambda(),
                zadatak38.getBrzinaPrijenosa()
        );
        System.out.println("Snaga prijemnika: " + snagaPrijemnika);
        BigDecimal rjesenjeA = rijesiPodzadatakA(
                snagaPrijemnika,
                zadatak38.getSnagaOdasiljacadbW(),
                zadatak38.getGubici()
        );
        System.out.println("Podazdatak a: " + rjesenjeA);
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
