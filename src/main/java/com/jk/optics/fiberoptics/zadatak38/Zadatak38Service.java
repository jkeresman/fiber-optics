package com.jk.optics.fiberoptics.zadatak38;

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

        public Zadatak38Response solve(Zadatak38Request zadatak38) {
            BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(zadatak38);
            BigDecimal rjesenjeA = rijesiPodzadatakA(zadatak38);
            BigDecimal rjesenjeB = rijesiPodzadatakB(zadatak38);
            BigDecimal rjesenjeC = rijesiPodzadatakC(zadatak38);
            return new Zadatak38Response(rjesenjeA, rjesenjeB, rjesenjeC, snagaPrijemnika);
        }

        private BigDecimal rijesiPodzadatakB(Zadatak38Request zadatak38) {
            Double disperzijaNiti = zadatak38.getMaterijalnaDisperzija();
            Double dLambda = zadatak38.getDeltaLambda();
            Double brzinaPrijenosa = zadatak38.getBrzinaPrijenosa();
            Double rjesenjeB = 1/(4 * Math.abs(disperzijaNiti * PIKO)
                    * dLambda * brzinaPrijenosa * MEGA_BITA_PO_SEKUNDI);
            return new BigDecimal(rjesenjeB);
        }

        private BigDecimal izracunajSnaguPrijemnikauDbW(Zadatak38Request zadatak38) {
            Double brojFotonaPoBitu = zadatak38.getBrojFotonaPoBitu();
            Double lambda = zadatak38.getLambda();
            Double brzinaKojuZelimoPostici = zadatak38.getBrzinaPrijenosa();
            Double snagaUW = brojFotonaPoBitu * ((PLANCK_CONSTANT * SPEED_OF_LIGHT)
                    / (lambda * MIKRO) * brzinaKojuZelimoPostici * MEGA_BITA_PO_SEKUNDI);
            return converterService.convertToDbW(snagaUW);
        }

        private BigDecimal rijesiPodzadatakA(Zadatak38Request zadatak38) {
            BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(zadatak38);
            Double snagaOdasiljaca = zadatak38.getSnagaOdasiljacadbW();
            Double gubici = zadatak38.getGubici();
            Double rjesenjeA = (snagaOdasiljaca - snagaPrijemnika.doubleValue()) / gubici;
            return new BigDecimal(rjesenjeA);
        }

        private BigDecimal rijesiPodzadatakC(Zadatak38Request zadatak38) {
            Double cl = izracunajCl(zadatak38);
            Double brojSpojeva = izracunajBrojSpojeva(zadatak38);
            Double gubiciSpoja = zadatak38.getGubiciSpojeva();
            Double gubici = zadatak38.getGubici();
            Double rjesenje = (cl - gubiciSpoja * brojSpojeva) / gubici;
            return new BigDecimal(rjesenje);
        }

        private Double izracunajCl(Zadatak38Request zadatak38) {
            BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikauDbW(zadatak38);
            Double snagaOdasiljaca = zadatak38.getSnagaOdasiljacadbW();
            Double gubici = zadatak38.getGubici();
            Double marginaSustava = zadatak38.getMarginaSustava();
            return snagaOdasiljaca - snagaPrijemnika.doubleValue() - marginaSustava - gubici * 2;
        }

        private Double izracunajGubitkeJedneDionice(Zadatak38Request zadatak38) {
            Double gubici = zadatak38.getGubici();
            Double dionica = zadatak38.getDionicaKm();
            Double gubiciSpoja = zadatak38.getGubiciSpojeva();
            return gubici * dionica + gubiciSpoja;
        }

        private Double izracunajBrojSpojeva(Zadatak38Request zadatak38) {
            Double gubici = izracunajCl(zadatak38);
            Double gubiciJedneDionice = izracunajGubitkeJedneDionice(zadatak38);
            return Math.floor(gubici/gubiciJedneDionice);
        }


}
