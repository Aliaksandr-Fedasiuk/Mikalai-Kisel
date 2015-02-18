package com.epam.cdp.events;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class BuyTicketInitEvent implements Event {

    private String name;
    private String password;
    private Integer place;

    public BuyTicketInitEvent(String name, String password, Integer place) {
        this.name = name;
        this.password = password;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}
