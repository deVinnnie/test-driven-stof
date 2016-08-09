package com.realdolmen.stof;

import com.realdolmen.stof.StofNummerValidator;
import static org.junit.Assert.*;

import org.junit.Test;

public class StofNummerValidatorTest {

    @Test
    public void testValidatorStofNummer(){
        StofNummerValidator validator = new StofNummerValidator();
        assertEquals(false, validator.validateStofNummer("Hello"));
        assertEquals(false, validator.validateStofNummer("STOF/1/2/3"));
        assertEquals(false, validator.validateStofNummer("STOF/2/3"));
        assertEquals(false, validator.validateStofNummer(null));
        assertEquals(true, validator.validateStofNummer("STOF/A/B/C"));
    }

}
