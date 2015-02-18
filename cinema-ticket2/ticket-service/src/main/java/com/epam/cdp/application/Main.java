package com.epam.cdp.application;

import com.epam.cdp.application.event.BuyTicketEventSubscriber;
import com.epam.cdp.application.event.DomainEventPublisher;
import com.epam.cdp.port.BuyTicketListener;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class Main {

    public static void main(String[] args) throws IOException {
        DomainEventPublisher.getInstance().subscribe(new BuyTicketEventSubscriber());
        BuyTicketListener buyTicketListener = new BuyTicketListener();

        while (true) {
            try {
                buyTicketListener.readMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
