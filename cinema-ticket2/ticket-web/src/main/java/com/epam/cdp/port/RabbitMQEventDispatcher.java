package com.epam.cdp.port;

import com.epam.cdp.messaging.rabbitmq.MessageProducerImpl;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public class RabbitMQEventDispatcher extends AbstractEventDispatcher {

    public RabbitMQEventDispatcher() throws IOException {
        super();
        this.messageProducer = new MessageProducerImpl("TicketExchange");
    }

}
