package com.epam.cdp.application;

import com.epam.cdp.events.BuyTicketInitEvent;
import com.epam.cdp.events.Event;
import com.epam.cdp.port.AbstractEventDispatcher;
import com.epam.cdp.port.RabbitMQEventDispatcher;
import com.epam.cdp.port.SocketEventDispatcher;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class TicketService {

    private AbstractEventDispatcher dispatcher;

    public TicketService() {
        try {
//            this.dispatcher = new RabbitMQEventDispatcher();
            this.dispatcher = new SocketEventDispatcher();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buyTicket(final String name, final String password, int place) {
        final Event event = new BuyTicketInitEvent(name, password, place);
        dispatcher.dispatch(event);
    }
}
