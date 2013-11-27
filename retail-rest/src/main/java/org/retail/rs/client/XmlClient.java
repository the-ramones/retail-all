package org.retail.rs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import org.retail.rs.data.ItemSource;
import org.retail.rs.data.Price;
import org.retail.rs.data.PriceSource;

/**
 * Stand-alone REST service client. Utilize Jersey JSR-311 Reference
 * implementation
 *
 * @author the-ramones
 */
public class XmlClient {

    protected final static Logger logger = Logger.getLogger(XmlClient.class.getName());
    private static final String HTTP_RS_URI = "http://localhost:8080/retail-rest/rest/price";
    private static final String HTTPS_RS_URI = "https://localhost:8181/retail-rest/rest/price";
    static PriceSource priceSource = PriceSource.getInstance();
    static ItemSource itemSource = ItemSource.getInstance();

    public static void main(String[] args) {
        String rsUri = HTTP_RS_URI;
        /*
         * Public access
         */
        logger.info("Public access to " + rsUri);
        consumeService(rsUri);
        /*
         * Secure connection
         */
        logger.info("Secure access to " + rsUri);
        rsUri = HTTPS_RS_URI;
        consumeService(rsUri);
    }

    private static void consumeService(String rsUri) {
        Client client = Client.create();

        WebResource webResource = client.resource(rsUri);

        List<Long> ids = Arrays.asList(new Long[]{1L, 2L, 3L, 4L, 5L, 6L});
        // test #1
        ClientResponse response = null;
        Price entity = null;

        // case #1. GET
        for (Long l : ids) {
            response = webResource.path(l.toString())
                    .accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
            entity = response.getEntity(Price.class);

            logger.info("GET status: " + response.getStatus());
            if (response.getStatus() == 200) {
                logger.info("GET succeeded, price is" + entity);
            } else {
                logger.warning("GET failed with HTTP status: " + response.getStatus());
            }
        }

        // case #2. POST
        for (Long l : ids) {
            BigDecimal formerPrice = priceSource.getPrice(l).getValue();
            response = webResource.path(l.toString())
                    .type(MediaType.APPLICATION_XML)
                    .post(ClientResponse.class, formerPrice.add(BigDecimal.valueOf(25.5)));

            logger.info("POST status: " + response.getStatus());
            if (response.getStatus() == 204) {
                logger.info("POST succeeded, price is" + formerPrice.add(BigDecimal.valueOf(25.5)));
            } else {
                logger.warning("POST failed with HTTP status: " + response.getStatus());
            }
        }


        // test #2

    }
}
