package com.epam.cdp.application.transaction;


import com.epam.cdp.domain.model.User;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public interface Transaction {

    public void abort();

    public void commit();

    public Long beginTransaction();

    public void createSavepoint(final User user, Double cost);

    public Status getStatus();

}
