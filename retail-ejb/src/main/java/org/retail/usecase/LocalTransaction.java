package org.retail.usecase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author the-ramones
 */
public class LocalTransaction {

    @PersistenceContext
    EntityManager em;

    public void perform() {
        try {
            em.getTransaction().begin();

            
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            em.getTransaction().rollback();
        }
    }
}
