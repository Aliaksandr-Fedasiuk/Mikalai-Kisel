package com.epam.cdp.cinema.domain;

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
