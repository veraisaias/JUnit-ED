package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicadorTest {
    Multiplicador multiplicador;

    @Before
    public void setUp() throws Exception {
        multiplicador = new Multiplicador();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplicarUsandoAnotacionEnTest() {
        multiplicador.multiplicar(1000,5);
    }

    @Test
    public void multiplicarConTryCatch() {
        try {
            multiplicador.multiplicar(1000,5);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException il) {
            assertEquals(il.getMessage(),"X debe ser menor que 1000");
        }
    }
}