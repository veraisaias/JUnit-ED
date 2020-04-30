package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PodaExtremosTest {
    private List<Integer> lista;
    private PodaExtremos podaExtremos;

    @Before
    public void setUp() {
        podaExtremos = new PodaExtremos();
        lista = new ArrayList<>(List.of(1,21, 55, 1, 5, 8, 13, 3, 2, 34));
    }

    @After
    public void tearDown() {
        lista.clear();
    }

    @Test
    public void podarMasProximo() {
        assertEquals(8,podaExtremos.podarMasProximo(9,lista));
        assertEquals(55,podaExtremos.podarMasProximo(49,lista));
    }

    @Test
    public void podarMasLejano() {
        assertEquals(55,podaExtremos.podarMasLejano(10,lista));
        assertEquals(1,podaExtremos.podarMasLejano(30,lista));
    }
}