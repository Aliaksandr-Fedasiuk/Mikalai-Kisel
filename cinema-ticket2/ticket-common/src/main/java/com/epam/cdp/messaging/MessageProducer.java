package com.epam.cdp.messaging;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public interface MessageProducer {

    public void send(final String message) throws IOException;
}
