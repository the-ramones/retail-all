package org.retail.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.retail.entity.finance.Discount;
import org.retail.entity.finance.Price;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class OrderedProduct implements Serializable {

    private Long orderedProductId;
    private Product product;
    private BigDecimal amount;
    private Price price;
    private Discount discount;

    public OrderedProduct() {
    }

    public OrderedProduct(Long orderedProductId, Product product, BigDecimal amount, Price price, Discount discount) {
        this.orderedProductId = orderedProductId;
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
    }

    @ManyToOne
    @JoinColumn
    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOrderedProductId() {
        return orderedProductId;
    }

    public void setOrderedProductId(Long orderedProductId) {
        this.orderedProductId = orderedProductId;
    }

    @ManyToOne
    @JoinColumn
    public Product getItem() {
        return product;
    }

    public void setItem(Product item) {
        this.product = item;
    }

    @Column(nullable = false, precision = 50, scale = 10)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @ManyToOne
    @JoinColumn
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.orderedProductId != null ? this.orderedProductId.hashCode() : 0);
        hash = 37 * hash + (this.product != null ? this.product.hashCode() : 0);
        hash = 37 * hash + (this.amount != null ? this.amount.hashCode() : 0);
        hash = 37 * hash + (this.price != null ? this.price.hashCode() : 0);
        hash = 37 * hash + (this.discount != null ? this.discount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderedProduct other = (OrderedProduct) obj;
        if (this.orderedProductId != other.orderedProductId && (this.orderedProductId == null || !this.orderedProductId.equals(other.orderedProductId))) {
            return false;
        }
        if (this.product != other.product && (this.product == null || !this.product.equals(other.product))) {
            return false;
        }
        if (this.amount != other.amount && (this.amount == null || !this.amount.equals(other.amount))) {
            return false;
        }
        if (this.price != other.price && (this.price == null || !this.price.equals(other.price))) {
            return false;
        }
        if (this.discount != other.discount && (this.discount == null || !this.discount.equals(other.discount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderedProduct{" + "orderedProductId=" + orderedProductId + ", item=" + product + ", amount=" + amount + ", price=" + price + ", discount=" + discount + '}';
    }
}
