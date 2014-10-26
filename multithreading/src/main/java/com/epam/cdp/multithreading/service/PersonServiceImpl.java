package com.epam.cdp.multithreading.service;

import com.epam.cdp.multithreading.file.FileGenerator;
import com.epam.cdp.multithreading.file.FileWorker;
import com.epam.cdp.multithreading.file.FileWorkerImpl;
import com.epam.cdp.multithreading.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 26.10.2014
 */
public class PersonServiceImpl implements PersonService {

    private FileWorker fileWorker;

    public PersonServiceImpl() throws IOException {
        //this.fileWorker = new FileWorkerImpl2(); the second implementation
        this.fileWorker = new FileWorkerImpl();
    }

    @Override
    public void save(Person person) {
        FileGenerator fileGenerator = new FileGenerator(fileWorker, person.convertToString());
        fileGenerator.start();
    }

    @Override
    public List<Person> find() {
        List<String> personsStrings = fileWorker.read();
        List<Person> persons = new ArrayList<>();
        for (String personString : personsStrings) {
            persons.add(Person.createPerson(personString));
        }

        return persons;
    }
}
