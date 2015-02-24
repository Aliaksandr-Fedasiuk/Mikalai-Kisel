package com.epam.cdp.messaging.socket;

import com.epam.cdp.messaging.MessageConsumer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 25 Feb, 2015
 */
public class MessageConsumerSocketImpl implements MessageConsumer {

    public static final String SERVER_NAME = "localhost";
    public static final int PORT = 6075;

    private static MessageConsumerSocketImpl messageConsumer;

    private Socket client;

    private MessageConsumerSocketImpl() throws IOException {
        client = new Socket(SERVER_NAME, PORT);
    }

    public static MessageConsumerSocketImpl getMessageConsumer() {
        if (messageConsumer == null) {
            try {
                messageConsumer = new MessageConsumerSocketImpl();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return messageConsumer;
    }

    @Override
    public String receiveMessage() throws InterruptedException {
        try {
            InputStream inFromServer = client.getInputStream();
            DataInputStream in =
                    new DataInputStream(inFromServer);
            return in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
