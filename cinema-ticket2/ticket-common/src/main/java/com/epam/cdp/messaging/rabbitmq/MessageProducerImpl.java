package com.epam.cdp.messaging.rabbitmq;

import com.epam.cdp.messaging.MessageProducer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 24 Feb, 2015
 */
public class MessageProducerImpl implements MessageProducer {

    public static final String EXCHANGE_TYPE = "fanout";

    private Channel channel;
    private String exchangeName;

    public MessageProducerImpl(final String exchangeName) throws IOException {
        this.exchangeName = exchangeName;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        this.channel = connection.createChannel();

        this.channel.exchangeDeclare(exchangeName, EXCHANGE_TYPE);
    }

    public void send(final String message) throws IOException {
        channel.basicPublish(exchangeName, "", null, message.getBytes());
    }
}
