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
import javax.persistence.Lob;
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
@Table(name = "tbl_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProdId", query = "SELECT p FROM Product p WHERE p.prodId = :prodId")
    , @NamedQuery(name = "Product.findByProdName", query = "SELECT p FROM Product p WHERE p.prodName = :prodName")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "prodId")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_id")
    private Long prodId;
    @Size(max = 225)
    @Column(name = "prod_name")
    private String prodName;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "prod_decription")
    private String prodDecription;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "prod_requirement")
    private String prodRequirement;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "prod_procedure")
    private String prodProcedure;
    @JoinColumn(name = "prod_reg_id", referencedColumnName = "reg_id")
    @ManyToOne(optional = false)
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
        return "com.hurdles.agroNepal.model.Product[ prodId=" + prodId + " ]";
    }
    
}
