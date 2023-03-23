package com.jk.optics.fiberoptics.zadatak38;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class Zadatak38ServiceTests {


    private Zadatak38Service zadatak38Service;

    @BeforeEach
    void setUp() {
        zadatak38Service = new Zadatak38Service();
    }

    @Test
    void convertWToDbW_returns_correct_result() {
        //GIVEN
        Double snagaUWatima = 100E-6;
        BigDecimal expected = new BigDecimal("-40.0");

        //WHEN
        BigDecimal actual = zadatak38Service.convertWToDbW(snagaUWatima);

        //THEN
        assertEquals(expected, actual);
    }

}