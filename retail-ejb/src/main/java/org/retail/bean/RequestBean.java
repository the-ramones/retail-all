package org.retail.bean;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.retail.entity.Family;
import org.retail.entity.Feature;
import org.retail.entity.Product;
import org.retail.entity.measure.ProductUnit;
import org.retail.entity.measure.Unit;
import org.retail.service.exception.RetailException;

/**
 *
 * @author the-ramones
 */
@Stateful
@StatefulTimeout(value = 8, unit = TimeUnit.HOURS)
public class RequestBean {
    
    protected static final Logger logger = Logger.getLogger(RequestBean.class.getName());
    @PersistenceContext
    EntityManager em;
    
    public void createProduct(
            String title,
            String productFamily,
            String productFeature,
            ProductUnit productUnit) throws RetailException {
        try {
            Feature feature = new Feature(productFeature);
            Family family = new Family(productFamily);
            Product product = new Product(title, feature, family, productUnit,
                    "generated product");
            em.persist(product);
        } catch (Exception ex) {
            throw new EJBException("cannot create a new product", ex);
        }
    }
    
    public void createUnit(
            String unitName,
            String description) {
        try {
            Unit unit = new Unit(unitName, description);
            em.persist(unit);
        } catch (Exception ex) {
            throw new EJBException("cannot create a new unit", ex);
        }
        
    }
    
    public void createroductUnit() {
        try {
            ProductUnit productUnit = new ProductUnit();
        } catch (Exception ex) {
            throw new EJBException("cannot create a new product unit", ex);
        }
    }
}
