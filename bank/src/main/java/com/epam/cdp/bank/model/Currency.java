package com.epam.cdp.bank.model;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class Currency {

    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String convertToString() {
        return id + ";" + name;
    }


}
