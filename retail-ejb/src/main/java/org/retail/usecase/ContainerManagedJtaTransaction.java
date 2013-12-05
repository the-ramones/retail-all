package org.retail.usecase;

import com.sun.security.ntlm.Client;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.retail.entity.Product;

/**
 * Use case for container-managed JTA/non-JTA transaction
 *
 * @author the-ramones
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ContainerManagedJtaTransaction {

    @PersistenceContext
    EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void perform() {
        Product product = em.find(Product.class, 1L);
        product.setDescription("A new description");
    }
}
