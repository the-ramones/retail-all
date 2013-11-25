package org.retail.billing;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.retail.entity.client.Customer;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@DiscriminatorValue("CC")
public class CreditCard extends BillingDetails {

    private String ccNumber;

    public CreditCard() {
        super();
    }

    public CreditCard(String ccNumber, Long billingDetailId, String accountNumber, Customer customer) {
        super(billingDetailId, accountNumber, customer);
        this.ccNumber = ccNumber;
    }

    @Column(length = 16, nullable = false)
    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
}
