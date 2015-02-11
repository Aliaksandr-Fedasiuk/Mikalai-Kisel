package com.epam.cdp.cinema.transaction;

import com.epam.cdp.cinema.domain.User;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public interface Transaction {

    public void abort();

    public void commit();

    public Long beginTransaction();

    public void createSavepoint(final User user, Double cost);

}
