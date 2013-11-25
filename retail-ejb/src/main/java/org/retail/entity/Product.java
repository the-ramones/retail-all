package org.retail.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class Product implements Serializable {

    private Long itemId;
    private String title;
    private Set<Feature> features;
    private Family family;
    private String description;

    public Product() {
    }

    public Product(Long itemId, String title, Set<Feature> features, Family family) {
        this.itemId = itemId;
        this.title = title;
        this.features = features;
        this.family = family;
    }

    public Product(Long itemId, String title) {
        this.itemId = itemId;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(length = 255, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "productfeatures")
    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Family.class)
    @JoinColumn(nullable = false)
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Column(length = 4096)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", title=" + title + ", features=" + features + ", family=" + family + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.itemId != null ? this.itemId.hashCode() : 0);
        hash = 19 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 19 * hash + (this.family != null ? this.family.hashCode() : 0);
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
        final Product other = (Product) obj;
        if (this.itemId != other.itemId && (this.itemId == null || !this.itemId.equals(other.itemId))) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        for (Feature feature : this.features) {
            if (!other.features.contains(feature)) {
                return false;
            }
        }
        if (this.family != other.family && (this.family == null || !this.family.equals(other.family))) {
            return false;
        }
        return true;
    }
}
