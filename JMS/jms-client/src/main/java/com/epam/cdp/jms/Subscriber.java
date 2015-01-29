package com.epam.cdp.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 28 Jan, 2015
 */
public class Subscriber {

    public static final String USERNAME = "vgerton";
    public static final String PASSWORD = "sdf12DF&!hgj";
    public static final String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    public static final String TOPIC_NAME = "jms/topic/test";
    public static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    public static final String PROVIDER_URL = "remote://localhost:4447";

    private Topic topic;
    private TopicSession topicSession;
    private TopicConnection topicConnection;

    public static class CustomListener implements MessageListener {

        @Override
        public void onMessage(Message message) {
            TextMessage tm = (TextMessage) message;
            try {
                System.out.println("Receive message: " + tm.getText());
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public void setUpSubscriber() throws NamingException, JMSException {
        InitialContext context = new InitialContext(getProperties());

        TopicConnectionFactory tcf = (TopicConnectionFactory) context.lookup(CONNECTION_FACTORY);
        topicConnection = tcf.createTopicConnection(USERNAME, PASSWORD);
        topic = (Topic) context.lookup(TOPIC_NAME);
        topicSession = topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
        topicConnection.start();

        TopicSubscriber recv = topicSession.createSubscriber(topic);
        recv.setMessageListener(new CustomListener());
    }

    public Properties getProperties() {
        final Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        properties.put(Context.PROVIDER_URL, PROVIDER_URL);
        properties.put(Context.SECURITY_PRINCIPAL, USERNAME);
        properties.put(Context.SECURITY_CREDENTIALS, PASSWORD);

        return properties;
    }

    public void stop() throws JMSException {
        if (topicConnection != null) {
            topicConnection.stop();
        }
        if (topicSession != null) {
            topicSession.close();
        }
    }

    public static void main(String[] args) throws JMSException, NamingException, InterruptedException {
        System.out.println("Starting work...");
        Subscriber subscriber = new Subscriber();
        subscriber.setUpSubscriber();
//        subscriber.stop();

        while (true) {
        }
    }

}
