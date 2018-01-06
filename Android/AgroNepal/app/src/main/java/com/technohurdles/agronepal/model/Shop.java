package com.technohurdles.agronepal.model;

/**
 * Created by shakyas on 1/5/2018.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("shopId")
    private Long shopId;
    @JsonProperty("shopName")
    private String shopName;
    @JsonProperty("shopAddress")
    private String shopAddress;
    @JsonProperty("shopContact")
    private String shopContact;
    @JsonProperty("shopRegId")
    private Region shopRegId;

    public Shop() {
    }

    public Shop(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopContact() {
        return shopContact;
    }

    public void setShopContact(String shopContact) {
        this.shopContact = shopContact;
    }

    public Region getShopRegId() {
        return shopRegId;
    }

    public void setShopRegId(Region shopRegId) {
        this.shopRegId = shopRegId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopId != null ? shopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.shopId == null && other.shopId != null) || (this.shopId != null && !this.shopId.equals(other.shopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str = shopName + "\n" + shopAddress + "\n" + shopContact;
//        return "com.example.demo.model.Shop[ shopId=" + shopId + " ]";
        return str;
    }

}

