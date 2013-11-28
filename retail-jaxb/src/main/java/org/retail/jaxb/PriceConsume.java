package org.retail.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.retail.jaxb.xml.Item;
import org.retail.jaxb.xml.Items;
import org.retail.jaxb.xml.Price;

/**
 *
 * @author the-ramones
 */
public class PriceConsume {

    protected static final Logger logger = Logger.getLogger(PriceConsume.class.getName());

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance("org.retail.jaxb.xml");
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            // Generic iPhone
            Item item = new Item();
            item.setId(100L);
            item.setName("iPhone");
            // iPhone 4G
            Item item2 = new Item();
            item2.setId(200L);
            item2.setName("iPhone 4G");
            // iPhone 5S
            Item item3 = new Item();
            item3.setId(300L);
            item3.setName("iPhone 5S");
            // iPhone 5C
            Item item4 = new Item();
            item4.setId(400L);
            item4.setName("iPhone 5C");

            // fill up the items tree            
            Items items = new Items();
            items.getItem().add(item);
            items.getItem().add(item2);
            items.getItem().add(item3);
            items.getItem().add(item4);

            Price price = new Price();
            price.setId(200);
            price.setItems(items);
            price.setValue(BigDecimal.valueOf(100.5));
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            XMLGregorianCalendar calendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gregorianCalendar);
            price.setDate(calendar);

            JAXBElement element = new JAXBElement(QName.valueOf("price"), Price.class, price);

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(element, new FileOutputStream("po.xml"));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(PriceConsume.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException jex) {
            logger.severe(jex.getMessage());
        } catch (FileNotFoundException ex) {
            logger.severe(ex.getMessage());
        }
    }
}
