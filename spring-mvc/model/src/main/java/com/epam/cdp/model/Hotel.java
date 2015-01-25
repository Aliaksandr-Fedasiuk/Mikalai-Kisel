package com.epam.cdp.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 25 Jan, 2015
 */
@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "hotel_id")
    private Long id;

    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "country_name")
    private String countryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
