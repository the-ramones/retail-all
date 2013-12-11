package org.retail.bean;

import java.math.BigDecimal;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.retail.entity.Family;
import org.retail.entity.Feature;
import org.retail.entity.Product;
import org.retail.entity.measure.ProductUnit;
import org.retail.entity.measure.Unit;
import org.retail.info.Address;
import org.retail.service.exception.RetailException;

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
        em.setProperty(null, args);
        test();
        evaluate();
        System.out.println("Test finished...");
        em.close();
    }

    static void test() {
        Address a = new Address("USA", "NJ", "Heigner", "Main street");
        em.getTransaction().begin();
        em.persist(a);
        em.flush();
        em.getTransaction().commit();
    }

    static void evaluate() {
        try {
            Family family = new Family();
            family.setTitle("grocceries" + Math.random() * 100);
            family.setDescription("a plain grocceries");

            ProductUnit productUnit = new ProductUnit();
            if (em.find(Unit.class, 1) == null) {
                productUnit.setOrderUnit(new Unit("kilo"));
            } else {
                System.out.println(em.find(Unit.class, 1));
                productUnit.setOrderUnit(em.find(Unit.class, 1));
            }
            if (em.find(Unit.class, 2) == null) {
                productUnit.setStockUnit(new Unit("ton"));
            } else {
                System.out.println(em.find(Unit.class, 2));
                productUnit.setStockUnit(em.find(Unit.class, 2));
            }
            if (em.find(Unit.class, 3) == null) {
                productUnit.setViewUnit(new Unit("piece"));
            } else {
                System.out.println(em.find(Unit.class, 3));
                productUnit.setViewUnit(em.find(Unit.class, 3));

            }
            productUnit.setViewMultiplier(BigDecimal.valueOf(0.0002));
            productUnit.setOrderMultiplier(BigDecimal.valueOf(0.001));

            throwsRetailException();

            Product product = new Product("peach", new HashSet<Feature>(), family, productUnit, "a peach");

            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (RetailException ex) {
            em.getTransaction().rollback();
            System.err.println(ex.getMessage());
        }


    }

    static void throwsRetailException() throws RetailException {
    }
}
