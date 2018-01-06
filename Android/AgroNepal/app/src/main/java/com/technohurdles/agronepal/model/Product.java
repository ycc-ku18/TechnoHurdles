package com.technohurdles.agronepal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by shakyas on 1/5/2018.
 */


public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("prodId")
    private Long prodId;
    @JsonProperty("prodName")
    private String prodName;
    @JsonProperty("prodDecription")
    private String prodDecription;
    @JsonProperty("prodRequirement")
    private String prodRequirement;
    @JsonProperty("prodProcedure")
    private String prodProcedure;
    @JsonProperty("prodRegId")
    private Region prodRegId;

    public Product() {
    }

    public Product(Long prodId) {
        this.prodId = prodId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDecription() {
        return prodDecription;
    }

    public void setProdDecription(String prodDecription) {
        this.prodDecription = prodDecription;
    }

    public String getProdRequirement() {
        return prodRequirement;
    }

    public void setProdRequirement(String prodRequirement) {
        this.prodRequirement = prodRequirement;
    }

    public String getProdProcedure() {
        return prodProcedure;
    }

    public void setProdProcedure(String prodProcedure) {
        this.prodProcedure = prodProcedure;
    }

    public Region getProdRegId() {
        return prodRegId;
    }

    public void setProdRegId(Region prodRegId) {
        this.prodRegId = prodRegId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Product[ prodId=" + prodId + " ]";
    }
}


