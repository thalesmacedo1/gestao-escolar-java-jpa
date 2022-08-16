package org.gestaoescolar.dao;

import javax.persistence.*;

public class JPAUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoEscolar");

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
