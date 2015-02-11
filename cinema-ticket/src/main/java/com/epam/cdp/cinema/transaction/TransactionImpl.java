package com.epam.cdp.cinema.transaction;

import com.epam.cdp.cinema.database.EmbeddedDatabase;
import com.epam.cdp.cinema.domain.User;
import com.epam.cdp.cinema.domain.UserWrapper;

import java.util.Objects;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class TransactionImpl
        implements Transaction {
    private static Long globalTransactionId = 0L;

    private Long id;
    private UserWrapper savepoint;
    private Status status;

    @Override
    public void abort() {
        status = Status.aborted;
        if (savepoint != null) {
            if (savepoint.getCost() != null) {
                User user = EmbeddedDatabase.getUserById(savepoint.getId());
                user.setBalance(user.getBalance() + savepoint.getCost());
            }

            // if ( savepoint.getPlaces() != null ) {
            //
            // }
        }
    }

    @Override
    public void commit() {
        status = Status.completed;
    }

    @Override
    public Long beginTransaction() {
        globalTransactionId++;
        id = globalTransactionId;
        status = Status.started;
        return id;
    }

    @Override
    public void createSavepoint(final User user, Double cost) {
        UserWrapper newUserWrapper = convertUserToWrapper(user, cost);
        if (savepoint == null) {
            savepoint = newUserWrapper;
        } else {

            if (savepoint.getId() == null) {
                savepoint.setId(newUserWrapper.getId());
            } else {
                if (!Objects.equals(newUserWrapper.getId(), savepoint.getId())) {
                    throw new TransactionException(
                            "Cannot create savepoint. Objects ids are not equals");
                }
            }

            if (newUserWrapper.getCost() != null) {
                savepoint.setCost(newUserWrapper.getCost());
            }

            if (newUserWrapper.getPlaces() != null
                    && newUserWrapper.getPlaces().isEmpty()) {
                savepoint.setPlaces(newUserWrapper.getPlaces());
            }
        }
    }

    public UserWrapper convertUserToWrapper(User user, Double cost) {
        UserWrapper userWrapper = new UserWrapper();
        userWrapper.setId(user.getId());
        userWrapper.setCost(cost);

        return userWrapper;
    }

}
