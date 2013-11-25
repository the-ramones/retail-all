package org.retail.entity.operation;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.retail.billing.BillingDetails;
import org.retail.entity.Order;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class Payment implements Serializable {

    private Long paymentId;
    private Order order;
    private BillingDetails billingDetails;

    public Payment() {
    }

    public Payment(Long paymentId, Order order, BillingDetails billingDetails) {
        this.paymentId = paymentId;
        this.order = order;
        this.billingDetails = billingDetails;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }
}
