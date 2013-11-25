package org.retail.info;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class Address implements Serializable {

    private Long addressId;
    private String country;
    private String state;
    private String city;
    private String street;

    public Address() {
    }

    public Address(String country, String state, String city, String street) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Column(length = 255)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(length = 40)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "state_", length = 40)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(length = 40)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" + "addressId=" + addressId + ", country=" + country + ", state=" + state + ", city=" + city + ", street=" + street + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.addressId != null ? this.addressId.hashCode() : 0);
        hash = 31 * hash + (this.country != null ? this.country.hashCode() : 0);
        hash = 31 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 31 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 31 * hash + (this.street != null ? this.street.hashCode() : 0);
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
        final Address other = (Address) obj;
        if (this.addressId != other.addressId && (this.addressId == null || !this.addressId.equals(other.addressId))) {
            return false;
        }
        if ((this.country == null) ? (other.country != null) : !this.country.equals(other.country)) {
            return false;
        }
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state)) {
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
            return false;
        }
        if ((this.street == null) ? (other.street != null) : !this.street.equals(other.street)) {
            return false;
        }
        return true;
    }
}
