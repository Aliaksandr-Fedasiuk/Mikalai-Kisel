package com.epam.cdp.cinema.database;

import com.epam.cdp.cinema.domain.Order;
import com.epam.cdp.cinema.domain.ShowTime;
import com.epam.cdp.cinema.domain.User;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class EmbeddedDatabase
{

  private ConcurrentHashMap<Long, User> users;
  private ConcurrentHashMap<Long, Order> orders;
  private ConcurrentHashMap<Long, ShowTime> showTimes;

  public EmbeddedDatabase()
  {
     users = new ConcurrentHashMap<>();
     orders = new ConcurrentHashMap<>();
     showTimes = new ConcurrentHashMap<>();
  }


}
