package org.retail.billing;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.retail.entity.client.Customer;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@DiscriminatorValue("BA")
public class BankAccount extends BillingDetails implements Serializable {

    private String ibaNumber;

    public BankAccount() {
    }

    public BankAccount(String ibaNumber, Long billingDetailId, String accountNumber, Customer customer) {
        super(billingDetailId, accountNumber, customer);
        this.ibaNumber = ibaNumber;
    }

    @Column(length = 34, nullable = false)
    public String getIbaNumber() {
        return ibaNumber;
    }

    public void setIbaNumber(String ibaNumber) {
        this.ibaNumber = ibaNumber;
    }
}
