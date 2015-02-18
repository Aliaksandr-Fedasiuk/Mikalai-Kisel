package com.epam.cdp.domain.model;

import com.epam.cdp.application.event.DomainEventPublisher;
import com.epam.cdp.events.BuyTicketCompleteEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class User {
    private static Long userGlobalCounter = 0L;

    public User() {
        userGlobalCounter++;
        id = userGlobalCounter;
    }

    private Long id;
    private String name;
    private String password;
    private double balance;
    private List<Order> orders;

    public void inform(String status, int place) {
        DomainEventPublisher.getInstance().publish(new BuyTicketCompleteEvent(name, place, status));
    }

    public Long getId() {
        return id;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
