package com.epam.cdp.port;

import com.epam.cdp.application.service.TicketService;
import com.epam.cdp.events.BuyTicketInitEvent;
import com.epam.cdp.messaging.MessageConsumer;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class BuyTicketListener {

    private MessageConsumer messageConsumer;
    private Gson gson = new Gson();
    private TicketService ticketService = new TicketService();

    public BuyTicketListener() throws IOException {
        this.messageConsumer = new MessageConsumer("TicketExchange");
    }

    public void readMessage() throws InterruptedException {
        final String message = messageConsumer.receiveMessage();
        ticketService.buyTicket(gson.fromJson(message, BuyTicketInitEvent.class));
    }
}
