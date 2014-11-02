package com.epam.cdp.bank.dao;

import com.epam.cdp.bank.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class PersonDaoTest {

    private PersonDao personDao;

    @Before
    public void setUp() throws IOException {
        personDao = new PersonDaoImpl("test-person.txt");
    }

    @Test
    public void testSave() throws InterruptedException {
        Person person = new Person();
        person.setId(2L);
        person.setName("Petr");
        person.setSurname("Petrov");

        personDao.save(person);

        //give time for thread that writes data to file.
        Thread.sleep(200);
    }

    @Test
    public void testFind() {
        List<Person> persons = personDao.find();
        assertNotNull(persons);
        Person firstPerson = persons.get(0);
        assertNotNull(firstPerson);
        assertEquals("Mikalai", firstPerson.getName());
        assertEquals("Kisel", firstPerson.getSurname());
    }
}
