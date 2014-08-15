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
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPer", query = "SELECT p FROM Persona p WHERE p.idPer = :idPer"),
    @NamedQuery(name = "Persona.findByName", query = "SELECT p FROM Persona p WHERE p.name = :name"),
    @NamedQuery(name = "Persona.findByLname", query = "SELECT p FROM Persona p WHERE p.lname = :lname")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_per")
    private Integer idPer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String lname;
    @OneToMany(mappedBy = "sb2")
    private Collection<Crew> crewCollection;
    @OneToMany(mappedBy = "sb1")
    private Collection<Crew> crewCollection1;
    @OneToMany(mappedBy = "copiloto")
    private Collection<Crew> crewCollection2;
    @OneToMany(mappedBy = "piloto")
    private Collection<Crew> crewCollection3;
    @JoinColumn(name = "usr", referencedColumnName = "id_usr")
    @ManyToOne
    private Usr usr;
    @JoinColumn(name = "ocupation", referencedColumnName = "id_ocu")
    @ManyToOne
    private Ocupation ocupation;
    @JoinColumn(name = "documentation", referencedColumnName = "id_docu")
    @ManyToOne
    private Documentation documentation;

    public Persona() {
    }

    public Persona(Integer idPer) {
        this.idPer = idPer;
    }

    public Persona(Integer idPer, String name, String lname) {
        this.idPer = idPer;
        this.name = name;
        this.lname = lname;
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Collection<Crew> getCrewCollection() {
        return crewCollection;
    }

    public void setCrewCollection(Collection<Crew> crewCollection) {
        this.crewCollection = crewCollection;
    }

    public Collection<Crew> getCrewCollection1() {
        return crewCollection1;
    }

    public void setCrewCollection1(Collection<Crew> crewCollection1) {
        this.crewCollection1 = crewCollection1;
    }

    public Collection<Crew> getCrewCollection2() {
        return crewCollection2;
    }

    public void setCrewCollection2(Collection<Crew> crewCollection2) {
        this.crewCollection2 = crewCollection2;
    }

    public Collection<Crew> getCrewCollection3() {
        return crewCollection3;
    }

    public void setCrewCollection3(Collection<Crew> crewCollection3) {
        this.crewCollection3 = crewCollection3;
    }

    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }

    public Ocupation getOcupation() {
        return ocupation;
    }

    public void setOcupation(Ocupation ocupation) {
        this.ocupation = ocupation;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(Documentation documentation) {
        this.documentation = documentation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPer != null ? idPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPer == null && other.idPer != null) || (this.idPer != null && !this.idPer.equals(other.idPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Persona[ idPer=" + idPer + " ]";
    }
    
}
