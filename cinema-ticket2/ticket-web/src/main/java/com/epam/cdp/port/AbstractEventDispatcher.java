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
 * @since 25 Feb, 2015
 */
public abstract class AbstractEventDispatcher {

    protected MessageProducer messageProducer;
    private Gson gson;

    public AbstractEventDispatcher() {
        gson = new Gson();
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
