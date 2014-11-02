package com.epam.cdp.bank;

import com.epam.cdp.bank.model.Person;
import com.epam.cdp.bank.service.PersonService;
import com.epam.cdp.bank.service.PersonServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * App main class.
 */
public class App {

    public static void main(String[] args) throws IOException {
        PersonService personService = new PersonServiceImpl();

        Person person1 = new Person("Mikalai", "Kisel");
        Person person2 = new Person("Ivan", "Ivanov");
        personService.save(person1);
        personService.save(person2);

        List<Person> resultList = personService.find();

        for (Person person : resultList) {
            System.out.println(person);
        }

        Person person3 = new Person("Petr", "Petrovich");
        personService.save(person3);

        resultList = personService.find();

        for (Person person : resultList) {
            System.out.println(person);
        }

    }
}
