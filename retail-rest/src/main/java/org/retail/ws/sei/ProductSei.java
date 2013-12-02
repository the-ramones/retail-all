package org.retail.ws.sei;

import javax.jws.WebService;

/**
 *
 * @author the-ramones
 */
@WebService(targetNamespace = "http://www.retail.org/wsdl/")
public interface ProductSei {

    public String findProduct();
}
