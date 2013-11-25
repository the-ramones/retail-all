package org.retail.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.retail.service.exception.BookException;
import org.retail.service.helpers.IdVerifier;

/**
 *
 * @author the-ramones
 */
@Stateful
public class CartBean implements Cart {

    private final static Logger logger = Logger.getLogger(CartBean.class.getName());

    public CartBean() {
    }
    String customerName;
    String customerId;
    List<String> contents;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public void initialize(String person) throws BookException {
        if (person == null) {
            throw new BookException("Null person not allowed.");
        } else {
            customerName = person;
        }

        customerId = "0";
        contents = new ArrayList<String>();
    }

    @Override
    public void initialize(String person, String id)
            throws BookException {
        if (person == null) {
            throw new BookException("Null person not allowed.");
        } else {
            customerName = person;
        }

        IdVerifier idChecker = new IdVerifier();

        if (idChecker.validate(id)) {
            customerId = id;
        } else {
            throw new BookException("Invalid id: " + id);
        }

        contents = new ArrayList<String>();
    }

    @Override
    public void addBook(String title) {
        contents.add(title);
    }

    @Override
    public void removeBook(String title) throws BookException {
        boolean result = contents.remove(title);
        if (result == false) {
            throw new BookException(title + " not in cart.");
        }
    }

    @Override
    public List<String> getContents() {
        return contents;
    }

    /*
     * By Clients to remove a bean
     */
    @Remove
    @Override
    public void remove() {
        contents = null;
    }

    @PostConstruct
    public void postConstruct() {
    }

    @PreDestroy
    public void preDestroy() {
    }

    @PostActivate
    public void postActivate() {
    }

    @PrePassivate
    public void prePassivate() {
    }
}
