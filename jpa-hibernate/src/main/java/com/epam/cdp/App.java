package com.epam.cdp;

import com.epam.cdp.dao.*;
import com.epam.cdp.domain.*;
import com.epam.cdp.util.HibernateUtil;

/**
 * @author kisel.nikolay@gmail.com
 * @since 08.12.2014
 */
public class App {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        ProjectDao projectDao = new ProjectDaoImpl();
        UnitDao unitDao = new UnitDaoImpl();

        Employee employee = new Employee();
        employee.setName("Mikalai");
        employee.setStatus(EmployeeStatus.FULL_TIME);

        Address address = new Address();
        address.setCity("Brest");

        employee.setAddress(address);

        employeeDao.create(employee);

        final Employee findEmployee = employeeDao.findById(1L);

        Unit unit = new Unit();
        unit.setName("Java");

        unitDao.create(unit);
        unitDao.addEmployee(1L, 1L);

        Unit findUnit = unitDao.findById(1L);

        Project project = new Project();
        project.setName("New Project");

        projectDao.create(project);

        Project findProject = projectDao.findById(1L);

        HibernateUtil.closeResources();
    }
}
