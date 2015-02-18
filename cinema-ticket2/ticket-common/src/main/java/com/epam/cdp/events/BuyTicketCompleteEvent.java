package com.epam.cdp.events;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class BuyTicketCompleteEvent implements Event {

    private String name;
    private Integer place;
    private String status;

    public BuyTicketCompleteEvent(String name, Integer place, String status) {
        this.name = name;
        this.place = place;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullDescription() {
        return "Transaction is finished with status: " + status + "\n Name: " + name + " Place: " + place;
    }
}
