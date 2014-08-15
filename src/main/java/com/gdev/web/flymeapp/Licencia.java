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
    @NamedQuery(name = "Licencia.findAll", query = "SELECT l FROM Licencia l"),
    @NamedQuery(name = "Licencia.findByIdLicencia", query = "SELECT l FROM Licencia l WHERE l.idLicencia = :idLicencia"),
    @NamedQuery(name = "Licencia.findByExpedita", query = "SELECT l FROM Licencia l WHERE l.expedita = :expedita"),
    @NamedQuery(name = "Licencia.findByExplira", query = "SELECT l FROM Licencia l WHERE l.explira = :explira")})
public class Licencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_licencia")
    private Integer idLicencia;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date expedita;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date explira;
    @OneToMany(mappedBy = "licencia")
    private Collection<Documentation> documentationCollection;

    public Licencia() {
    }

    public Licencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Licencia(Integer idLicencia, Date expedita, Date explira) {
        this.idLicencia = idLicencia;
        this.expedita = expedita;
        this.explira = explira;
    }

    public Integer getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
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
        hash += (idLicencia != null ? idLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.idLicencia == null && other.idLicencia != null) || (this.idLicencia != null && !this.idLicencia.equals(other.idLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Licencia[ idLicencia=" + idLicencia + " ]";
    }
    
}
