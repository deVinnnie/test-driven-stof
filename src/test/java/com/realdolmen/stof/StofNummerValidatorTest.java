package com.realdolmen.stof;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StofNummerValidatorTest {

    @Test
    public void testValidatorStofNummer(){
        StofNummerValidator validator = new StofNummerValidator();
        assertEquals(true, validator.validateStofNummer("STOF/1/2/3"));
        assertEquals(true, validator.validateStofNummer("STOF/A/B/C"));
        assertEquals(false, validator.validateStofNummer("Hello"));
        assertEquals(false, validator.validateStofNummer(null));

        assertEquals(false, validator.validateStofNummer("STOF/2/3"));
        assertEquals(false, validator.validateStofNummer("STOF/AA/B/C"));
        assertEquals(false, validator.validateStofNummer("STOF/11/2/3"));
        assertEquals(false, validator.validateStofNummer("STOF/15/22/31"));
        assertEquals(false, validator.validateStofNummer("STOF/15/2/31"));
        assertEquals(false, validator.validateStofNummer("STOF/1/2/31"));
    }

}
