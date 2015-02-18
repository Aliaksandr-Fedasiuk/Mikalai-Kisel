package com.epam.cdp.port;

import com.epam.cdp.events.Event;
import com.epam.cdp.messaging.MessageProducer;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class RabbitMQEventDispatcher {

    private MessageProducer messageProducer;
    private Gson gson;

    public RabbitMQEventDispatcher() throws IOException {
        this.messageProducer = new MessageProducer("TicketExchange");
        this.gson = new Gson();
    }

    public void dispatch(Event event) {
        String message = gson.toJson(event);
        try {
            messageProducer.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
