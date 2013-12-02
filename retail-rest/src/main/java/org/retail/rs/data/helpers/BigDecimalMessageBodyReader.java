package org.retail.rs.data.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author the-ramones
 */
@Consumes({MediaType.APPLICATION_XML})
@Provider
public class BigDecimalMessageBodyReader implements MessageBodyReader<BigDecimal> {

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BigDecimal readFrom(Class<BigDecimal> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
