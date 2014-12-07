package com.epam.cdp.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author kisel.nikolay@gmail.com
 * @since 07.12.2014
 */
@Entity
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "personal_info_id")
    private Long id;

    private String description;

    @OneToOne(mappedBy = "personalInfo")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
