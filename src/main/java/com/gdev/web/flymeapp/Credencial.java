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
    @NamedQuery(name = "Credencial.findAll", query = "SELECT c FROM Credencial c"),
    @NamedQuery(name = "Credencial.findByIdCredencial", query = "SELECT c FROM Credencial c WHERE c.idCredencial = :idCredencial"),
    @NamedQuery(name = "Credencial.findByExpedita", query = "SELECT c FROM Credencial c WHERE c.expedita = :expedita"),
    @NamedQuery(name = "Credencial.findByExplira", query = "SELECT c FROM Credencial c WHERE c.explira = :explira")})
public class Credencial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_credencial")
    private Integer idCredencial;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date expedita;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date explira;
    @OneToMany(mappedBy = "credencial")
    private Collection<Documentation> documentationCollection;

    public Credencial() {
    }

    public Credencial(Integer idCredencial) {
        this.idCredencial = idCredencial;
    }

    public Credencial(Integer idCredencial, Date expedita, Date explira) {
        this.idCredencial = idCredencial;
        this.expedita = expedita;
        this.explira = explira;
    }

    public Integer getIdCredencial() {
        return idCredencial;
    }

    public void setIdCredencial(Integer idCredencial) {
        this.idCredencial = idCredencial;
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
        hash += (idCredencial != null ? idCredencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credencial)) {
            return false;
        }
        Credencial other = (Credencial) object;
        if ((this.idCredencial == null && other.idCredencial != null) || (this.idCredencial != null && !this.idCredencial.equals(other.idCredencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Credencial[ idCredencial=" + idCredencial + " ]";
    }
    
}
