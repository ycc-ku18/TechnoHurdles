/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Perfect Sudip
 */
@Entity
@Table(name = "tbl_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s")
    , @NamedQuery(name = "Shop.findByShopId", query = "SELECT s FROM Shop s WHERE s.shopId = :shopId")
    , @NamedQuery(name = "Shop.findByShopName", query = "SELECT s FROM Shop s WHERE s.shopName = :shopName")
    , @NamedQuery(name = "Shop.findByShopAddress", query = "SELECT s FROM Shop s WHERE s.shopAddress = :shopAddress")
    , @NamedQuery(name = "Shop.findByShopContact", query = "SELECT s FROM Shop s WHERE s.shopContact = :shopContact")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "shopId")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shop_id")
    private Long shopId;
    @Size(max = 45)
    @Column(name = "shop_name")
    private String shopName;
    @Size(max = 225)
    @Column(name = "shop_address")
    private String shopAddress;
    @Size(max = 45)
    @Column(name = "shop_contact")
    private String shopContact;
    @JoinColumn(name = "shop_reg_id", referencedColumnName = "reg_id")
    @ManyToOne(optional = false)
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
        return "com.hurdles.agroNepal.model.Shop[ shopId=" + shopId + " ]";
    }
    
}
