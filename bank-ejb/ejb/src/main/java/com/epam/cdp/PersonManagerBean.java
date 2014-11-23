package com.epam.cdp;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 23.11.2014
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonManagerBean implements PersonManager {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void savePerson(Person person) {
        em.persist(person);
    }

    @Override
    public List getPersons() {
        Query query = em.createQuery("from Person");
        return query.getResultList();
    }
}
