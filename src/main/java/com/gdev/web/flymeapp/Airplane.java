/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gaijin
 */
@Entity
@Table(catalog = "flymeapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Airplane.findAll", query = "SELECT a FROM Airplane a"),
    @NamedQuery(name = "Airplane.findByIdPlane", query = "SELECT a FROM Airplane a WHERE a.idPlane = :idPlane"),
    @NamedQuery(name = "Airplane.findByPlate", query = "SELECT a FROM Airplane a WHERE a.plate = :plate")})
public class Airplane implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plane")
    private Integer idPlane;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String plate;
    @OneToMany(mappedBy = "plane")
    private Collection<Flight> flightCollection;
    @JoinColumn(name = "model", referencedColumnName = "id_mod")
    @ManyToOne
    private Model model;

    public Airplane() {
    }

    public Airplane(Integer idPlane) {
        this.idPlane = idPlane;
    }

    public Airplane(Integer idPlane, String plate) {
        this.idPlane = idPlane;
        this.plate = plate;
    }

    public Integer getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Integer idPlane) {
        this.idPlane = idPlane;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlane != null ? idPlane.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airplane)) {
            return false;
        }
        Airplane other = (Airplane) object;
        if ((this.idPlane == null && other.idPlane != null) || (this.idPlane != null && !this.idPlane.equals(other.idPlane))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Airplane[ idPlane=" + idPlane + " ]";
    }
    
}
