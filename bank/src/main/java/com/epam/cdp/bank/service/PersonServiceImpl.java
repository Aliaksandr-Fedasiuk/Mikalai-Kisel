package com.epam.cdp.bank.service;

import com.epam.cdp.bank.dao.PersonDao;
import com.epam.cdp.bank.dao.PersonDaoImpl;
import com.epam.cdp.bank.exception.BankException;
import com.epam.cdp.bank.model.Person;
import com.epam.cdp.bank.validator.Validator;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 26.10.2014
 */
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonServiceImpl() throws IOException {
        //this.fileWorker = new FileWorkerImpl2(); the second implementation
        this.personDao = new PersonDaoImpl();
    }

    @Override
    public void save(Person person) {
        if (Validator.validatePerson(person)) {
            personDao.save(person);
        } else {
            throw new BankException("Invalid data for person!");
        }
    }

    @Override
    public List<Person> find() {
        List<Person> persons = personDao.find();
        Collections.sort(persons, new PersonComparator());
        return persons;
    }

    private class PersonComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getSurname().compareTo(p2.getSurname());
        }
    }
}
