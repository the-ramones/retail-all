package org.retail.rs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.retail.rs.data.Item;
import org.retail.rs.data.ItemSource;
import org.retail.rs.data.Price;
import org.retail.rs.data.PriceSource;

/**
 *
 * @author the-ramones
 */
@Path("price")
public class PriceService {

    Logger logger = Logger.getLogger(PriceService.class.getName());
    PriceSource priceSource = PriceSource.getInstance();
    ItemSource itemSource = ItemSource.getInstance();

    @GET
    @Path("info")
    @Produces("text/plain")
    public String getInfo() {
        return "Retail Store Rest Service";
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Price getPrice(@PathParam("id") Long id) {
        /*
         * Get a price. 200 OK / 204 No Content
         */
        if (id != null) {
            return priceSource.getPrice(id);
        } else {
            return null;
        }
    }

    @POST
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void updatePrice(@PathParam("id") Long id, Price newPrice) {
        /*
         * Update a price. 204 No Content 
         */
        if (newPrice != null && id.equals(newPrice.getId())) {
            priceSource.setPrice(newPrice);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void addPrice(@PathParam("id") Long id, Price price) {
        /*
         * Add a new price. 204 No Content 
         */
        if (id != null && price != null) {
            priceSource.setPrice(price);
        }
    }

    @DELETE
    @Path("{id}")
    public void deletePrice(@PathParam("id") Long id) {
        if (id != null) {
            priceSource.deletePrice(id);
        }
    }

    @GET
    @Path("item/{id}")
    @Produces({"application/xml", "application/json"})
    public Response getPriceByItem(@PathParam("id") Long itemId) {
        if (itemId != null) {
            Item item = itemSource.getItem(itemId);
            if (item != null) {
                Price price = priceSource.getPriceByItem(item);
                if (price != null) {
                    return Response.ok(price).build();
                } else {
                    return Response.status(Response.Status.NOT_FOUND).build();
                }
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("item")
    @Consumes({"application/xml", "application/json"})
    public Response updatePriceByItem(Item item, BigDecimal newPriceValue) {
        if (item != null) {
            Price price = priceSource.getPriceByItem(item);
            if (price != null) {
                Price newPrice = new Price(price.getId(), newPriceValue, item, new Date());
                priceSource.setPrice(newPrice);
                /*
                 * 200 OK, 303 See Other (HTTP GET)
                 */
                return Response.ok().status(303).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("item")
    @Consumes({"application/xml", "application/json"})
    public Response addPriceByItem(@Context UriInfo uriInfo, Item item, BigDecimal priceValue) {
        if (item != null) {
            Price price = priceSource.getPriceByItem(item);
            if (price != null) {
                return Response.created(uriInfo.getRequestUri()).build();
            } else {
                return Response.noContent().build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("item")
    public Response deleteByItem(Item item) {
        if (item != null) {
            Price price = priceSource.getPriceByItem(item);
            if (price != null) {
                priceSource.deletePrice(price.getId());
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
//    @GET
//    @Path("/")
//    public Response messageWriter() throws RetailWebException {
//        /*
//         * Simulate data access
//         */
//        Fruit fruit = new Fruit("apple", 2);
//        if (fruit == null) {
//            throw new RetailWebException("Item not fount");
//        }
//        Date now = new Date();
//        EntityTag entityTag;
//        MessageDigest sha1;
//        try {
//            sha1 = MessageDigest.getInstance("SHA1");
//            entityTag = new EntityTag(new String(sha1.digest(fruit.getName().getBytes("UTF-8")), "UTF-8"));
//        } catch (Exception ex) {
//            logger.warning("Cannot compute digest");
//            logger.warning(ex.getMessage());
//            entityTag = new EntityTag("");
//        }
//
//        return Response.ok(fruit, MediaType.APPLICATION_XML).build();
//    }
//
//    @POST
//    @Path("/form")
//    public Response messageReader() {
//        return null;
//    }

//    @GET
    @Path("{id}")
    public PriceItemService getLoc() {
        return new PriceItemService();
    }
}
