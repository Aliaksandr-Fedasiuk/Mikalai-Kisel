package com.epam.cdp.cinema.domain;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class User
{
  private static Long userGlobalCounter = 0L;

  public User()
  {
    userGlobalCounter++;
    id = userGlobalCounter;
  }

  private Long id;
  private String name;
  private String password;
  private double balance;

  public Long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword( String password )
  {
    this.password = password;
  }

  public double getBalance()
  {
    return balance;
  }

  public void setBalance( double balance )
  {
    this.balance = balance;
  }
}
