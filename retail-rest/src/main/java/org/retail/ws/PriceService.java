package org.retail.ws;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.retail.entity.Family;
import org.retail.entity.Feature;
import org.retail.entity.Product;
import org.retail.entity.finance.Discount;
import org.retail.entity.finance.Price;

/**
 * JAX-WS.
 * Only stub implementation
 *
 * @author the-ramones
 */
@WebService(serviceName = "PriceService",
portName = "retail.productPort",
targetNamespace = "http://www.retail.org/wsdl/")
public class PriceService {

    @WebMethod(operationName = "info")
    public String info() {
        return "Retail Store Price Service";
    }

    @WebMethod(operationName = "price")
    public Price price(Product item, Feature feature, Family family) {
        return new Price(Math.round(Math.random() * 1000), item, feature,
                BigDecimal.valueOf(Math.round(Math.random() * 1000)),
                Calendar.getInstance());
    }

    @WebMethod(operationName = "priceByDate")
    public Price priceByDate(Product item, Feature feature, Family family, Calendar date) {
        return new Price(Math.round(Math.random() * 1000), item, feature,
                BigDecimal.valueOf(Math.round(Math.random() * 1000)), date);
    }

    @WebMethod(operationName = "discount")
    public Discount discount(Product item, Feature feature, Family family) {
        return new Discount(item, feature, family,
                BigDecimal.valueOf(Math.round(Math.random() * 100)),
                Calendar.getInstance());
    }

    @WebMethod(operationName = "discountByDate")
    public Discount discountByDate(Product item, Feature feature, Family family, Calendar date) {
        return new Discount(item, feature, family,
                BigDecimal.valueOf(Math.round(Math.random() * 100)), date);
    }
}
