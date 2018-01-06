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
@Table(name = "tbl_mediator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediator.findAll", query = "SELECT m FROM Mediator m")
    , @NamedQuery(name = "Mediator.findByMedId", query = "SELECT m FROM Mediator m WHERE m.medId = :medId")
    , @NamedQuery(name = "Mediator.findByMedName", query = "SELECT m FROM Mediator m WHERE m.medName = :medName")
    , @NamedQuery(name = "Mediator.findByMedAddress", query = "SELECT m FROM Mediator m WHERE m.medAddress = :medAddress")
    , @NamedQuery(name = "Mediator.findByMedContact", query = "SELECT m FROM Mediator m WHERE m.medContact = :medContact")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "medId")
public class Mediator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "med_id")
    private Long medId;
    @Size(max = 225)
    @Column(name = "med_name")
    private String medName;
    @Size(max = 225)
    @Column(name = "med_address")
    private String medAddress;
    @Size(max = 45)
    @Column(name = "med_contact")
    private String medContact;
    @JoinColumn(name = "med_reg_id", referencedColumnName = "reg_id")
    @ManyToOne(optional = false)
    private Region medRegId;

    public Mediator() {
    }

    public Mediator(Long medId) {
        this.medId = medId;
    }

    public Long getMedId() {
        return medId;
    }

    public void setMedId(Long medId) {
        this.medId = medId;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedAddress() {
        return medAddress;
    }

    public void setMedAddress(String medAddress) {
        this.medAddress = medAddress;
    }

    public String getMedContact() {
        return medContact;
    }

    public void setMedContact(String medContact) {
        this.medContact = medContact;
    }

    public Region getMedRegId() {
        return medRegId;
    }

    public void setMedRegId(Region medRegId) {
        this.medRegId = medRegId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medId != null ? medId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mediator)) {
            return false;
        }
        Mediator other = (Mediator) object;
        if ((this.medId == null && other.medId != null) || (this.medId != null && !this.medId.equals(other.medId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hurdles.agroNepal.model.Mediator[ medId=" + medId + " ]";
    }
    
}
