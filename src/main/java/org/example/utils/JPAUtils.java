package org.example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    public static  EntityManager getEntityManager(String unitName) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitName);
        return factory.createEntityManager();
    }
}
