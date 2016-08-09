package com.realdolmen.stof;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource(locations="classpath:test.properties")
public class StofRepositoryTest {

    @Autowired
    StofRepository stofRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void setUp(){
        stofRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testCreateStof(){
        // 1. Check if database is empty
        assertStofCount(0);

        // 2. Create Stof instance and persist
        Stof stof = new Stof();
        stof.setNaam("Test");
        stof.setNummer("STOF/1/2/3");

        stofRepository.createStof(stof);

        // 3. Check if stof if persisted.
        assertNotEquals(null, stof.getId());
    }

    @Test
    @Transactional
    public void testUpdateStof(){
        /*Stof stof = new Stof();
        stof.setNaam("Test");
        stof.setNummer("STOF/1/2/3");*/

        assertStofCount(0);

        entityManager.createNativeQuery("INSERT INTO Stof(naam, nummer) VALUES('TEST 2', 'TESTS/1/2/3')").executeUpdate();
        assertStofCount(1);
        Stof stof = (Stof) entityManager.createNativeQuery("SELECT * FROM Stof WHERE naam = 'TEST 2'", Stof.class).getSingleResult();

        assertEquals("TEST 2", stof.getNaam());
        assertEquals("TESTS/1/2/3", stof.getNummer());

        System.out.println("----------------------" + stof.getId());

        stof.setNaam("Hello World");
        stof.setNummer("TESTS/1/2/3");

        stofRepository.updateStof(stof);
        stofRepository.getStof(stof.getId());

        Stof updatedStof = (Stof) entityManager.createNativeQuery("SELECT * FROM Stof WHERE naam = 'Hello World'", Stof.class).getSingleResult();

        assertEquals("Hello World", updatedStof.getNaam());
        assertEquals("TESTS/1/2/3", updatedStof.getNummer());
    }

    @Test
    @Transactional
    public void testDeleteStof(){
        /*assertStofCount(0);

        Stof stof = new Stof();
        stof.setNaam("Test");
        stof.setNummer("STOF/1/2/3");

        stof = stofRepository.createStof(stof);

        assertStofCount(1);

        stofRepository.deleteStof(stof);

        assertStofCount(0);*/
    }

    private void assertStofCount(int count){
        Object result = entityManager.createNativeQuery("SELECT COUNT(1) FROM Stof").getSingleResult();
        Assert.assertEquals(new BigInteger("" + count), result);
    }
}
