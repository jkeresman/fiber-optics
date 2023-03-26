package com.jk.optics.fiberoptics.zadatak43;

import com.jk.optics.fiberoptics.converter.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.jk.optics.fiberoptics.constants.Constants.*;

@Service
@AllArgsConstructor
public class Zadatak43Service {

    private static final int BROJ_KONEKTORA = 2;
    private final ConverterService converterService;

    public Zadatak43Response solve(Zadatak43Request zadatak43) {
        Double rjesenjeNa = izracunajNa(zadatak43);
        Double rjesenjeNs = izracunajNs(zadatak43);
        BigDecimal snagaPrijemnika = izracunajSnaguPrijemnikaDbm(zadatak43);
        BigDecimal pojacanjePojacalDB = izracunajSnaguPojacala(zadatak43, rjesenjeNa, rjesenjeNs, snagaPrijemnika);

        return new Zadatak43Response(pojacanjePojacalDB, rjesenjeNa, rjesenjeNs, snagaPrijemnika);
    }

    private Double izracunajNa(Zadatak43Request zadatak43) {
        Double udaljenost = zadatak43.getUdaljenost();
        Double udaljenostPojacala = zadatak43.getUdaljenostPojacala();
        return Math.floor(udaljenost / udaljenostPojacala);
    }

    private Double izracunajNs(Zadatak43Request zadatak43) {
        Double udaljenost = zadatak43.getUdaljenost();
        Double dionicaUKm = zadatak43.getDionicaUKm();
        return Math.floor(udaljenost / dionicaUKm - BROJ_KONEKTORA);
    }

    private BigDecimal izracunajSnaguPrijemnikaDbm(Zadatak43Request zadatak43) {
        Integer brojFotonaPoBitu = zadatak43.getBrojFotonaPoBitu();
        Double brzinaPrijenosa = zadatak43.getBrzinaPrijenosa();
        Double lambda = zadatak43.getLambda();
        Double snagaUVatima = brojFotonaPoBitu * ((PLANCK_CONSTANT.getValue() * SPEED_OF_LIGHT.getValue())
                / (lambda * NANO.getValue()) * brzinaPrijenosa * GIGA_BITA_PO_SEKUNDI.getValue());
        return converterService.convertWToDbm(snagaUVatima);
    }

    private BigDecimal izracunajSnaguPojacala(Zadatak43Request zadatak43, Double na, Double ns, BigDecimal snagaPrijemnikaDbm) {
        Double snagaOdasiljaca = zadatak43.getSnagaOdasiljaca();
        Double gubici = zadatak43.getGubici();
        Double udaljenost = zadatak43.getUdaljenost();
        Double gubiciKonektora = zadatak43.getGubiciKonektora();
        Double gubicSpojeva = zadatak43.getGubicSpojeva();
        Double marginaSustava = zadatak43.getMarginaSustava();
        BigDecimal snagaOdasiljacadBm = converterService.convertDbWToDbm(snagaOdasiljaca);
        Double pojacanje = (snagaPrijemnikaDbm.doubleValue() - snagaOdasiljacadBm.doubleValue()
                + gubici * udaljenost + gubicSpojeva * ns + gubiciKonektora * BROJ_KONEKTORA
                + marginaSustava + na * 2 * (gubiciKonektora + gubicSpojeva)) / na;
        return new BigDecimal(pojacanje);
    }

}
