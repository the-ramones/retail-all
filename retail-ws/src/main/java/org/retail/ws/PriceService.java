package org.retail.ws;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.retail.entity.Family;
import org.retail.entity.Feature;
import org.retail.entity.Product;
import org.retail.entity.finance.Discount;
import org.retail.entity.finance.Price;
import org.retail.service.exception.RetailException;

/**
 * JAX-WS.
 * Only stub implementation
 *
 * @author the-ramones
 */
@WebService(
serviceName = "PriceService",
portName = "retail.pricePort",
targetNamespace = "http://www.retail.org/wsdl/")
public class PriceService {


    @WebMethod(operationName = "info")
    public String info() {
        return "Retail Store Price Service";
    }

    @WebMethod(operationName = "getPrice")
    public Price price(@WebParam(name = "product") Product item, @WebParam(name = "feature") Feature feature, @WebParam(name = "family") Family family) {
        return new Price(Math.round(Math.random() * 1000), item, feature,
                BigDecimal.valueOf(Math.round(Math.random() * 1000)),
                Calendar.getInstance());
    }

    @WebMethod(operationName = "priceByDate")
    public Price priceByDate(@WebParam(name = "product") Product item, @WebParam(name = "feature") Feature feature, @WebParam(name = "family") Family family, @WebParam(name = "date") Calendar date) {
        return new Price(Math.round(Math.random() * 1000), item, feature,
                BigDecimal.valueOf(Math.round(Math.random() * 1000)), date);
    }

    @WebMethod(operationName = "getDiscount")
    public Discount discount(@WebParam(name = "product") Product item, @WebParam(name = "feature") Feature feature, @WebParam(name = "family") Family family) {
        return new Discount(item, feature, family,
                BigDecimal.valueOf(Math.round(Math.random() * 100)),
                Calendar.getInstance());
    }

    @WebMethod(operationName = "discountByDate")
    public Discount discountByDate(@WebParam(name = "product") Product item, @WebParam(name = "feature") Feature feature, @WebParam(name = "family") Family family, @WebParam(name = "date") Calendar date) {
        return new Discount(item, feature, family,
                BigDecimal.valueOf(Math.round(Math.random() * 100)), date);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "testOperation")
    public Price testOperation(@WebParam(name = "id") BigDecimal id) throws RetailException {
        //TODO write your implementation code here:
        return null;
    }
}
