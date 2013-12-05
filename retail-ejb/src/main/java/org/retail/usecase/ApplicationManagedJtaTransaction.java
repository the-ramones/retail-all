package org.retail.usecase;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.retail.entity.Product;
import org.retail.service.exception.RetailException;

/**
 * Application managed JTA transaction. Persistence context is local and newly
 * created
 *
 * @author the-ramones
 */
public class ApplicationManagedJtaTransaction {

    @Resource
    UserTransaction utx;
    @PersistenceUnit
    EntityManagerFactory emf;

    public void perform() {
        EntityManager em = emf.createEntityManager();

        try {
            utx.setTransactionTimeout(10000);
            utx.begin();

            Product product = em.find(Product.class, 1L);
            product.setTitle("iPhone 5C");
            em.merge(product);

            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (SystemException sex) {
                System.err.println("Cannot rollback a transaction");
                System.err.println(sex.getMessage());
            }
            System.err.println(ex.getMessage());
        }

        // close the whole factory
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
