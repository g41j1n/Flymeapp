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
import javax.validation.constraints.Size;

/**
 *
 * @author gaijin
 */
@Entity
@Table(catalog = "flymeapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Crew.findAll", query = "SELECT c FROM Crew c"),
    @NamedQuery(name = "Crew.findByIdCrew", query = "SELECT c FROM Crew c WHERE c.idCrew = :idCrew"),
    @NamedQuery(name = "Crew.findByStats", query = "SELECT c FROM Crew c WHERE c.stats = :stats")})
public class Crew implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_crew")
    private Integer idCrew;
    @Size(max = 20)
    private String stats;
    @OneToMany(mappedBy = "standby")
    private Collection<Flight> flightCollection;
    @OneToMany(mappedBy = "crew")
    private Collection<Flight> flightCollection1;
    @JoinColumn(name = "sb2", referencedColumnName = "id_per")
    @ManyToOne
    private Persona sb2;
    @JoinColumn(name = "sb1", referencedColumnName = "id_per")
    @ManyToOne
    private Persona sb1;
    @JoinColumn(name = "copiloto", referencedColumnName = "id_per")
    @ManyToOne
    private Persona copiloto;
    @JoinColumn(name = "piloto", referencedColumnName = "id_per")
    @ManyToOne
    private Persona piloto;

    public Crew() {
    }

    public Crew(Integer idCrew) {
        this.idCrew = idCrew;
    }

    public Integer getIdCrew() {
        return idCrew;
    }

    public void setIdCrew(Integer idCrew) {
        this.idCrew = idCrew;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    public Collection<Flight> getFlightCollection1() {
        return flightCollection1;
    }

    public void setFlightCollection1(Collection<Flight> flightCollection1) {
        this.flightCollection1 = flightCollection1;
    }

    public Persona getSb2() {
        return sb2;
    }

    public void setSb2(Persona sb2) {
        this.sb2 = sb2;
    }

    public Persona getSb1() {
        return sb1;
    }

    public void setSb1(Persona sb1) {
        this.sb1 = sb1;
    }

    public Persona getCopiloto() {
        return copiloto;
    }

    public void setCopiloto(Persona copiloto) {
        this.copiloto = copiloto;
    }

    public Persona getPiloto() {
        return piloto;
    }

    public void setPiloto(Persona piloto) {
        this.piloto = piloto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCrew != null ? idCrew.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crew)) {
            return false;
        }
        Crew other = (Crew) object;
        if ((this.idCrew == null && other.idCrew != null) || (this.idCrew != null && !this.idCrew.equals(other.idCrew))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdev.web.flymeapp.Crew[ idCrew=" + idCrew + " ]";
    }
    
}
