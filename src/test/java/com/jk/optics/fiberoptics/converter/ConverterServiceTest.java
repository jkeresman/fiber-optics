package com.jk.optics.fiberoptics.converter;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterServiceTest {

    private ConverterService converterService;

    @BeforeEach
    public void setup() {
        converterService = new ConverterService();
    }


    @Test
    void convertToWTest() {
        //GIVEN
        Double snagaUWatima = 100E-6;
        BigDecimal expected = new BigDecimal("-40.0");

        //WHEN
        BigDecimal actual = converterService.convertToDbW(snagaUWatima);

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void convertToWTestJedinice() {
        //GIVEN
        ConverterRequest converterRequest = new ConverterRequest(100.0,1_000_000.0);
        BigDecimal expected = new BigDecimal("-40.0");

        //WHEN
        BigDecimal actual = converterService.convertToDbW(converterRequest);

        //THEN
        assertEquals(expected, actual);
    }

}