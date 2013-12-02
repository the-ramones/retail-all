package org.retail.rs.data.helpers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author the-ramones
 */
@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Provider
public class BigDecimalMessageBodyWriter implements MessageBodyWriter<BigDecimal> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        if (mt.equals(MediaType.APPLICATION_XML) || mt.equals(MediaType.TEXT_XML)) {
            return true;
        }
        return false;
    }

    @Override
    public long getSize(BigDecimal t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(BigDecimal t, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out) throws IOException, WebApplicationException {
        byte[] b = null;
        try {
            XMLEventWriter xml = XMLOutputFactory.newFactory().createXMLEventWriter(out, "UTF-8");
            
            //xml.add(new XMLEvent());
            
           // xml.add(XMLEvent.START_DOCUMENT);
            out.write(b);
        } catch (XMLStreamException ex) {
            throw new IOException(ex);
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
}
