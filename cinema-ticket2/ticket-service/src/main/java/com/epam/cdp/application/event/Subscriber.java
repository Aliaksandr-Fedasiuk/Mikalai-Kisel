package com.epam.cdp.application.event;

import com.epam.cdp.events.Event;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public interface Subscriber {

    public void handleEvent(Event event);

    public Class subscribedToEventType();
}
