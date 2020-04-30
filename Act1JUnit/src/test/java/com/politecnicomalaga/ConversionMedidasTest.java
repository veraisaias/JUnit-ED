package com.politecnicomalaga;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionMedidasTest {
    ConversionMedidas conversion = new ConversionMedidas();

    @Test
    public void inchACm() {
        assertEquals(conversion.inchACm(1),2.54,0);
        assertEquals(conversion.inchACm(12),30.48,0);
    }

    @Test
    public void cmAInch() {
        assertEquals(conversion.cmAInch(2.54),1,0);
        assertEquals(conversion.cmAInch(12),4.72441,1);
        assertEquals(conversion.cmAInch(0),0,1);
        assertEquals(conversion.cmAInch(0.5),0.1968,1);
    }
}