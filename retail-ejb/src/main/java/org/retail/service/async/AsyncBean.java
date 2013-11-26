package org.retail.service.async;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.retail.service.exception.RetailException;

/**
 *
 * @author the-ramones
 */
@Stateless
@LocalBean
@Asynchronous
public class AsyncBean {

    /*
     * Deferred result, but not execution
     */
    public Future<String> processPayment(String order) throws RetailException {
        if (order != null) {
            return new AsyncResult<String>("success");
        } else {
            return new AsyncResult<String>("error");
        }
    }

    /*
     * Deferred execution of logic
     */
    public Future<String> updatePayment(String order) throws RetailException {
        if (order != null) {
            return new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    /*
                     * long-running processing
                     */
                    return "success";
                }
            });
        } else {
            return new FutureTask<String>(new Runnable() {
                @Override
                public void run() {
                    /*
                     * long-running processing
                     */
                }
            }, "fail");
        }
    }
}
