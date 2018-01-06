package com.technohurdles.agronepal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by shakyas on 1/5/2018.
 */


public class Mediator implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("medId")
    private Long medId;
    @JsonProperty("medName")
    private String medName;
    @JsonProperty("medAddress")
    private String medAddress;
    @JsonProperty("medContact")
    private String medContact;
    @JsonProperty("medRegId")
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
        String str = medName + "\n" + medAddress + "\n" + medContact;
//        return "com.example.demo.model.Mediator[ medId=" + medId + " ]";
        return str;
    }

}


