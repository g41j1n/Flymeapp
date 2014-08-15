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

/**
 *
 * @author gaijin
 */
@Entity
@Table(catalog = "flymeapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Documentation.findAll", query = "SELECT d FROM Documentation d"),
    @NamedQuery(name = "Documentation.findByIdDocu", query = "SELECT d FROM Documentation d WHERE d.idDocu = :idDocu")})
public class Documentation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_docu")
    private Integer idDocu;
    @JoinColumn(name = "visa", referencedColumnName = "id_visa")
    @ManyToOne
    private Visa visa;
    @JoinColumn(name = "passport", referencedColumnName = "id_passport")
    @ManyToOne
    private Passport passport;
    @JoinColumn(name = "licencia", referencedColumnName = "id_licencia")
    @ManyToOne
    private Licencia licencia;
    @JoinColumn(name = "credencial", referencedColumnName = "id_credencial")
    @ManyToOne
    private Credencial credencial;
    @OneToMany(mappedBy = "documentation")
    private Collection<Persona> personaCollection;

    public Documentation() {
    }

    public Documentation(Integer idDocu) {
        this.idDocu = idDocu;
    }

    public Integer getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(Integer idDocu) {
        this.idDocu = idDocu;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
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
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentation)) {
            return false;
        }
        Documentation other = (Documentation) object;
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Documentation[ idDocu=" + idDocu + " ]";
    }
    
}
