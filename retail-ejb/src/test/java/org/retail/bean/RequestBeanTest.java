package org.retail.bean;

import java.math.BigDecimal;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.retail.entity.Product;
import org.retail.entity.measure.ProductUnit;
import org.retail.entity.measure.Unit;

/**
 *
 * @author the-ramones
 */
public class RequestBeanTest {

    public RequestBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createProduct method, of class RequestBean.
     */
    @Test
    public void testCreateProduct() throws Exception {
        System.out.println("createProduct");
        String title = "";
        String productFamily = "";
        String productFeature = "";
        ProductUnit productUnit = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RequestBean instance = (RequestBean)container.getContext().lookup("java:global/classes/RequestBean");
        instance.createProduct(title, productFamily, productFeature, productUnit);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUnit method, of class RequestBean.
     */
    @Test
    public void testCreateUnit() throws Exception {
        System.out.println("createUnit");
        String unitName = "";
        String description = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RequestBean instance = (RequestBean)container.getContext().lookup("java:global/classes/RequestBean");
        instance.createUnit(unitName, description);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProductUnit method, of class RequestBean.
     */
    @Test
    public void testCreateProductUnit() throws Exception {
        System.out.println("createProductUnit");
        Product product = null;
        Unit stockUnit = null;
        Unit orderUnit = null;
        Unit viewUnit = null;
        BigDecimal orderMultiplier = null;
        BigDecimal viewMultiplier = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RequestBean instance = (RequestBean)container.getContext().lookup("java:global/classes/RequestBean");
        instance.createProductUnit(product, stockUnit, orderUnit, viewUnit, orderMultiplier, viewMultiplier);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}