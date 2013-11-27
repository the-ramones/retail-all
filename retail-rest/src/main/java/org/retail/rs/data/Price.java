package org.retail.rs.data;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author the-ramones
 */
@XmlRootElement(name = "price")
@XmlAccessorType(XmlAccessType.FIELD)
public class Price {

    @XmlAttribute(required = true)
    private long id;
    @XmlElement(required = true)
    private BigDecimal value;
    @XmlElement(required = true)
    private Item item;
    @XmlElement(required = true)
    private Date date;

    public Price() {
    }

    public Price(long id, BigDecimal value, Item item, Date date) {
        this.id = id;
        this.value = value;
        this.item = item;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Item getItem() {
        return item;
    }

    public void setName(Item item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 43 * hash + (this.item != null ? this.item.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Price other = (Price) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        if (this.item != other.item && (this.item == null || !this.item.equals(other.item))) {
            return false;
        }
        if (this.date != other.date && (this.date == null || !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Price{" + "id=" + id + ", value=" + value + ", item=" + item + ", date=" + date + '}';
    }
}
