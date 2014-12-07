package com.epam.cdp.domain;

import javax.persistence.Embeddable;

/**
 * @author kisel.nikolay@gmail.com
 * @since 07.12.2014
 */
@Embeddable
public class Address {

    private String street;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
