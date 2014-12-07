package com.epam.cdp.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author kisel.nikolay@gmail.com
 * @since 07.12.2014
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "project_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "employee_projects", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
