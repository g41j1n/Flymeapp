/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gaijin
 */
@Entity
@Table(catalog = "flymeapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Passport.findAll", query = "SELECT p FROM Passport p"),
    @NamedQuery(name = "Passport.findByIdPassport", query = "SELECT p FROM Passport p WHERE p.idPassport = :idPassport"),
    @NamedQuery(name = "Passport.findByExpedita", query = "SELECT p FROM Passport p WHERE p.expedita = :expedita"),
    @NamedQuery(name = "Passport.findByExplira", query = "SELECT p FROM Passport p WHERE p.explira = :explira")})
public class Passport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_passport")
    private Integer idPassport;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date expedita;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date explira;
    @OneToMany(mappedBy = "passport")
    private Collection<Documentation> documentationCollection;

    public Passport() {
    }

    public Passport(Integer idPassport) {
        this.idPassport = idPassport;
    }

    public Passport(Integer idPassport, Date expedita, Date explira) {
        this.idPassport = idPassport;
        this.expedita = expedita;
        this.explira = explira;
    }

    public Integer getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(Integer idPassport) {
        this.idPassport = idPassport;
    }

    public Date getExpedita() {
        return expedita;
    }

    public void setExpedita(Date expedita) {
        this.expedita = expedita;
    }

    public Date getExplira() {
        return explira;
    }

    public void setExplira(Date explira) {
        this.explira = explira;
    }

    public Collection<Documentation> getDocumentationCollection() {
        return documentationCollection;
    }

    public void setDocumentationCollection(Collection<Documentation> documentationCollection) {
        this.documentationCollection = documentationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPassport != null ? idPassport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passport)) {
            return false;
        }
        Passport other = (Passport) object;
        if ((this.idPassport == null && other.idPassport != null) || (this.idPassport != null && !this.idPassport.equals(other.idPassport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Passport[ idPassport=" + idPassport + " ]";
    }
    
}
