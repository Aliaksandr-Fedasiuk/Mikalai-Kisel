package com.epam.cdp.dao;

import com.epam.cdp.domain.Employee;

/**
 * @author kisel.nikolay@gmail.com
 * @since 07.12.2014
 */
public interface EmployeeDao {

    public void create(Employee employee);

    public Employee findById(Long id);

    public void remove(Employee employee);

    public void update(Employee employee);
}
