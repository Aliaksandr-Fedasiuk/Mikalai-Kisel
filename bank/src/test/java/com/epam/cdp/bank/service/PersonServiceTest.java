package com.epam.cdp.bank.service;

import com.epam.cdp.bank.dao.PersonDaoImpl;
import com.epam.cdp.bank.exception.BankException;
import com.epam.cdp.bank.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class PersonServiceTest {

    @InjectMocks
    private PersonServiceImpl personService;
    @Mock
    private PersonDaoImpl personDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Person person = new Person();
        person.setId(2L);
        person.setName("Petr");
        person.setSurname("Petrov");

        personService.save(person);

        verify(personDao, times(1)).save(person);
    }

    @Test(expected = BankException.class)
    public void testSaveIfException() {
        personService.save(null);
    }

    @Test
    public void testFind() {
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person(1L, "Ivan", "Ivanov");
        Person person2 = new Person(2L, "Petr", "Petrov");
        persons.add(person1);
        persons.add(person2);

        when(personDao.find()).thenReturn(persons);

        List<Person> results = personService.find();
        assertNotNull(results);
        assertEquals(2, results.size());

        verify(personDao, times(1)).find();
    }

}
