package org.retail.stock;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.retail.entity.Product;
import org.retail.entity.finance.Price;
import org.retail.entity.measure.Unit;

/**
 *
 * @author the-ramones
 */
@Entity
@Table
public class Stock implements Serializable {

    private Long stockId;
    private Calendar byDate;
    private Product product;
    private Price price;
    private BigDecimal quantity;
    private Unit unit;

    public Stock() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Calendar getByDate() {
        return byDate;
    }

    public void setByDate(Calendar byDate) {
        this.byDate = byDate;
    }

    
    @OneToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    @OneToOne
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @OneToOne
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
