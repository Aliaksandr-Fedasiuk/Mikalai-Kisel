package com.epam.cdp.bank.dao;

import com.epam.cdp.bank.model.Account;

import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public interface AccountDao {

    public void save(final Account account);

    public List<Account> find();
}
