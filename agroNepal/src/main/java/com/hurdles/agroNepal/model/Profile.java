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
import javax.persistence.Lob;
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
@Table(name = "tbl_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findByProfId", query = "SELECT p FROM Profile p WHERE p.profId = :profId")
    , @NamedQuery(name = "Profile.findByProfName", query = "SELECT p FROM Profile p WHERE p.profName = :profName")
    , @NamedQuery(name = "Profile.findByProfAddress", query = "SELECT p FROM Profile p WHERE p.profAddress = :profAddress")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "profId")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prof_id")
    private Long profId;
    @Size(max = 225)
    @Column(name = "prof_name")
    private String profName;
    @Size(max = 255)
    @Column(name = "prof_address")
    private String profAddress;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "prof_description")
    private String profDescription;
    @Lob
    @Size(max = 65535)
    @Column(name = "topic")
    private String topic;

    public Profile() {
    }

    public Profile(Long profId) {
        this.profId = profId;
    }

    public Long getProfId() {
        return profId;
    }

    public void setProfId(Long profId) {
        this.profId = profId;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getProfAddress() {
        return profAddress;
    }

    public void setProfAddress(String profAddress) {
        this.profAddress = profAddress;
    }

    public String getProfDescription() {
        return profDescription;
    }

    public void setProfDescription(String profDescription) {
        this.profDescription = profDescription;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profId != null ? profId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.profId == null && other.profId != null) || (this.profId != null && !this.profId.equals(other.profId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hurdles.agroNepal.model.Profile[ profId=" + profId + " ]";
    }
    
}
