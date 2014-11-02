package com.epam.cdp.bank.dao;

import com.epam.cdp.bank.file.FileGenerator;
import com.epam.cdp.bank.file.FileWorker;
import com.epam.cdp.bank.file.FileWorkerImpl;
import com.epam.cdp.bank.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class PersonDaoImpl implements PersonDao {

    public static final String DEFAULT_FILE_NAME = "person.txt";

    private FileWorker fileWorker;

    public PersonDaoImpl() throws IOException {
        //this.fileWorker = new FileWorkerImpl2(); the second implementation
        this.fileWorker = new FileWorkerImpl(DEFAULT_FILE_NAME);
    }

    public PersonDaoImpl(final String fileName) {
        this.fileWorker = new FileWorkerImpl(fileName);
    }

    @Override
    public void save(Person person) {
        FileGenerator fileGenerator = new FileGenerator(fileWorker, convertToString(person));
        fileGenerator.start();
    }

    @Override
    public List<Person> find() {
        List<String> personsStrings = fileWorker.read();
        List<Person> persons = new ArrayList<>();
        for (String personString : personsStrings) {
            persons.add(createPerson(personString));
        }

        return persons;
    }

    public String convertToString(final Person person) {
        return person.getId() + ";" + person.getName() + ";" + person.getSurname();
    }

    public Person createPerson(final String personString) {
        Person person = new Person();
        String[] parts = personString.split(";");
        if (parts.length == 3) {
            person.setId(Long.valueOf(parts[0]));
            person.setName(parts[1]);
            person.setSurname(parts[2]);
        }

        return person;
    }
}
