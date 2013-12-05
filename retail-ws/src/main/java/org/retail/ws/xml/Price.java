package org.retail.ws.xml;

/**
 *
 * @author the-ramones
 */
public class Price {

    public Price() {
    }

    public Price(String name, double value) {
        this.name = name;
        this.value = value;
    }
    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
