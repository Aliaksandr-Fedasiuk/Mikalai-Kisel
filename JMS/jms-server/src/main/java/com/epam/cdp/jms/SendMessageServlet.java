package com.epam.cdp.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>
 * </p>
 *
 * @author kisel.nikolay@gmail.com
 * @since 29 Jan, 2015
 */
@WebServlet(description = "Send Message Servlet", urlPatterns = {"/SendMessageServlet", "/SendMessageServlet.do"})
public class SendMessageServlet extends HttpServlet {

    public static final String USERNAME = "vgerton";
    public static final String PASSWORD = "sdf12DF&!hgj";
    public static final String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    public static final String TOPIC_NAME = "jms/topic/test";
    public static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    public static final String PROVIDER_URL = "remote://localhost:4447";

    private Topic topic;
    private TopicSession topicSession;
    private TopicConnection topicConnection;
    private TopicPublisher topicPublisher;


    public Properties getProperties() {
        final Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        properties.put(Context.PROVIDER_URL, PROVIDER_URL);
        properties.put(Context.SECURITY_PRINCIPAL, USERNAME);
        properties.put(Context.SECURITY_CREDENTIALS, PASSWORD);

        return properties;
    }

    public void setUpPublisher() throws NamingException, JMSException {
        InitialContext context = new InitialContext(getProperties());

        TopicConnectionFactory tcf = (TopicConnectionFactory) context.lookup(CONNECTION_FACTORY);
        topicConnection = tcf.createTopicConnection(USERNAME, PASSWORD);
        topic = (Topic) context.lookup(TOPIC_NAME);
        topicSession = topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
        topicConnection.start();

        topicPublisher = topicSession.createPublisher(topic);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");

        try {
            if (topicPublisher == null) {
                setUpPublisher();
            }
            TextMessage tm = topicSession.createTextMessage(message);
            topicPublisher.publish(tm);
        } catch (JMSException | NamingException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/InputMessageServlet.do").forward(request, response);
    }
}
