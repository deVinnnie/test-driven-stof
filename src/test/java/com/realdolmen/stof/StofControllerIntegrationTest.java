package com.realdolmen.stof;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource(locations="classpath:test.properties")
public class StofControllerIntegrationTest {
    @Autowired
    StofController controller;

    @Autowired
    StofRepository repository;


    @Test
    public void testGetStof(){
        Stof stof = new Stof();
        stof.setNaam("Test3");
        stof.setNummer("STOF/1/2/3");

        repository.createStof(stof);

        Stof result = controller.getStof(stof.getId());

        Assert.assertEquals("Test3", result.getNaam());
        Assert.assertEquals("STOF/1/2/3",result.getNummer());
    }


}
