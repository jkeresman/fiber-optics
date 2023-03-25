package com.jk.optics.fiberoptics.zadatak38;

import com.jk.optics.fiberoptics.constants.Constants;
import com.jk.optics.fiberoptics.converter.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.jk.optics.fiberoptics.constants.Constants.*;
import static com.jk.optics.fiberoptics.constants.Constants.PLANCK_CONSTANT;
import static com.jk.optics.fiberoptics.constants.Constants.SPEED_OF_LIGHT;

@Service
@AllArgsConstructor
public class Zadatak38Service {

        private final ConverterService converterService;

        public Zadatak38Response solve(Zadatak38Request zadatak38Request) {
            BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(zadatak38Request);

            BigDecimal rjesenjeA = rijesiPodzadatakA(zadatak38Request);

            BigDecimal rjesenjeB = rijesiPodzadatakB(zadatak38Request);

            BigDecimal rjesenjeC = new BigDecimal("20");
            return new Zadatak38Response(rjesenjeA, rjesenjeB, rjesenjeC, snagaPrijemnika);
        }

        private BigDecimal rijesiPodzadatakB(Zadatak38Request zadatak38Request) {
            Double disperzijaNiti = zadatak38Request.getMaterijalnaDisperzija();
            Double dLambda = zadatak38Request.getDeltaLambda();
            Double brzinaPrijenosa = zadatak38Request.getBrzinaPrijenosa();
            Double rjesenjeB = 1/(4 * Math.abs(disperzijaNiti * PIKO)
                    * dLambda * brzinaPrijenosa * MEGA_BITA_PO_SEKUNDI);
            return new BigDecimal(rjesenjeB);
        }

        private BigDecimal izracunajSnaguPrijemnikauDbW(Zadatak38Request zadatak38Request) {
            Double brojFotonaPoBitu = zadatak38Request.getBrojFotonaPoBitu();
            Double lambda = zadatak38Request.getLambda();
            Double brzinaKojuZelimoPostici = zadatak38Request.getBrzinaPrijenosa();
            Double snagaUW = brojFotonaPoBitu * ((PLANCK_CONSTANT * SPEED_OF_LIGHT)
                    / (lambda * MIKRO) * brzinaKojuZelimoPostici * MEGA_BITA_PO_SEKUNDI);
            return converterService.convertToDbW(snagaUW);
        }

        private BigDecimal rijesiPodzadatakA(Zadatak38Request zadatak38Request) {
            BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(zadatak38Request);
            Double snagaOdasiljaca = zadatak38Request.getSnagaOdasiljacadbW();
            Double gubici = zadatak38Request.getGubici();
            Double rjesenjeA = (snagaOdasiljaca - snagaPrijemnika.doubleValue()) / gubici;
            return new BigDecimal(rjesenjeA);
        }


}
