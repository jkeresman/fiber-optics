package com.jk.optics.fiberoptics.zadatak38;

import com.jk.optics.fiberoptics.converter.ConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Zadatak38ServiceTests {


    @Mock
    private ConverterService converterService;

    @InjectMocks
    private Zadatak38Service zadatak38Service;

    @Test
    void zadatak38Test() {
        //GIVEN
        Zadatak38Request zadatak38 = new Zadatak38Request();
        zadatak38.setBrojFotonaPoBitu(5000.0);
        zadatak38.setLambda(1.3);
        zadatak38.setBrzinaPrijenosa(150.0);
        zadatak38.setSnagaOdasiljacadbW(-40.0);
        zadatak38.setGubici(0.25);

        BigDecimal expectedRjesenjeA = new BigDecimal("117.6000000000000227373675443232059478759765625");
        BigDecimal expectedRjesenjeB = new BigDecimal("10");
        BigDecimal expectedRjesenjeC = new BigDecimal("20");
        BigDecimal expectedSnagaPrijemnika = new BigDecimal("-69.4");


        //WHEN
        when(converterService.convertToDbW((Double) any())).thenReturn(expectedSnagaPrijemnika);
        Zadatak38Response result = zadatak38Service.solve(zadatak38);

        //THEN
        assertThat(result.getRjesenjeA()).isEqualByComparingTo(expectedRjesenjeA);
        assertThat(result.getRjesenjeB()).isEqualByComparingTo(expectedRjesenjeB);
        assertThat(result.getRjesenjeC()).isEqualByComparingTo(expectedRjesenjeC);
        assertThat(result.getSnagaPrijemnikadbW()).isEqualByComparingTo(expectedSnagaPrijemnika);
    }
}
