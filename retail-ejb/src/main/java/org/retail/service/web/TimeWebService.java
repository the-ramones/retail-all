package org.retail.service.web;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Paul Kulitski
 */
@WebService
@Stateless
public class TimeWebService {

    public TimeWebService() {
    }

    /**
     * Web service time
     */
    @WebMethod(operationName = "time")
    public String time() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Date time = calendar.getTime();
        return time.toString();
    }
}
