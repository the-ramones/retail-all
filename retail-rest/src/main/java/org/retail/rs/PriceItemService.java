package org.retail.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.retail.rs.data.Item;

/**
 * Sub-resource locator
 *
 * @author the-ramones
 */
public class PriceItemService {

    public String getRes() {
        return "";
    }

    @GET
    @Path("item")
    public Item getItem() {
        return null;
    }
}
