package org.retail.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.retail.ws.xml.Price;

@WebService
public class Calculator {

    public Calculator() {
    }

    @WebMethod
    public String ping(@WebParam(name = "name") String name) {
        return "Ping" + name + ".";
    }

    @WebMethod
    public double sum(double a, double b) {
        return a + b;
    }

    @WebMethod
    public double multiply(double a, double b) {
        return a * b;
    }
    
    @WebMethod
    public Price pingPrice() {
        return new Price("iPhone", 100.0);
    }
}
