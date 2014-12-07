package com.epam.cdp.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author kisel.nikolay@gmail.com
 * @since 07.12.2014
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findById", query = "select e from Employee e"),
})
public class Employee {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "employee_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;

    @ManyToMany
    @JoinTable(name = "employee_projects", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
