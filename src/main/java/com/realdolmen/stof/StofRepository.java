package com.realdolmen.stof;

import com.realdolmen.stof.Stof;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository(value= "stofRepository")
public class StofRepository {

    @PersistenceContext
    private EntityManager em;

    public Stof createStof(Stof stof){
        em.persist(stof);
        return stof;
    }

    public Stof getStof(Long stofId){
        return em.find(Stof.class, stofId);
    }

    public Stof updateStof(Stof stof){
        em.merge(stof);
        return stof;
    }

    public void deleteStof(Stof stof){
        em.remove(stof);
    }
}
