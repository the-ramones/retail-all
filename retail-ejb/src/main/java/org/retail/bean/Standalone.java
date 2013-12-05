package org.retail.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.retail.info.Address;

/**
 *
 * @author Paul Kulitski
 */
public class Standalone {

    static EntityManager em;

    public static void main(String[] args) {
        System.out.println("Bootstrapping...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("retailPU");
        em = emf.createEntityManager();
        test();
        em.close();
        System.out.println("Test finished...");
    }

    static void test() {
        Address a = new Address("USA", "NJ", "Heigner", "Main street");
        em.getTransaction().begin();
        em.persist(a);
        em.flush();
        em.getTransaction().commit();
    }
}
