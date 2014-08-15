/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;

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

/**
 *
 * @author gaijin
 */
@Entity
@Table(catalog = "flymeapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "Flight.findByIdFl", query = "SELECT f FROM Flight f WHERE f.idFl = :idFl")})
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fl")
    private Integer idFl;
    @JoinColumn(name = "standby", referencedColumnName = "id_crew")
    @ManyToOne
    private Crew standby;
    @JoinColumn(name = "plane", referencedColumnName = "id_plane")
    @ManyToOne
    private Airplane plane;
    @JoinColumn(name = "crew", referencedColumnName = "id_crew")
    @ManyToOne
    private Crew crew;

    public Flight() {
    }

    public Flight(Integer idFl) {
        this.idFl = idFl;
    }

    public Integer getIdFl() {
        return idFl;
    }

    public void setIdFl(Integer idFl) {
        this.idFl = idFl;
    }

    public Crew getStandby() {
        return standby;
    }

    public void setStandby(Crew standby) {
        this.standby = standby;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFl != null ? idFl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.idFl == null && other.idFl != null) || (this.idFl != null && !this.idFl.equals(other.idFl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Flight[ idFl=" + idFl + " ]";
    }
    
}
