package com.realdolmen.stof;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StofTest {
    @Test
    public void testIsValid(){
        Stof stof = new Stof();
        stof.setNaam("NaCl");
        stof.setNummer("STOF/1/2/3");

        assertEquals(true, stof.isValid());

        stof = new Stof();
        assertEquals(false, stof.isValid());
    }
}
