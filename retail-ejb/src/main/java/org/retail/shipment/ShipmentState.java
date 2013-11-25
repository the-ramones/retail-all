package org.retail.shipment;

import java.io.Serializable;
import javax.persistence.Basic;
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
public class ShipmentState implements 
        Serializable{

    private Long shipmentStateId;
    private Long shipmentState;

    public ShipmentState() {
    }

    public ShipmentState(Long shipmentStateId, Long shipmentState) {
        this.shipmentStateId = shipmentStateId;
        this.shipmentState = shipmentState;
    }

    @Basic
    @Column(length = 40, nullable = false)
    public Long getShipmentState() {
        return shipmentState;
    }

    public void setShipmentState(Long shipmentState) {
        this.shipmentState = shipmentState;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getShipmentStateId() {
        return shipmentStateId;
    }

    public void setShipmentStateId(Long shipmentStateId) {
        this.shipmentStateId = shipmentStateId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.shipmentStateId != null ? this.shipmentStateId.hashCode() : 0);
        hash = 67 * hash + (this.shipmentState != null ? this.shipmentState.hashCode() : 0);
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
        final ShipmentState other = (ShipmentState) obj;
        if (this.shipmentStateId != other.shipmentStateId && (this.shipmentStateId == null || !this.shipmentStateId.equals(other.shipmentStateId))) {
            return false;
        }
        if (this.shipmentState != other.shipmentState && (this.shipmentState == null || !this.shipmentState.equals(other.shipmentState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShipmentState{" + "shipmentStateId=" + shipmentStateId + ", shipmentState=" + shipmentState + '}';
    }
}
