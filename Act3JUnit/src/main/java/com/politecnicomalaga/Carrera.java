package com.politecnicomalaga;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private List<String> participantes;

    public Carrera(){
        participantes = new ArrayList<String>();
    }

    public boolean addParticipante(String nombreParticipante){
        boolean insercionCorrecta = false;
        if (!participantes.contains(nombreParticipante)) {
            participantes.add(nombreParticipante);
            insercionCorrecta = true;
        }
        return insercionCorrecta;
    }

    public List<String> getListadoParticipantes(){
        if (participantes.isEmpty())
            return null;
        return participantes;
    }

    public int getTotalParticipates(){
        return participantes.size();
    }

    public List<String> cloneCarrera(){
        return new ArrayList<String>(participantes);
    }

    public void setPosicion(String nombreParticipante, int posicionDestino){
        participantes.remove(nombreParticipante);
        participantes.add(posicionDestino,nombreParticipante);
    }

    public String getParticipantePorPosicion(int posicion){
        return participantes.get(posicion);
    }

}
