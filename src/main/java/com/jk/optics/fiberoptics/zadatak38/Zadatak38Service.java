package com.jk.optics.fiberoptics.zadatak38;

import com.jk.optics.fiberoptics.constants.Constants;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.jk.optics.fiberoptics.constants.Constants.PLANCK_CONSTANT;
import static com.jk.optics.fiberoptics.constants.Constants.SPEED_OF_LIGHT;

@Service
public class Zadatak38Service {

    public Zadatak38Response solve(Zadatak38Request zadatak38Request) {
        BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(
                zadatak38Request.getBrojFotonaPoBitu(),
                zadatak38Request.getLambda(),
                zadatak38Request.getBrzinaPrijenosa()
        );
        System.out.println("Snaga prijemnika: " + snagaPrijemnika);
        BigDecimal rjesenjeA = BigDecimal.valueOf((zadatak38Request.getSnagaOdasiljacadbW() - snagaPrijemnika.doubleValue() / zadatak38Request.getGubici()));
        BigDecimal rjesenjeB = new BigDecimal("10");
        BigDecimal rjesenjeC = new BigDecimal("20");
        return new Zadatak38Response(rjesenjeA, rjesenjeB, rjesenjeC, snagaPrijemnika);
    }

    public BigDecimal izracunajSnaguPrijemnikauDbW(Double brojFotonaPoBitu, Double lambda, Double brzinaKojuZelimoPostici) {
        Double snagaUW = brojFotonaPoBitu * ((PLANCK_CONSTANT * SPEED_OF_LIGHT) / (lambda/1000000)) * brzinaKojuZelimoPostici;
        System.out.println("Snaga u watima " + snagaUW);
        return convertWToDbW(snagaUW);
    }

    public BigDecimal convertWToDbW(Double vati) {
        return BigDecimal.valueOf(10 * Math.log10(vati));
    }



}
