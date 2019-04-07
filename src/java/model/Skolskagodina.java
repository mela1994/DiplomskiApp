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
@Table(name = "skolskagodina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skolskagodina.findAll", query = "SELECT s FROM Skolskagodina s")
    , @NamedQuery(name = "Skolskagodina.findByRbr", query = "SELECT s FROM Skolskagodina s WHERE s.skolskagodinaPK.rbr = :rbr")
    , @NamedQuery(name = "Skolskagodina.findBySifraKnjige", query = "SELECT s FROM Skolskagodina s WHERE s.skolskagodinaPK.sifraKnjige = :sifraKnjige")
    , @NamedQuery(name = "Skolskagodina.findBySifraPredmeta", query = "SELECT s FROM Skolskagodina s WHERE s.skolskagodinaPK.sifraPredmeta = :sifraPredmeta")
    , @NamedQuery(name = "Skolskagodina.findBySkolskaGodina", query = "SELECT s FROM Skolskagodina s WHERE s.skolskaGodina = :skolskaGodina")})
public class Skolskagodina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SkolskagodinaPK skolskagodinaPK;
    @Size(max = 250)
    @Column(name = "skolskaGodina")
    private String skolskaGodina;
    @JoinColumn(name = "sifraKnjige", referencedColumnName = "sifraKnjige", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Literatura literatura;
    @JoinColumn(name = "sifraPredmeta", referencedColumnName = "sifraPredmeta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Predmet predmet;

    public Skolskagodina() {
    }

    public Skolskagodina(SkolskagodinaPK skolskagodinaPK) {
        this.skolskagodinaPK = skolskagodinaPK;
    }

    public Skolskagodina(int rbr, int sifraKnjige, int sifraPredmeta) {
        this.skolskagodinaPK = new SkolskagodinaPK(rbr, sifraKnjige, sifraPredmeta);
    }

    public SkolskagodinaPK getSkolskagodinaPK() {
        return skolskagodinaPK;
    }

    public void setSkolskagodinaPK(SkolskagodinaPK skolskagodinaPK) {
        this.skolskagodinaPK = skolskagodinaPK;
    }

    public String getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(String skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public Literatura getLiteratura() {
        return literatura;
    }

    public void setLiteratura(Literatura literatura) {
        this.literatura = literatura;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skolskagodinaPK != null ? skolskagodinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skolskagodina)) {
            return false;
        }
        Skolskagodina other = (Skolskagodina) object;
        if ((this.skolskagodinaPK == null && other.skolskagodinaPK != null) || (this.skolskagodinaPK != null && !this.skolskagodinaPK.equals(other.skolskagodinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getSkolskaGodina();
    }
    
}
