package org.retail.service.exception;

/**
 *
 * @author the-ramones
 */
public class RetailException extends Exception {

    public RetailException(String msg) {
        super(msg);
    }

    public RetailException(Throwable cause) {
        super(cause);
    }

    public RetailException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
