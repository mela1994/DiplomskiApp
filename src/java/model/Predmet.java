/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nikola
 */
@Entity
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
    , @NamedQuery(name = "Predmet.findBySifraPredmeta", query = "SELECT p FROM Predmet p WHERE p.sifraPredmeta = :sifraPredmeta")
    , @NamedQuery(name = "Predmet.findByNazivPredmeta", query = "SELECT p FROM Predmet p WHERE p.nazivPredmeta = :nazivPredmeta")
    , @NamedQuery(name = "Predmet.findByBrojESPB", query = "SELECT p FROM Predmet p WHERE p.brojESPB = :brojESPB")})
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraPredmeta")
    private Integer sifraPredmeta;
    @Size(max = 200)
    @Column(name = "nazivPredmeta")
    private String nazivPredmeta;
    @Size(max = 200)
    @Column(name = "brojESPB")
    private String brojESPB;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmet")
    private List<Uloga> ulogaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmet")
    private List<Skolskagodina> skolskagodinaList;
    @JoinColumn(name = "sifraKatedre", referencedColumnName = "sifraKatedre")
    @ManyToOne
    private Katedra sifraKatedre;

    public Predmet() {
    }

    public Predmet(Integer sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public Integer getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(Integer sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(String brojESPB) {
        this.brojESPB = brojESPB;
    }

    @XmlTransient
    public List<Uloga> getUlogaList() {
        return ulogaList;
    }

    public void setUlogaList(List<Uloga> ulogaList) {
        this.ulogaList = ulogaList;
    }

    @XmlTransient
    public List<Skolskagodina> getSkolskagodinaList() {
        return skolskagodinaList;
    }

    public void setSkolskagodinaList(List<Skolskagodina> skolskagodinaList) {
        this.skolskagodinaList = skolskagodinaList;
    }

    public Katedra getSifraKatedre() {
        return sifraKatedre;
    }

    public void setSifraKatedre(Katedra sifraKatedre) {
        this.sifraKatedre = sifraKatedre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraPredmeta != null ? sifraPredmeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.sifraPredmeta == null && other.sifraPredmeta != null) || (this.sifraPredmeta != null && !this.sifraPredmeta.equals(other.sifraPredmeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNazivPredmeta();
    }
    
}
