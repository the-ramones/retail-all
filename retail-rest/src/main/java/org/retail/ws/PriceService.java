package org.retail.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author the-ramones
 */
@WebService(serviceName = "ProductService",
    portName = "retail.productPort",
    targetNamespace = "http://www.retail.org/wsdl/")
public class PriceService {

    @WebMethod(operationName = "info")
    public String info() {
        return "Retail Store Price Service";
    }
}
