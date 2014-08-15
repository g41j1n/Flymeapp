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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Ocupation.findAll", query = "SELECT o FROM Ocupation o"),
    @NamedQuery(name = "Ocupation.findByIdOcu", query = "SELECT o FROM Ocupation o WHERE o.idOcu = :idOcu"),
    @NamedQuery(name = "Ocupation.findByOcupacion", query = "SELECT o FROM Ocupation o WHERE o.ocupacion = :ocupacion")})
public class Ocupation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ocu")
    private Integer idOcu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String ocupacion;
    @Lob
    @Size(max = 65535)
    private String funciones;
    @OneToMany(mappedBy = "ocupation")
    private Collection<Persona> personaCollection;

    public Ocupation() {
    }

    public Ocupation(Integer idOcu) {
        this.idOcu = idOcu;
    }

    public Ocupation(Integer idOcu, String ocupacion) {
        this.idOcu = idOcu;
        this.ocupacion = ocupacion;
    }

    public Integer getIdOcu() {
        return idOcu;
    }

    public void setIdOcu(Integer idOcu) {
        this.idOcu = idOcu;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcu != null ? idOcu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocupation)) {
            return false;
        }
        Ocupation other = (Ocupation) object;
        if ((this.idOcu == null && other.idOcu != null) || (this.idOcu != null && !this.idOcu.equals(other.idOcu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Ocupation[ idOcu=" + idOcu + " ]";
    }
    
}
