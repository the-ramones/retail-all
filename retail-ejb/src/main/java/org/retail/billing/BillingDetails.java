package org.retail.billing;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.retail.entity.client.Customer;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "billingDetailsType")
public abstract class BillingDetails implements Serializable {

    private Long billingDetailId;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private String isActive;
    private Customer customer;

    public BillingDetails() {
    }

    public BillingDetails(Long billingDetailId, String accountNumber, Customer customer) {
        this.billingDetailId = billingDetailId;
        this.accountNumber = accountNumber;
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getBillingDetailId() {
        return billingDetailId;
    }

    public void setBillingDetailId(Long billingDetailId) {
        this.billingDetailId = billingDetailId;
    }

    @Column(length = 1, nullable = false)
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Column(length = 32, nullable = false)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(length = 255)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(length = 8, nullable = true)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.billingDetailId != null ? this.billingDetailId.hashCode() : 0);
        hash = 67 * hash + (this.isActive != null ? this.isActive.hashCode() : 0);
        hash = 67 * hash + (this.customer != null ? this.customer.hashCode() : 0);
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
        final BillingDetails other = (BillingDetails) obj;
        if (this.billingDetailId != other.billingDetailId && (this.billingDetailId == null || !this.billingDetailId.equals(other.billingDetailId))) {
            return false;
        }
        if ((this.accountNumber == null) ? (other.accountNumber != null) : !this.accountNumber.equals(other.accountNumber)) {
            return false;
        }
        if ((this.isActive == null) ? (other.isActive != null) : !this.isActive.equals(other.isActive)) {
            return false;
        }
        if (this.customer != other.customer && (this.customer == null || !this.customer.equals(other.customer))) {
            return false;
        }
        return true;
    }
}
