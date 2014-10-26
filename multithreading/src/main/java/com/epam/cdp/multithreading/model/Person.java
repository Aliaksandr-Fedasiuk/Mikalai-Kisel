package com.epam.cdp.multithreading.model;

/**
 * @author kisel.nikolay@gmail.com
 * @since 26.10.2014
 */
public class Person {

    private String name;
    private String surname;

    public Person() {
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String convertToString() {
        return name + ";" + surname;
    }

    public static Person createPerson(final String personString) {
        Person person = new Person();
        String[] parts = personString.split(";");
        if (parts.length == 2) {
            person.setName(parts[0]);
            person.setSurname(parts[1]);
        }

        return person;
    }
}
