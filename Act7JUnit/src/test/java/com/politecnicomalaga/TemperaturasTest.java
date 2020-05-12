package com.politecnicomalaga;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TemperaturasTest {

    @Test
    public void esteTestTieneUnProblema(){
        Temperaturas temperaturas = new Temperaturas();
        Temperaturas espiaTemperaturas = spy(temperaturas);
        //when(espiaTemperaturas.diferenciaMaxima()).thenReturn(30); Se cambia esto por lo de abajo para solucionar el problema del ejercicio
        doReturn(30).when(espiaTemperaturas).diferenciaMaxima(); // solución
        assertEquals(30,espiaTemperaturas.diferenciaMaxima());
    }

}