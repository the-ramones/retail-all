package org.retail.boot;

import com.mysql.jdbc.PerConnectionLRUFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Paul Kulitski
 */
public class FillUp {

    static EntityManager em;

    public static void main(String[] args) {
        em = Persistence.createEntityManagerFactory("retailPU").createEntityManager();
        fillCustomers();
        fillAddresses();
        fillCustomerDetails();
    }

    private static void fillCustomers() {
    }

    private static void fillAddresses() {
    }

    private static void fillCustomerDetails() {
    }
}
