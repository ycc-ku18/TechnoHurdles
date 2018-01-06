package com.technohurdles.agronepal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by shakyas on 1/5/2018.
 */

public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("profId")
    private Long profId;
    @JsonProperty("profName")
    private String profName;
    @JsonProperty("profAddress")
    private String profAddress;
    @JsonProperty("profDescription")
    private String profDescription;
    @JsonProperty("topic")
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
