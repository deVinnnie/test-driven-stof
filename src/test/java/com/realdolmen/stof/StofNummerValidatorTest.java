package com.realdolmen.stof;

import com.realdolmen.stof.StofNummerValidator;
import static org.junit.Assert.*;

import org.junit.Test;

public class StofNummerValidatorTest {

    @Test
    public void testValidatorStofNummer(){
        StofNummerValidator validator = new StofNummerValidator();
        assertEquals(false, validator.validateStofNummer("Hello"));
        assertEquals(true, validator.validateStofNummer("STOF/1/2/3"));
        assertEquals(false, validator.validateStofNummer("STOF/2/3"));
        assertEquals(false, validator.validateStofNummer(null));
        assertEquals(true, validator.validateStofNummer("STOF/A/B/C"));
        assertEquals(false, validator.validateStofNummer("STOF/AA/B/C"));
        assertEquals(false, validator.validateStofNummer("STOF/11/2/3"));
        assertEquals(false, validator.validateStofNummer("STOF/15/22/31"));
        assertEquals(false, validator.validateStofNummer("STOF/15/2/31"));
        assertEquals(false, validator.validateStofNummer("STOF/1/2/31"));
    }

}
