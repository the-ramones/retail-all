package org.retail.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.retail.ws.sei.ProductSei;

/**
 *
 * @author the-ramones
 */
@WebService(serviceName = "ProductService",
portName = "retail.productPort",
targetNamespace = "http://www.retail.org/wsdl/",
endpointInterface = "org.retail.ws.sei.ProductSei")
public class ProductService implements ProductSei {

    @Override
    public String findProduct() {
        return "Product Stub";
    }
}
