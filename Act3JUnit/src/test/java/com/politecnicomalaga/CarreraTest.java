package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarreraTest {
    Carrera carrera;


    @Before
    public void setUp() throws Exception {
        carrera = new Carrera();
    }

    @Test
    public void getListadoParticipantes_listaDebeEstarVacia_listaEstaVacia() {
        assertNull(carrera.getListadoParticipantes());
    }

    @Test
    public void getListadoParticipantes_listaNoDebeEstarVacia_listaNoEstaVacia() {
        carrera.addParticipante("Paul Walker");
        assertNotNull(carrera.getListadoParticipantes());
    }

    @Test
    public void addParticipante_puedenSerParticipantesDiferentes_hayDiferentesParticipantes() {
        assertTrue(carrera.addParticipante("Bloodseeker"));
        assertTrue(carrera.addParticipante("Clinkz"));
        assertTrue(carrera.addParticipante("Invoker"));
        assertTrue(carrera.addParticipante("Spirit Breaker"));
    }

    @Test
    public void insertarParticipanteRepetido() {
        // given
        carrera.addParticipante("Doom");
        carrera.addParticipante("Axe");
        carrera.addParticipante("Rubick");
        carrera.addParticipante("Earthshaker");
        int totalParticipantesInicial = carrera.getTotalParticipates();

        // when
        carrera.addParticipante("Doom");

        //then
        assertEquals(totalParticipantesInicial,carrera.getTotalParticipates());
    }

    @Test
    public void insertarParticipanteEnUnaPosicion() {
        //given
        carrera.addParticipante("Meepo");
        String wick = "John Wick";
        carrera.addParticipante(wick);

        //when
        carrera.setPosicion(wick,0);

        //then
        assertEquals(wick,carrera.getParticipantePorPosicion(0));
    }

    @Test
    public void listaClonadaDistintaDeListaGet() {
        //given
        List<String> get = carrera.getListadoParticipantes();

        //when
        List<String> clone = carrera.cloneCarrera();

        //then
        assertNotSame(get,clone);
    }

    @Test
    public void listaConMismosDatos(){
        //given
        carrera.addParticipante("Juggernaut");
        carrera.addParticipante("Lich");
        carrera.addParticipante("Razor");
        carrera.addParticipante("Void Spirit");
        List<String> inicio = carrera.getListadoParticipantes();

        //when
        carrera.setPosicion("Razor",0);
        carrera.setPosicion("Void Spirit",1);

        //then
        assertArrayEquals(inicio.toArray(),carrera.getListadoParticipantes().toArray());
    }
}