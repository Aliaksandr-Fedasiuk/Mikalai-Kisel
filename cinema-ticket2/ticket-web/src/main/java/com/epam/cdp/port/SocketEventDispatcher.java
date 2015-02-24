package com.epam.cdp.port;

import com.epam.cdp.messaging.socket.MessageProducerSocketImpl;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 25 Feb, 2015
 */
public class SocketEventDispatcher extends AbstractEventDispatcher {

    public SocketEventDispatcher() throws IOException {
        super();
        this.messageProducer = MessageProducerSocketImpl.getMessageProducer();
    }

}
