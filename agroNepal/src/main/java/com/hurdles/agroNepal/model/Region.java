/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hurdles.agroNepal.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Perfect Sudip
 */
@Entity
@Table(name = "tbl_region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")
    , @NamedQuery(name = "Region.findByRegId", query = "SELECT r FROM Region r WHERE r.regId = :regId")
    , @NamedQuery(name = "Region.findByRegName", query = "SELECT r FROM Region r WHERE r.regName = :regName")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "regId")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reg_id")
    private Integer regId;
    @Size(max = 225)
    @Column(name = "reg_name")
    private String regName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopRegId")
    @JsonIgnore
    private Collection<Shop> shopCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodRegId")
    @JsonIgnore
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medRegId")
    @JsonIgnore
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

    @XmlTransient
    public Collection<Shop> getShopCollection() {
        return shopCollection;
    }

    public void setShopCollection(Collection<Shop> shopCollection) {
        this.shopCollection = shopCollection;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
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
        return "com.hurdles.agroNepal.model.Region[ regId=" + regId + " ]";
    }
    
}
