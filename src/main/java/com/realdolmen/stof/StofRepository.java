package com.realdolmen.stof;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Stof createStof(Stof stof){
        em.persist(stof);
        return stof;
    }

    public Stof getStof(Long stofId){
        return em.find(Stof.class, stofId);
    }

    @Transactional
    public Stof updateStof(Stof stof){
        em.merge(stof);
        return stof;
    }

    @Transactional
    public void deleteStof(Stof stof){
        em.remove(em.find(Stof.class, stof));
    }

    @Transactional
    public void deleteAll(){
        em.createNativeQuery("DELETE FROM Stof").executeUpdate();
    }
}
