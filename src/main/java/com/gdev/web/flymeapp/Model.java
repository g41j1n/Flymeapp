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
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m"),
    @NamedQuery(name = "Model.findByIdMod", query = "SELECT m FROM Model m WHERE m.idMod = :idMod"),
    @NamedQuery(name = "Model.findByModel", query = "SELECT m FROM Model m WHERE m.model = :model")})
public class Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mod")
    private Integer idMod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String model;
    @OneToMany(mappedBy = "model")
    private Collection<Airplane> airplaneCollection;

    public Model() {
    }

    public Model(Integer idMod) {
        this.idMod = idMod;
    }

    public Model(Integer idMod, String model) {
        this.idMod = idMod;
        this.model = model;
    }

    public Integer getIdMod() {
        return idMod;
    }

    public void setIdMod(Integer idMod) {
        this.idMod = idMod;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Collection<Airplane> getAirplaneCollection() {
        return airplaneCollection;
    }

    public void setAirplaneCollection(Collection<Airplane> airplaneCollection) {
        this.airplaneCollection = airplaneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMod != null ? idMod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.idMod == null && other.idMod != null) || (this.idMod != null && !this.idMod.equals(other.idMod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Model[ idMod=" + idMod + " ]";
    }
    
}
