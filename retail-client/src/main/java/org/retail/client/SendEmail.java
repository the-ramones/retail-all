package org.retail.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.retail.service.async.MailedBean;

/**
 * Sends email to the specified subscribers
 */
public class SendEmail {
    
    @EJB
    static MailedBean mailedBean;
    static final String recipient = "delite_007@mail.ru";
    static final int amount = 5;
    protected static Logger logger = Logger.getLogger(SendEmail.class.getName());
    
    public static void main(String[] args) {
        logger.info("Preparing to send a email");
        List<Future<String>> statuses = new ArrayList<Future<String>>(amount);
        for (int i = 0; i < amount; i++) {
            statuses.add(mailedBean.sendMessage(recipient));
        }
        logger.info("Retrieving statuses..");        
        for (int i = 0; i < amount; i++) {
            try {
                String status = statuses.get(i).get(5, TimeUnit.SECONDS);
                logger.info("Status " + i + ". " + status);
            } catch (Exception ex) {
                logger.severe("Exception while retrieving status..");
            }
        }
    }
}
