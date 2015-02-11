package com.epam.cdp.cinema.domain;

/**
 * @author mikalai.kisel@ihg.com
 * @since Feb 10, 2015.
 */
public class Order
{
  private static Long orderGlobalCounter = 0L;

  private Long orderId;
  private Long userId;
  private Long showTimeId;

  public Order()
  {
    orderGlobalCounter++;
    orderId = orderGlobalCounter;
  }

  public Long getUserId()
  {
    return userId;
  }

  public void setUserId( Long userId )
  {
    this.userId = userId;
  }

  public Long getShowTimeId()
  {
    return showTimeId;
  }

  public void setShowTimeId( Long showTimeId )
  {
    this.showTimeId = showTimeId;
  }
}
