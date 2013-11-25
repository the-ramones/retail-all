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
import org.retail.entity.Family;
import org.retail.entity.Feature;
import org.retail.entity.Product;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class Discount implements Serializable {

    private Long discountId;
    private Product item;
    private Feature feature;
    private Family family;
    private BigDecimal value;
    private Calendar endorsedFrom;

    public Discount() {
    }

    public Discount(Product item, Feature feature, Family family, BigDecimal value, Calendar endorsedFrom) {
        this.item = item;
        this.feature = feature;
        this.family = family;
        this.value = value;
        this.endorsedFrom = endorsedFrom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getEndorsedFrom() {
        return endorsedFrom;
    }

    public void setEndorsedFrom(Calendar endorsedFrom) {
        this.endorsedFrom = endorsedFrom;
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

    @ManyToOne
    @JoinColumn
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Column(name = "value_", nullable = false, precision = 50, scale = 2)
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.item != null ? this.item.hashCode() : 0);
        hash = 71 * hash + (this.feature != null ? this.feature.hashCode() : 0);
        hash = 71 * hash + (this.family != null ? this.family.hashCode() : 0);
        hash = 71 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 71 * hash + (this.endorsedFrom != null ? this.endorsedFrom.hashCode() : 0);
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
        final Discount other = (Discount) obj;
        if (this.item != other.item && (this.item == null || !this.item.equals(other.item))) {
            return false;
        }
        if (this.feature != other.feature && (this.feature == null || !this.feature.equals(other.feature))) {
            return false;
        }
        if (this.family != other.family && (this.family == null || !this.family.equals(other.family))) {
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
        return "Discounts{" + "item=" + item + ", feature=" + feature + ", family=" + family + ", value=" + value + ", endorsedFrom=" + endorsedFrom + '}';
    }
}
