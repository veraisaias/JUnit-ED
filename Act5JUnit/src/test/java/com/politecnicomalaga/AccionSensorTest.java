package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AccionSensorTest {
    RangoSensores noIniciado = new RangoSensores(0,9);
    RangoSensores vacio = new RangoSensores(10,19);
    RangoSensores casiVacio = new RangoSensores(20,29);
    RangoSensores mitad = new RangoSensores(30,39);
    RangoSensores casiLleno = new RangoSensores(40,49);
    RangoSensores lleno = new RangoSensores(50,59);


    @Test(expected = IllegalStateException.class)
    public void AccionesCorrectasParaLosSensoresEnDemandaBaja() {
        //given
        MatrizSensores matrizSensores = mock(MatrizSensores.class);
        when(matrizSensores.getEstadoSensor(intThat(noIniciado))).thenThrow(IllegalStateException.class);
        when(matrizSensores.getEstadoSensor(intThat(vacio))).thenReturn(Sensor.ESTADO_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(casiVacio))).thenReturn(Sensor.ESTADO_CASI_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(mitad))).thenReturn(Sensor.ESTADO_MITAD);
        when(matrizSensores.getEstadoSensor(intThat(casiLleno))).thenReturn(Sensor.ESTADO_CASI_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(lleno))).thenReturn(Sensor.ESTADO_LLENO);
        //when
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_BAJA);
        //then
        assertEquals(accionSensor.evaluar(5),AccionSensor.ACCION_REVISION);
        assertEquals(accionSensor.evaluar(15),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(25),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(35),AccionSensor.ACCION_INNECESARIA);
    }

    @Test(expected = IllegalStateException.class)
    public void AccionesCorrectasParaLosSensoresEnDemandaMedia() {
        //given
        MatrizSensores matrizSensores = mock(MatrizSensores.class);
        when(matrizSensores.getEstadoSensor(intThat(noIniciado))).thenThrow(IllegalStateException.class);
        when(matrizSensores.getEstadoSensor(intThat(vacio))).thenReturn(Sensor.ESTADO_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(casiVacio))).thenReturn(Sensor.ESTADO_CASI_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(mitad))).thenReturn(Sensor.ESTADO_MITAD);
        when(matrizSensores.getEstadoSensor(intThat(casiLleno))).thenReturn(Sensor.ESTADO_CASI_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(lleno))).thenReturn(Sensor.ESTADO_LLENO);
        //when
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_MEDIA);
        //then
        assertEquals(accionSensor.evaluar(5),AccionSensor.ACCION_REVISION);
        assertEquals(accionSensor.evaluar(15),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(25),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(35),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(45),AccionSensor.ACCION_INNECESARIA);
    }

    @Test(expected = IllegalStateException.class)
    public void AccionesCorrectasParaLosSensoresEnDemandaAlta() {
        //given
        MatrizSensores matrizSensores = mock(MatrizSensores.class);
        when(matrizSensores.getEstadoSensor(intThat(noIniciado))).thenThrow(IllegalStateException.class);
        when(matrizSensores.getEstadoSensor(intThat(vacio))).thenReturn(Sensor.ESTADO_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(casiVacio))).thenReturn(Sensor.ESTADO_CASI_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(mitad))).thenReturn(Sensor.ESTADO_MITAD);
        when(matrizSensores.getEstadoSensor(intThat(casiLleno))).thenReturn(Sensor.ESTADO_CASI_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(lleno))).thenReturn(Sensor.ESTADO_LLENO);
        //when
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_ALTA);
        //then
        assertEquals(accionSensor.evaluar(5),AccionSensor.ACCION_REVISION);
        assertEquals(accionSensor.evaluar(15),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(25),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(35),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(45),AccionSensor.ACCION_REPOSICION);
        assertEquals(accionSensor.evaluar(55),AccionSensor.ACCION_INNECESARIA);
    }
}