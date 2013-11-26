package org.retail.service.async;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Stateless session bean for
 *
 * @Asynchronous execution
 * @author the-ramones
 */
@Named
@Stateless
public class MailedBean {

    @Resource(name = "mail/retailEmailSession")
    private Session session;
    protected static Logger logger = Logger.getLogger(MailedBean.class.getName());

    /*
     * Is noe efficient cause email transport is synchronous: it will cause a
     * big pauses
     */
    @Asynchronous
    public Future<String> sendMessage(String email) {
        String status;
        try {
            Message message = new MimeMessage(session);
            message.setFrom();
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email, false));
            message.setSubject("Retail Store Subscriber Message");
            message.setHeader("X-Mailer", "JavaMail");
            DateFormat dateFormat = DateFormat.getDateTimeInstance(
                    DateFormat.LONG, DateFormat.SHORT);
            Date timeStamp = new Date();
            String messageBody = "Retail Store default subscriber mail message."
                    + "It you don;t know anything about us, check out web-site"
                    + dateFormat.format(timeStamp);
            message.setText(messageBody);
            message.setSentDate(timeStamp);
            Transport.send(message);
            status = "sent";
            logger.info("mail is send to " + email);
        } catch (MessagingException ex) {
            logger.severe("Error in sending message.");
            status = "Encountered an error: " + ex.getMessage();
            logger.severe(ex.getMessage());
        }
        return new AsyncResult<String>(status);
    }
    
    /*
     * TODO: implement asynchronous mail sending
     *  
        ExecutorService executor;
        ArchiveSearcher searcher;
        void showSearch(final String target) throws InterruptedException {
            Future<String> future = executor.submit(new Callable<String>() {
                public String call() { return searcher.search(target); }
            });
            displayOtherThings(); // do other things while searching
            try {
                displayText(future.get()); // use future
            } catch (ExecutionException ex) { cleanup(); return; }
        }
     
     * 
      FutureTask<String> future =
       new FutureTask<String>(new Callable<String>() {
         public String call() {
           return searcher.search(target);
       }});
      executor.execute(future);
 
     */
}
