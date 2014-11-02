package com.epam.cdp.bank.validator;

import com.epam.cdp.bank.model.Account;
import com.epam.cdp.bank.model.Person;
import org.apache.commons.lang3.StringUtils;

/**
 * @author kisel.nikolay@gmail.com
 * @since 02.11.2014
 */
public class Validator {

    public static boolean validatePerson(Person person) {
        if (person == null) {
            return false;
        }

        if (person.getId() == null || StringUtils.isBlank(person.getName()) || StringUtils.isBlank(person.getSurname())) {
            return false;
        }

        return true;
    }

    public static boolean validateAccount(Account account) {
        if (account == null) {
            return false;
        }

        if (account.getId() == null || account.getAmount() == null) {
            return false;
        }

        return true;
    }
}
