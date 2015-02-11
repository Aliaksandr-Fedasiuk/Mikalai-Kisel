package com.epam.cdp.cinema.transaction;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public interface Transaction
{

  public void abort( Long transactionId );

  public void commit( Long transactionId );

  public Long beginTransaction();

  public void createSavepoint( final Object object );

}
