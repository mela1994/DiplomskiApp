/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nikola
 */
@Entity
@Table(name = "uloga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uloga.findAll", query = "SELECT u FROM Uloga u")
    , @NamedQuery(name = "Uloga.findByRbr", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.rbr = :rbr")
    , @NamedQuery(name = "Uloga.findBySifraPre", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.sifraPre = :sifraPre")
    , @NamedQuery(name = "Uloga.findBySifraZap", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.sifraZap = :sifraZap")
    , @NamedQuery(name = "Uloga.findByNazivUloge", query = "SELECT u FROM Uloga u WHERE u.nazivUloge = :nazivUloge")})
public class Uloga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UlogaPK ulogaPK;
    @Size(max = 250)
    @Column(name = "nazivUloge")
    private String nazivUloge;
    @JoinColumn(name = "sifraPre", referencedColumnName = "sifraPredmeta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Predmet predmet;
    @JoinColumn(name = "sifraZap", referencedColumnName = "sifraZaposlenog", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zaposleni zaposleni;

    public Uloga() {
    }

    public Uloga(UlogaPK ulogaPK) {
        this.ulogaPK = ulogaPK;
    }

    public Uloga(int rbr, int sifraPre, int sifraZap) {
        this.ulogaPK = new UlogaPK(rbr, sifraPre, sifraZap);
    }

    public UlogaPK getUlogaPK() {
        return ulogaPK;
    }

    public void setUlogaPK(UlogaPK ulogaPK) {
        this.ulogaPK = ulogaPK;
    }

    public String getNazivUloge() {
        return nazivUloge;
    }

    public void setNazivUloge(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ulogaPK != null ? ulogaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uloga)) {
            return false;
        }
        Uloga other = (Uloga) object;
        if ((this.ulogaPK == null && other.ulogaPK != null) || (this.ulogaPK != null && !this.ulogaPK.equals(other.ulogaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNazivUloge();
    }
    
}
