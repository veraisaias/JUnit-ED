package com.politecnicomalaga;

import java.util.List;

public class PodaExtremos {

    public int podarMasProximo(int numero, List<Integer> listaNumeros){
        int masProximo = 0;
        int diferencia = Integer.MAX_VALUE;
        for (Integer in : listaNumeros){
            if (Math.abs((in - numero)) < diferencia){
                diferencia = Math.abs((in - numero));
                masProximo = in;
            }
        }
        return listaNumeros.remove(listaNumeros.indexOf(masProximo));
    }

    public int podarMasLejano(int numero, List<Integer> listaNumeros){
        int masLejano = 0;
        int diferencia = Integer.MIN_VALUE;
        for (Integer in : listaNumeros){
            if (Math.abs((in - numero)) > diferencia){
                diferencia = Math.abs((in - numero));
                masLejano = in;
            }
        }
        return listaNumeros.remove(listaNumeros.indexOf(masLejano));
    }
}