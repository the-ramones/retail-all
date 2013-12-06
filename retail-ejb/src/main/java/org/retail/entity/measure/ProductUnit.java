package org.retail.entity.measure;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.retail.entity.Product;

/**
 * Unit-to-Product table. Set up multipliers for {@link Product} in
 * {@link Unit}'s
 *
 * @author the-ramones
 */
@Entity
@Table
public class ProductUnit implements Serializable {

    private Long productUnitId;
    private Product product;
    private Unit stockUnit;
    private Unit orderUnit;
    private Unit viewUnit;
    private BigDecimal orderMultiplier;
    private BigDecimal viewMultiplier;

    public ProductUnit() {
    }

    public ProductUnit(Product product, Unit stockUnit, Unit orderUnit, Unit viewUnit, BigDecimal orderMultiplier, BigDecimal viewMultiplier) {
        this.product = product;
        this.stockUnit = stockUnit;
        this.orderUnit = orderUnit;
        this.viewUnit = viewUnit;
        this.orderMultiplier = orderMultiplier;
        this.viewMultiplier = viewMultiplier;
    }

    public ProductUnit(Long productUnitId, Product product, Unit stockUnit, Unit orderUnit, Unit viewUnit, BigDecimal orderMultiplier, BigDecimal viewMultiplier) {
        this.productUnitId = productUnitId;
        this.product = product;
        this.stockUnit = stockUnit;
        this.orderUnit = orderUnit;
        this.viewUnit = viewUnit;
        this.orderMultiplier = orderMultiplier;
        this.viewMultiplier = viewMultiplier;
    }

    @Id
    public Long getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(Long productUnitId) {
        this.productUnitId = productUnitId;
    }

    @OneToOne(mappedBy = "productUnit")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public Unit getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(Unit stockUnit) {
        this.stockUnit = stockUnit;
    }

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    public Unit getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(Unit orderUnit) {
        this.orderUnit = orderUnit;
    }

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    public Unit getViewUnit() {
        return viewUnit;
    }

    public void setViewUnit(Unit viewUnit) {
        this.viewUnit = viewUnit;
    }

    @Column(scale = 6, precision = 20)
    public BigDecimal getOrderMultiplier() {
        return orderMultiplier;
    }

    public void setOrderMultiplier(BigDecimal orderMultiplier) {
        this.orderMultiplier = orderMultiplier;
    }

    @Column(scale = 6, precision = 20)
    public BigDecimal getViewMultiplier() {
        return viewMultiplier;
    }

    public void setViewMultiplier(BigDecimal viewMultiplier) {
        this.viewMultiplier = viewMultiplier;
    }
}
