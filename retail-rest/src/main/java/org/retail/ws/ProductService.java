package org.retail.ws;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.jws.WebService;
import org.retail.entity.Family;
import org.retail.entity.Feature;
import org.retail.entity.Product;
import org.retail.entity.measure.Quantity;
import org.retail.entity.measure.Unit;
import org.retail.ws.sei.ProductSei;

/**
 * JAX_WS, SEI Only stub-methods
 *
 * @author the-ramones
 */
@WebService(serviceName = "ProductService",
portName = "retail.productPort",
targetNamespace = "http://www.retail.org/wsdl/",
endpointInterface = "org.retail.ws.sei.ProductSei")
public class ProductService implements ProductSei {

    @Override
    public String info() {
        return "Retail Store Product Catalog";
    }

    @Override
    public Product getProduct(Long productId) {
        return new Product(Math.round(Math.random() * 100), "iPhone 5C");
    }

    @Override
    public List<Product> products() {
        List<Product> products = new ArrayList<Product>(100);
        Family smartphone = new Family("smartphone");
        Family tablet = new Family("tablet");
        Family notebook = new Family("notebook");
        Feature f1 = new Feature("cell");
        Feature f2 = new Feature("wi-fi");
        Feature f3 = new Feature("3g");
        Feature f4 = new Feature("hd");
        Set features = new HashSet();
        features.add(f1);
        features.add(f2);
        features.add(f3);
        features.add(f4);
        for (int i = 0; i < 100; i++) {
            products.add(new Product(Math.round(Math.random() * 100), "iPhone 5S", features, i % 3 == 0 ? smartphone : tablet));
        }
        return products;
    }

    @Override
    public List<Product> products(Family family, Feature feature) {
        List<Product> products = new ArrayList<Product>(100);

        if (family != null && feature != null) {
            // search by family and feature
            for (int i = 0; i < 100; i++) {
                products.add(new Product(Math.round(Math.random() * 100), "iPhone 5S", Collections.singleton(feature), family));
            }
            return products;
        } else {
            if (family != null) {
                // search by family or/and feature
                if (feature == null) {
                    Set<Feature> features = new HashSet<Feature>();
                    for (int i = 0; i < 100; i++) {
                        products.add(new Product(Math.round(Math.random() * 100), "iPhone 5S", features, family));
                    }
                    return products;
                } else {
                    Set<Feature> features = new HashSet<Feature>();
                    features.add(feature);
                    for (int i = 0; i < 100; i++) {
                        products.add(new Product(Math.round(Math.random() * 100), "iPhone 5S", features, family));
                    }
                    return products;
                }
            } else {
                if (feature != null) {
                    // search by feature
                    Set<Feature> features = new HashSet<Feature>();
                    features.add(feature);
                    for (int i = 0; i < 100; i++) {
                        products.add(new Product(Math.round(Math.random() * 100), "iPhone 5S", features, null));
                    }
                    return products;

                } else {
                    // empty search 
                    return null;
                }
            }
        }
    }

    @Override
    public List<Product> productsInStock() {
        List<Product> products = new ArrayList<Product>(100);
        for (int i = 0; i < 100; i++) {
            products.add(new Product(Math.round(Math.random() * 100), "iPhone 5S"));
        }
        return products;
    }

    @Override
    public List<Product> productsInStockByDate(Calendar date) {
        List<Product> products = new ArrayList<Product>(100);
        for (int i = 0; i < 100; i++) {
            products.add(new Product(Math.round(Math.random() * 100), "iPhone 5S"));
        }
        return products;
    }

    @Override
    public Quantity productQuantityInStock() {
        return new Quantity(BigDecimal.valueOf(Math.random() * 1000), new Unit(Unit.CUBIC_METER));
    }

    @Override
    public Quantity productQuantityInStockByDate(Calendar date) {
        return new Quantity(BigDecimal.valueOf(Math.random() * 1000), new Unit(Unit.PIECE));
    }
}
