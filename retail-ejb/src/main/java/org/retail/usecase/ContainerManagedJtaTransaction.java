package org.retail.usecase;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.retail.entity.Product;

/**
 * Use case for container-managed JTA/non-JTA transaction
 *
 * @author the-ramones
 */
@Stateless
//@TransactionManagement(TransactionManagementType.CONTAINER)
//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ContainerManagedJtaTransaction {

   // @PersistenceContext
    EntityManager em;

    /*
     * java.lang.RuntimeException: 
     *  The persistence-context-ref-name [org.retail.usecase.ContainerManagedJtaTransaction/em] 
     *  in module [org_retail-ejb_ejb_1.0-SNAPSHOT] resolves to a persistence unit called [retailPU]
     *  which is of type RESOURCE_LOCAL. Only persistence units with transaction type JTA can be 
     *  used as a container managed entity manager. 
     * 
     *  Please verify your application.
     */
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void perform() {
        Product product = em.find(Product.class, 1L);
        product.setDescription("A new description");
    }
}
