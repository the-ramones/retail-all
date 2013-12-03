package org.retail.ws.sei;

import java.util.Calendar;
import java.util.List;
import javax.jws.WebService;
import org.retail.entity.Family;
import org.retail.entity.Feature;
import org.retail.entity.Product;
import org.retail.entity.measure.Quantity;

/**
 *
 * @author the-ramones
 */
@WebService(targetNamespace = "http://www.retail.org/wsdl/")
public interface ProductSei {

    public String info();

    public Product getProduct(Long productId);

    public List<Product> products();

    public List<Product> products(Family family, Feature feature);

    public List<Product> productsInStock();

    public Quantity productQuantityInStock();

    public List<Product> productsInStockByDate(Calendar date);

    public Quantity productQuantityInStockByDate(Calendar date);
}
