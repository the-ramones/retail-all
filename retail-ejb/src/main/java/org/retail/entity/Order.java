package org.retail.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.retail.entity.client.Customer;

/**
 *
 * @author Paul Kulitski
 */
@Entity(name = "Order_")
@Table(name = "order_")
public class Order implements Serializable {

    private Long orderId;
    private Customer customer;
    private List<OrderedProduct> orderedProducts;

    public Order() {
    }

    public Order(Long orderId, Customer customer, List<OrderedProduct> orderedProducts) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderedProducts = orderedProducts;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.orderId != null ? this.orderId.hashCode() : 0);
        hash = 97 * hash + (this.customer != null ? this.customer.hashCode() : 0);
        hash = 97 * hash + (this.orderedProducts != null ? this.orderedProducts.hashCode() : 0);
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
        final Order other = (Order) obj;
        if (this.orderId != other.orderId && (this.orderId == null || !this.orderId.equals(other.orderId))) {
            return false;
        }
        if (this.customer != other.customer && (this.customer == null || !this.customer.equals(other.customer))) {
            return false;
        }
        if (this.orderedProducts != other.orderedProducts && (this.orderedProducts == null || !this.orderedProducts.equals(other.orderedProducts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customer=" + customer + ", orderedProducts=" + orderedProducts + '}';
    }
}
