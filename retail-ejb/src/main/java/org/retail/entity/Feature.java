package org.retail.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class Feature implements Serializable{

    Long featureId;
    String title;
    Set<Product> item;
    String description;

    public Feature() {
    }

    public Feature(String title) {
        this.title = title;
    }

    public Feature(Long featureId, String title, Set<Product> item) {
        this.featureId = featureId;
        this.title = title;
        this.item = item;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    @Column(length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "features")
    public Set<Product> getItem() {
        return item;
    }

    public void setItem(Set<Product> item) {
        this.item = item;
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
        return "Feature{" + "featureId=" + featureId + ", title=" + title + ", item=" + item + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.featureId != null ? this.featureId.hashCode() : 0);
        hash = 89 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 89 * hash + (this.item != null ? this.item.hashCode() : 0);
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
        final Feature other = (Feature) obj;
        if (this.featureId != other.featureId && (this.featureId == null || !this.featureId.equals(other.featureId))) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if (this.item != other.item && (this.item == null || !this.item.equals(other.item))) {
            return false;
        }
        return true;
    }
}
