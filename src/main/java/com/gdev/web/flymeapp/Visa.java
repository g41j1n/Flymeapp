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
    @NamedQuery(name = "Visa.findAll", query = "SELECT v FROM Visa v"),
    @NamedQuery(name = "Visa.findByIdVisa", query = "SELECT v FROM Visa v WHERE v.idVisa = :idVisa"),
    @NamedQuery(name = "Visa.findByExpedita", query = "SELECT v FROM Visa v WHERE v.expedita = :expedita"),
    @NamedQuery(name = "Visa.findByExplira", query = "SELECT v FROM Visa v WHERE v.explira = :explira")})
public class Visa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_visa")
    private Integer idVisa;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date expedita;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date explira;
    @OneToMany(mappedBy = "visa")
    private Collection<Documentation> documentationCollection;

    public Visa() {
    }

    public Visa(Integer idVisa) {
        this.idVisa = idVisa;
    }

    public Visa(Integer idVisa, Date expedita, Date explira) {
        this.idVisa = idVisa;
        this.expedita = expedita;
        this.explira = explira;
    }

    public Integer getIdVisa() {
        return idVisa;
    }

    public void setIdVisa(Integer idVisa) {
        this.idVisa = idVisa;
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
        hash += (idVisa != null ? idVisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visa)) {
            return false;
        }
        Visa other = (Visa) object;
        if ((this.idVisa == null && other.idVisa != null) || (this.idVisa != null && !this.idVisa.equals(other.idVisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Visa[ idVisa=" + idVisa + " ]";
    }
    
}
