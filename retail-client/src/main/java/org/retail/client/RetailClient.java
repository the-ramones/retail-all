package org.retail.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.retail.service.async.AsyncBean;
import org.retail.service.exception.RetailException;

/**
 * Retail Store application client
 */
public class RetailClient {

    @EJB
    static AsyncBean asyncBean;
    protected static Logger logger = Logger.getLogger(RetailClient.class.getName());

    public static void main(String[] args) {
        logger.info("Launching Retail Store client..");
        try {
            Future<String> status = asyncBean.processPayment("44eg44");
            Future<String> statusForCancelling = asyncBean.processPayment("55tg55");
            if (status != null) {
                try {
                    String shouldBeSuccess = status.get(10, TimeUnit.SECONDS);
                    logger.info("This should be equal 'success': " + shouldBeSuccess);
                    statusForCancelling.cancel(false);

                    if (status.isDone()) {
                        logger.info("Status of payment was set to 'done'");
                    }
                    if (statusForCancelling.isCancelled()) {
                        logger.info("Status of payment was set to 'cancelled'");
                    }
                } catch (IllegalStateException ex) {
                    logger.warning("Illegal state of a payment status. Payment cannot be processed");
                } catch (InterruptedException iex) {
                    logger.warning("Execution of payment processing has been interrupted");
                } catch (TimeoutException tex) {
                    logger.warning("Exception due to execution timeout");
                } catch (ExecutionException eex) {
                    logger.warning("Generic execution exception");
                }
            }
        } catch (RetailException ex) {
            logger.severe("Cannot process payment due to errors");
        }
        logger.info("Exiting Retail Store client..");
    }
}
