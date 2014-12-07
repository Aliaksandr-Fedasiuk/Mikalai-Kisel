package com.epam.cdp.dao;

import com.epam.cdp.domain.Employee;
import com.epam.cdp.domain.Unit;
import com.epam.cdp.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * @author kisel.nikolay@gmail.com
 * @since 08.12.2014
 */
public class UnitDaoImpl implements UnitDao {

    private final EntityManager em = HibernateUtil.getEm();

    @Override
    public void create(Unit unit) {
        em.getTransaction().begin();
        em.persist(unit);
        em.getTransaction().commit();
    }

    @Override
    public Unit findById(Long id) {
        return em.find(Unit.class, id);
    }

    @Override
    public void remove(Unit unit) {
        em.getTransaction().begin();
        Unit mergedUnit = em.merge(unit);
        em.remove(mergedUnit);
        em.getTransaction().commit();
    }

    @Override
    public void update(Unit unit) {
        em.getTransaction().begin();
        em.merge(unit);
        em.getTransaction().commit();
    }

    @Override
    public void addEmployee(Long unitId, Long employeeId) {
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, employeeId);
        Unit unit = em.find(Unit.class, unitId);
        unit.getEmployees().add(employee);
        em.merge(unit);
        em.getTransaction().commit();
    }
}
