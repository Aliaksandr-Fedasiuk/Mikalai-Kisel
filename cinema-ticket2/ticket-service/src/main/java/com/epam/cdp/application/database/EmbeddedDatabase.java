package com.epam.cdp.application.database;

import com.epam.cdp.domain.model.Order;
import com.epam.cdp.domain.model.ShowTime;
import com.epam.cdp.domain.model.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class EmbeddedDatabase {

    private static ConcurrentHashMap<Long, User> users;
    private static ConcurrentHashMap<Long, Order> orders;
    private static ConcurrentHashMap<Long, ShowTime> showTimes;

    static {
        users = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
        showTimes = new ConcurrentHashMap<>();
        ShowTime defaultShowTime = new ShowTime();
        defaultShowTime.setName("Batman");
        defaultShowTime.setCost(10D);
        defaultShowTime.setMaxSeatsCount(100);
        defaultShowTime.setBusySeats(new CopyOnWriteArrayList<Integer>());
        showTimes.put(0L, defaultShowTime);
    }

    public static User getUserById(Long id) {
        return users.get(id);
    }

    public static void addUser(User user) {
        users.put(user.getId(), user);
    }

    public static ShowTime getShowTime(Long id) {
        return showTimes.get(id);
    }


}
