package com.epam.cdp.bank.service;

import com.epam.cdp.bank.dao.AccountDao;
import com.epam.cdp.bank.dao.AccountDaoImpl;
import com.epam.cdp.bank.exception.BankException;
import com.epam.cdp.bank.model.Account;
import com.epam.cdp.bank.validator.Validator;

import java.io.IOException;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl() throws IOException {
        this.accountDao = new AccountDaoImpl();
    }

    @Override
    public void save(Account account) {
        if (Validator.validateAccount(account)) {
            accountDao.save(account);
        } else {
            throw new BankException("Invalid data for account!");
        }
    }

    @Override
    public List<Account> find() {
        List<Account> accounts = accountDao.find();
        return accounts;
    }
}
