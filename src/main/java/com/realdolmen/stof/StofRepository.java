package com.realdolmen.stof;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The StofRepository contains many Stof.
 * Some are very dangerous and should be treated with care.
 * Others are mostly harmless.
 */
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
