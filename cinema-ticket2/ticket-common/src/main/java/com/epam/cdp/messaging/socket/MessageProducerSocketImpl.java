package com.epam.cdp.messaging.socket;


import com.epam.cdp.messaging.MessageProducer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 24 Feb, 2015
 */
public class MessageProducerSocketImpl implements MessageProducer {

    public static final int DEFAULT_PORT = 6075;
    public static final int TIMEOUT = 1000000;

    private static MessageProducerSocketImpl messageProducer;

    private ServerSocket serverSocket;
    private Socket socket;

    private MessageProducerSocketImpl() throws IOException {
        this.serverSocket = new ServerSocket(DEFAULT_PORT);
        serverSocket.setSoTimeout(TIMEOUT);
        startServer();
    }

    //Only one client can connect.
    public void startServer() {
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MessageProducerSocketImpl getMessageProducer() {
        if (messageProducer == null) {
            try {
                messageProducer = new MessageProducerSocketImpl();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return messageProducer;
    }

    @Override
    public void send(String message) throws IOException {
        try {
            DataOutputStream out =
                    new DataOutputStream(socket.getOutputStream());
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
