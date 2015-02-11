package com.epam.cdp.cinema.transaction;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class TransactionManager
{

  private ConcurrentHashMap<Long, Transaction> transactions = new ConcurrentHashMap<>();

  public Transaction getTransaction( Long id )
  {
    return transactions.get( id );
  }

  public Long startTransaction()
  {
    final Transaction transaction = new TransactionImpl();
    Long id = transaction.beginTransaction();
    transactions.put( id, transaction );

    return id;
  }
}
