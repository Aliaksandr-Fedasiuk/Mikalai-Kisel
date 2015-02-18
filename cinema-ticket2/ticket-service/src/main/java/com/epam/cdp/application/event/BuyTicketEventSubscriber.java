package com.epam.cdp.application.event;

import com.epam.cdp.events.BuyTicketCompleteEvent;
import com.epam.cdp.events.Event;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class BuyTicketEventSubscriber implements Subscriber {

    @Override
    public void handleEvent(Event event) {
        BuyTicketCompleteEvent buyTicketCompleteEvent = (BuyTicketCompleteEvent) event;
        System.out.println(buyTicketCompleteEvent.getFullDescription());
    }

    @Override
    public Class subscribedToEventType() {
        return BuyTicketCompleteEvent.class;
    }
}
