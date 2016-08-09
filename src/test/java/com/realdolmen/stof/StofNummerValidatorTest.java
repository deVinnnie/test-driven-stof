package com.realdolmen.stof;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StofNummerValidatorTest {

    StofNummerValidator validator;

    @Before
    public void setUp(){
         this.validator = new StofNummerValidator();
    }

    @Test
    public void testValidateStofNummer_valid_stof_nummer_returns_true() {
        assertEquals(true, validator.validateStofNummer("STOF/1/2/3"));
        assertEquals(true, validator.validateStofNummer("STOF/A/B/C"));
    }

    @Test
    public void testValidateStofNummer_invalid_stof_nummer_returns_false(){
        assertEquals(false, validator.validateStofNummer("Hello"));
        assertEquals(false, validator.validateStofNummer("STOF/2/3"));
        assertEquals(false, validator.validateStofNummer("STOF/AA/B/C"));
        assertEquals(false, validator.validateStofNummer("STOF/11/2/3"));
        assertEquals(false, validator.validateStofNummer("STOF/15/22/31"));
        assertEquals(false, validator.validateStofNummer("STOF/15/2/31"));
        assertEquals(false, validator.validateStofNummer("STOF/1/2/31"));
    }

    @Test
    public void testValidateStofNummer_null_value_returns_false(){
        assertEquals(false, validator.validateStofNummer(null));
    }

    @Test
    public void testValidateStofNummer_empty_value_returns_false(){
        assertEquals(false, validator.validateStofNummer(""));
    }
}
