package com.realdolmen.stof;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.math.BigInteger;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource(locations="classpath:test.properties")
public class StofRepositoryTest {


    @Autowired
    StofRepository stofRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
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

    private void assertStofCount(int count){
        Object result = entityManager.createNativeQuery("SELECT COUNT(1) FROM Stof").getSingleResult();
        Assert.assertEquals(new BigInteger("" + count), result);
    }
}
