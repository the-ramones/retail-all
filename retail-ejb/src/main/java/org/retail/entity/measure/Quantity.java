package org.retail.entity.measure;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author the-ramones
 */
public class Quantity implements Serializable {

    private BigDecimal quantity;
    private Unit unit;

    public Quantity() {
    }

    public Quantity(BigDecimal quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
