package com.epam.cdp.dao;

import com.epam.cdp.domain.Unit;

/**
 * @author kisel.nikolay@gmail.com
 * @since 08.12.2014
 */
public interface UnitDao {

    public void create(Unit unit);

    public Unit findById(Long id);

    public void remove(Unit unit);

    public void update(Unit unit);

    public void addEmployee(Long unitId, Long employeeId);

}
