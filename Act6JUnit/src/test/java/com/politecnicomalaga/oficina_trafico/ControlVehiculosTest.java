package com.politecnicomalaga.oficina_trafico;

import com.politecnicomalaga.DAO.TraficoDAO;
import com.politecnicomalaga.modelo.Persona;
import com.politecnicomalaga.modelo.Vehiculo;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControlVehiculosTest {

    @Test
    public void ControlVehiculos(){
        //given
        TraficoDAO traficoDAO = mock(TraficoDAO.class);
        when(traficoDAO.getPropietarioByDNI("12345678A")).thenReturn(new Persona("José Pérez","12345678A"));
        when(traficoDAO.getVehiculoByMatricula("1234ABC")).thenReturn(new Vehiculo("1234ABC","12345678A"));

        //when
        ControlVehiculos controlVehiculos = new ControlVehiculos(traficoDAO);
        controlVehiculos.getPropietarioVehiculo("1234ABC");

        //then
        verify(traficoDAO).getPropietarioByDNI("12345678A");
        verify(traficoDAO).getVehiculoByMatricula("1234ABC");
        verifyNoMoreInteractions(traficoDAO);
        assertEquals(controlVehiculos.getPropietarioVehiculo("1234ABC").getDNI(),"12345678A");
    }

}