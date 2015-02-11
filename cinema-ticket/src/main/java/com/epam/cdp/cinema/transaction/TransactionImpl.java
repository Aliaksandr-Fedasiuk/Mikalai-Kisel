package com.epam.cdp.cinema.transaction;

import com.epam.cdp.cinema.domain.UserWrapper;

import java.util.Objects;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class TransactionImpl
  implements Transaction
{
  private static Long globalTransactionId = 0L;

  private Long id;
  private UserWrapper savepoint;

  @Override
  public void abort( Long transactionId )
  {

  }

  //TODO we need to remove transaction from manager after this method
  @Override
  public void commit( Long transactionId )
  {
    savepoint = null;
  }

  @Override
  public Long beginTransaction()
  {
    globalTransactionId++;
    id = globalTransactionId;
    return id;
  }

  @Override
  public void createSavepoint( final Object object )
  {
    UserWrapper newUserWrapper = (UserWrapper)object;
    if ( savepoint == null ) {
      savepoint = newUserWrapper;
    } else {

      if ( savepoint.getId() == null ) {
        savepoint.setId( newUserWrapper.getId() );
      } else {
        if ( !Objects.equals( newUserWrapper.getId(), savepoint.getId() ) ) {
          throw new TransactionException(
            "Cannot create savepoint. Objects ids are not equals" );
        }
      }

      if ( newUserWrapper.getCost() != null ) {
        savepoint.setCost( newUserWrapper.getCost() );
      }

      if ( newUserWrapper.getPlaces() != null
        && newUserWrapper.getPlaces().isEmpty() ) {
        savepoint.setPlaces( newUserWrapper.getPlaces() );
      }
    }
  }
}
