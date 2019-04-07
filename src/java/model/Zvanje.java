/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nikola
 */
@Entity
@Table(name = "zvanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zvanje.findAll", query = "SELECT z FROM Zvanje z")
    , @NamedQuery(name = "Zvanje.findBySifraZvanja", query = "SELECT z FROM Zvanje z WHERE z.sifraZvanja = :sifraZvanja")
    , @NamedQuery(name = "Zvanje.findByNazivZvanja", query = "SELECT z FROM Zvanje z WHERE z.nazivZvanja = :nazivZvanja")})
public class Zvanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraZvanja")
    private Integer sifraZvanja;
    @Size(max = 200)
    @Column(name = "nazivZvanja")
    private String nazivZvanja;
    @OneToMany(mappedBy = "sifraZvanja")
    private List<Zaposleni> zaposleniList;

    public Zvanje() {
    }

    public Zvanje(Integer sifraZvanja) {
        this.sifraZvanja = sifraZvanja;
    }

    public Integer getSifraZvanja() {
        return sifraZvanja;
    }

    public void setSifraZvanja(Integer sifraZvanja) {
        this.sifraZvanja = sifraZvanja;
    }

    public String getNazivZvanja() {
        return nazivZvanja;
    }

    public void setNazivZvanja(String nazivZvanja) {
        this.nazivZvanja = nazivZvanja;
    }

    @XmlTransient
    public List<Zaposleni> getZaposleniList() {
        return zaposleniList;
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraZvanja != null ? sifraZvanja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zvanje)) {
            return false;
        }
        Zvanje other = (Zvanje) object;
        if ((this.sifraZvanja == null && other.sifraZvanja != null) || (this.sifraZvanja != null && !this.sifraZvanja.equals(other.sifraZvanja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNazivZvanja();
    }
    
}
