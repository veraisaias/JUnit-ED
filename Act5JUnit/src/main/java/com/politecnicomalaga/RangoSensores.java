package com.politecnicomalaga;

import org.mockito.ArgumentMatcher;

public class RangoSensores implements ArgumentMatcher<Integer> {
    private Integer min;
    private Integer max;

    public RangoSensores(Integer min, Integer max){
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean matches(Integer integer) {
        return (integer >= min) && (integer <= max);
    }
}
