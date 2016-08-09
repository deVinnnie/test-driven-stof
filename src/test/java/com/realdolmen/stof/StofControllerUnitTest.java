package com.realdolmen.stof;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StofControllerUnitTest {

    @InjectMocks
    StofController controller = new StofController();

    @Mock
    StofRepository stofRepository;

    List<Stof> repoStoffen = new ArrayList<>();

    @Before
    public void setUp(){
        // Actually: We're just reimplementing the repository.... the hard way.
        // In real life: use a dummy database and forget the mocking.
        MockitoAnnotations.initMocks(this);
        Mockito.when(stofRepository.createStof(Mockito.any(Stof.class))).thenAnswer(new Answer<Stof>(){
            @Override
            public Stof answer(InvocationOnMock invocationOnMock) throws Throwable {
                Stof stof = invocationOnMock.getArgumentAt(0, Stof.class);
                stof.setId(new Random().nextLong());
                repoStoffen.add(stof);
                return stof;
            }
        });
        Mockito.when(stofRepository.getStof(Mockito.anyLong())).then(new Answer<Stof>() {
            @Override
            public Stof answer(InvocationOnMock invocationOnMock) throws Throwable {
                Long stofId = invocationOnMock.getArgumentAt(0, Long.class);
                /*Stof stof = new Stof();
                stof.setId(stofId);
                stof.setNaam("Test");
                stof.setNummer("nummer");*/
                for(Stof stof : repoStoffen){
                    if(stof.getId().equals(stofId)){
                        return stof;
                    }
                }
                return null;
            }
        });
        /*Mockito.when(stofRepository.deleteStof(Mockito.any(Stof.class))).then(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                Stof stof = invocationOnMock.getArgumentAt(0, Stof.class);
                for(int i = 0; i < repoStoffen.size(); i++){
                    Stof fStof = repoStoffen.get(i);

                    if (fStof.getId().equals(stof.getId())){
                        repoStoffen.remove(i);
                        break;
                    }
                }

                return null;
            }
        });*/
        Mockito.when(stofRepository.updateStof(Mockito.any(Stof.class))).then(new Answer<Stof>() {
            @Override
            public Stof answer(InvocationOnMock invocationOnMock) throws Throwable {
                Stof update = invocationOnMock.getArgumentAt(0, Stof.class);

                Stof stof = stofRepository.getStof(update.getId());

                stof.setNaam(update.getNaam());
                stof.setNummer(update.getNummer());

                return stof;
            }
        });
    }

    @Test
    public void testGetStof(){
        // 1. create stof
        Stof stof= new Stof();
        stof.setNaam("Test");
        stof.setNummer("Test");

        stofRepository.createStof(stof);
        
        // 2. Get Stof via Controller
        controller.getStof(stof.getId());

        // 3. Assertions
        Assert.assertEquals("Test", stof.getNummer());
        Assert.assertEquals("Test", stof.getNaam());
    }

    @Test
    public void testCreateStof(){
        Stof stof = new Stof();
        stof.setNaam("Test");
        stof.setNummer("STOF/1/2/3");

        stof = controller.createStof(stof);

        Assert.assertEquals("Test", stof.getNaam());
        Assert.assertEquals("STOF/1/2/3", stof.getNummer());
        Assert.assertEquals(1, repoStoffen.size());
    }

    @Test
    public void testDeleteStof(){



    }


    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStof_throws_Exception(){
        Stof invalid = new Stof();
        invalid.setNaam("invalid");
        invalid.setNummer("foute nummer");

        controller.createStof(invalid);
    }
}
