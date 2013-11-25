package org.retail.entity.finance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.retail.entity.Feature;
import org.retail.entity.Product;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class Price implements Serializable {

    private Long priceId;
    private Product item;
    private Feature feature;
    private BigDecimal value;
    private Calendar endorsedFrom;

    public Price() {
    }

    public Price(Long priceId, Product item, Feature feature, BigDecimal value, Calendar endorsedFrom) {
        this.priceId = priceId;
        this.item = item;
        this.feature = feature;
        this.value = value;
        this.endorsedFrom = endorsedFrom;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Calendar getEndorsedFrom() {
        return endorsedFrom;
    }

    public void setEndorsedFrom(Calendar endorsedFrom) {
        this.endorsedFrom = endorsedFrom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    @ManyToOne
    @JoinColumn
    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    @ManyToOne
    @JoinColumn
    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    @Column(name = "price", precision = 50, scale = 2)
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.priceId != null ? this.priceId.hashCode() : 0);
        hash = 53 * hash + (this.item != null ? this.item.hashCode() : 0);
        hash = 53 * hash + (this.feature != null ? this.feature.hashCode() : 0);
        hash = 53 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 53 * hash + (this.endorsedFrom != null ? this.endorsedFrom.hashCode() : 0);
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
        if (this.priceId != other.priceId && (this.priceId == null || !this.priceId.equals(other.priceId))) {
            return false;
        }
        if (this.item != other.item && (this.item == null || !this.item.equals(other.item))) {
            return false;
        }
        if (this.feature != other.feature && (this.feature == null || !this.feature.equals(other.feature))) {
            return false;
        }
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        if (this.endorsedFrom != other.endorsedFrom && (this.endorsedFrom == null || !this.endorsedFrom.equals(other.endorsedFrom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Price{" + "priceId=" + priceId + ", item=" + item + ", feature=" + feature + ", value=" + value + ", endorsedFrom=" + endorsedFrom + '}';
    }
}
