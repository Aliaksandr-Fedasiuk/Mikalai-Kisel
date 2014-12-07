package com.epam.cdp.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {

    private static final String PERSISTENT_UNIT_NAME = "item-manager-pu";

    private static final EntityManagerFactory emf;
    private static final EntityManager em;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
            em = emf.createEntityManager();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void closeResources() {
        em.close();
        emf.close();
    }

}