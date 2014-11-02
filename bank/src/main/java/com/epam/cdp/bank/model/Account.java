package com.epam.cdp.bank.model;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class Account {

    private Long id;
    private Person person;
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", person=" + person +
                ", amount=" + amount +
                '}';
    }
}
