package org.retail.service.jms;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.retail.service.exception.RetailException;

/**
 *
 * @author the-ramones
 */
public class MessageClient {

    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    
    @Resource(mappedName = "jms/Queue")
    private static Queue queue;
    Connection connection;
    Session session;
    MessageProducer messageProducer;

    public MessageClient() throws RetailException {
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);
        } catch (JMSException ex) {
            throw new RetailException();
        }
    }

    public void produceOneMessage() throws RetailException {
        try {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("JMS message into the queue");
            messageProducer.send(textMessage);
        } catch (JMSException ex) {
            throw new RetailException();
        }

    }
}
