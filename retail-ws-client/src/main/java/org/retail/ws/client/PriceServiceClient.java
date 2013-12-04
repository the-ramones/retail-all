package org.retail.ws.client;

import javax.servlet.annotation.WebServlet;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author the-ramones
 */
@WebServlet(name = "priceServiceClient", urlPatterns = "price-service")
public class PriceServiceClient {
    
   // @WebServiceRef(wsdlLocation= "localhost:8080/retail-ws/PriceService")
}
