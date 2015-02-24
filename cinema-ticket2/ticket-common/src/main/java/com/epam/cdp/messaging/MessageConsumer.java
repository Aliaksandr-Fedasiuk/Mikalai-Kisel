package com.epam.cdp.messaging;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 18 Feb, 2015
 */
public interface MessageConsumer {

    public String receiveMessage() throws InterruptedException;
}
