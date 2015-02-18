package com.epam.cdp.application.event;

import com.epam.cdp.events.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class DomainEventPublisher {

    private static final DomainEventPublisher publisher = new DomainEventPublisher();

    private List<Subscriber> subscribers;

    private DomainEventPublisher() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        if (subscribers == null) {
            subscribers = new ArrayList<>();
        }
        subscribers.add(subscriber);
    }

    public void publish(Event event) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.subscribedToEventType() == event.getClass()) {
                subscriber.handleEvent(event);
            }
        }
    }

    public static DomainEventPublisher getInstance() {
        return publisher;
    }
}
