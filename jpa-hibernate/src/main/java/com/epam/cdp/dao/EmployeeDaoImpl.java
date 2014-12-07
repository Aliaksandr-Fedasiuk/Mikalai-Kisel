package com.epam.cdp.dao;

import com.epam.cdp.domain.Employee;
import com.epam.cdp.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * @author kisel.nikolay@gmail.com
 * @since 07.12.2014
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager em = HibernateUtil.getEm();

    @Override
    public void create(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }

    @Override
    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void remove(Employee employee) {
        em.getTransaction().begin();
        Employee mergedEmployee = em.merge(employee);
        em.remove(mergedEmployee);
        em.getTransaction().commit();
    }

    @Override
    public void update(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }
}
