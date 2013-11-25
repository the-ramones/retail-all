package org.retail.shipment;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.retail.entity.Product;
import org.retail.info.Address;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class Shipment implements Serializable {

    private Long shipmentId;
    private ShipmentState shipmentState;
    private Calendar createdOn;
    private Address deliveryAddress;
    private Integer inpectionDays;
    private Product product;

    public Shipment() {
    }

    public Shipment(Long shipmentId, ShipmentState shipmentState, Calendar createdOn, Address deliveryAddress) {
        this.shipmentId = shipmentId;
        this.shipmentState = shipmentState;
        this.createdOn = createdOn;
        this.deliveryAddress = deliveryAddress;
    }

    @OneToOne
    @JoinTable(name = "productShipment")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn
    public ShipmentState getShipmentState() {
        return shipmentState;
    }

    public void setShipmentState(ShipmentState shipmentState) {
        this.shipmentState = shipmentState;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.shipmentId != null ? this.shipmentId.hashCode() : 0);
        hash = 53 * hash + (this.shipmentState != null ? this.shipmentState.hashCode() : 0);
        hash = 53 * hash + (this.createdOn != null ? this.createdOn.hashCode() : 0);
        hash = 53 * hash + (this.deliveryAddress != null ? this.deliveryAddress.hashCode() : 0);
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
        final Shipment other = (Shipment) obj;
        if (this.shipmentId != other.shipmentId && (this.shipmentId == null || !this.shipmentId.equals(other.shipmentId))) {
            return false;
        }
        if (this.shipmentState != other.shipmentState && (this.shipmentState == null || !this.shipmentState.equals(other.shipmentState))) {
            return false;
        }
        if (this.createdOn != other.createdOn && (this.createdOn == null || !this.createdOn.equals(other.createdOn))) {
            return false;
        }
        if (this.deliveryAddress != other.deliveryAddress && (this.deliveryAddress == null || !this.deliveryAddress.equals(other.deliveryAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shipment{" + "shipmentId=" + shipmentId + ", shipmentState=" + shipmentState + ", createdOn=" + createdOn + ", deliveryAddress=" + deliveryAddress + '}';
    }

    @Column
    public Integer getInpectionDays() {
        return inpectionDays;
    }

    public void setInpectionDays(Integer inpectionDays) {
        this.inpectionDays = inpectionDays;
    }
}
