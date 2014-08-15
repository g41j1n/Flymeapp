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
@Table(name="usr")
public class Usr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usr")
    private Integer idUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String password;
    @OneToMany(mappedBy = "usr")
    private Collection<Persona> personaCollection;

    public Usr() {
    }

    public Usr(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public Usr(Integer idUsr, String user, String password) {
        this.idUsr = idUsr;
        this.user = user;
        this.password = password;
    }

    public Integer getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (idUsr != null ? idUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usr)) {
            return false;
        }
        Usr other = (Usr) object;
        if ((this.idUsr == null && other.idUsr != null) || (this.idUsr != null && !this.idUsr.equals(other.idUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Usr[ idUsr=" + idUsr + " ]";
    }
    
}
