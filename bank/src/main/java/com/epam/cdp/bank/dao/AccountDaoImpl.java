package com.epam.cdp.bank.dao;

import com.epam.cdp.bank.file.FileGenerator;
import com.epam.cdp.bank.file.FileWorker;
import com.epam.cdp.bank.file.FileWorkerImpl;
import com.epam.cdp.bank.model.Account;
import com.epam.cdp.bank.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class AccountDaoImpl implements AccountDao {

    private FileWorker fileWorker;

    public AccountDaoImpl() throws IOException {
        //this.fileWorker = new FileWorkerImpl2(); the second implementation
        this.fileWorker = new FileWorkerImpl("/home/mikalai/account.txt");
    }

    @Override
    public void save(Account account) {
        FileGenerator fileGenerator = new FileGenerator(fileWorker, convertToString(account));
        fileGenerator.start();
    }

    @Override
    public List<Account> find() {
        List<String> accountStrings = fileWorker.read();
        List<Account> accounts = new ArrayList<>();
        for (String accountString : accountStrings) {
            accounts.add(createAccount(accountString));
        }

        return accounts;
    }

    public String convertToString(final Account account) {
        return account.getId() + ";" + account.getPerson().getId() + ";" + account.getAmount();
    }

    public Account createAccount(final String accountString) {
        Account account = new Account();
        String[] parts = accountString.split(";");
        if (parts.length == 3) {
            account.setId(Long.valueOf(parts[0]));
            account.setAmount(Double.valueOf(parts[2]));

            Person person = new Person();
            person.setId(Long.valueOf(parts[1]));

            account.setPerson(person);

        }

        return account;
    }
}
