package org.retail.entity.client;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.retail.billing.BillingDetails;
import org.retail.info.Address;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class CustomerDetails implements Serializable {

    private Long customerId;
    private Set<Address> addresses;
    private Set<BillingDetails> billingDetails;
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @OneToMany
    @JoinColumn
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @OneToMany
    @JoinColumn
    public Set<BillingDetails> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Set<BillingDetails> billingDetails) {
        this.billingDetails = billingDetails;
    }

    @OneToOne(mappedBy = "customerDetails")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
