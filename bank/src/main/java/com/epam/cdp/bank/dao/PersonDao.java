package com.epam.cdp.bank.dao;

import com.epam.cdp.bank.model.Person;

import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public interface PersonDao {

    public void save(final Person person);

    public List<Person> find();
}
