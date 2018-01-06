package com.technohurdles.agronepal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by shakyas on 1/5/2018.
 */


public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("regId")
    private Integer regId;
    @JsonProperty("regName")
    private String regName;
    @JsonProperty("shopCollection")
    private Collection<Shop> shopCollection;
    @JsonProperty("productCollection")
    private Collection<Product> productCollection;
    @JsonProperty("mediatorCollection")
    private Collection<Mediator> mediatorCollection;

    public Region() {
    }

    public Region(Integer regId) {
        this.regId = regId;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public Collection<Shop> getShopCollection() {
        return shopCollection;
    }

    public void setShopCollection(Collection<Shop> shopCollection) {
        this.shopCollection = shopCollection;
    }

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Collection<Mediator> getMediatorCollection() {
        return mediatorCollection;
    }

    public void setMediatorCollection(Collection<Mediator> mediatorCollection) {
        this.mediatorCollection = mediatorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Region[ regId=" + regId + " ]";
    }

}

