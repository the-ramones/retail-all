package org.retail.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author the-ramones
 */
@Path("/price")
public class PriceService {

    @GET
    @Produces("text/plain")
    public String getPrice() {
        return "100,dollar";
    }

    @POST
    @Consumes("text/plain")
    public void updatePrice(String newPrice) {
        /*
         * update price
         */
    }

    @PUT
    @Consumes("text/plain")
    public void addPrice(String price) {
        /*
         * add a new price
         */
    }

    @DELETE
    public void deletePrice() {
    }
}
