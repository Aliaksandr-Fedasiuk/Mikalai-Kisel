package com.epam.cdp.cinema.service;

import com.epam.cdp.cinema.database.EmbeddedDatabase;
import com.epam.cdp.cinema.domain.ShowTime;
import com.epam.cdp.cinema.domain.User;
import com.epam.cdp.cinema.transaction.Transaction;
import com.epam.cdp.cinema.transaction.TransactionManager;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class TicketService {
    public static final double DEFAULT_BALANCE = 10000d;
    private TransactionManager transactionManager = new TransactionManager();

    public Long registerUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setBalance(DEFAULT_BALANCE);

        EmbeddedDatabase.addUser(user);

        return user.getId();
    }

    public void buyTickets(long userId, int place) {
        Long trId = transactionManager.startTransaction();
        Transaction transaction = transactionManager.getTransaction(trId);
        try {
            User user = EmbeddedDatabase.getUserById(userId);
            // Get the first showTime
            ShowTime showTime = EmbeddedDatabase.getShowTime(0L);
            double cost = showTime.getCost();
            user.setBalance(user.getBalance() - cost);
            transaction.createSavepoint(user, cost);
            addPlace(showTime, place);
            transaction.commit();
        } catch (Exception ex) {
            transaction.abort();
        }

    }

    private void addPlace(ShowTime showTime, int place) throws Exception {
        if (Math.random() < 0.5) {
            throw new Exception("Dummy exception");
        }
        CopyOnWriteArrayList<Integer> busySeats = showTime.getBusySeats();
        busySeats.add(place);
    }


}
