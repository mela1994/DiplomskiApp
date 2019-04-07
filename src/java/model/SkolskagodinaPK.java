/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nikola
 */
@Embeddable
public class SkolskagodinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rbr")
    private int rbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraKnjige")
    private int sifraKnjige;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraPredmeta")
    private int sifraPredmeta;

    public SkolskagodinaPK() {
    }

    public SkolskagodinaPK(int rbr, int sifraKnjige, int sifraPredmeta) {
        this.rbr = rbr;
        this.sifraKnjige = sifraKnjige;
        this.sifraPredmeta = sifraPredmeta;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public int getSifraKnjige() {
        return sifraKnjige;
    }

    public void setSifraKnjige(int sifraKnjige) {
        this.sifraKnjige = sifraKnjige;
    }

    public int getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(int sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rbr;
        hash += (int) sifraKnjige;
        hash += (int) sifraPredmeta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkolskagodinaPK)) {
            return false;
        }
        SkolskagodinaPK other = (SkolskagodinaPK) object;
        if (this.rbr != other.rbr) {
            return false;
        }
        if (this.sifraKnjige != other.sifraKnjige) {
            return false;
        }
        if (this.sifraPredmeta != other.sifraPredmeta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SkolskagodinaPK[ rbr=" + rbr + ", sifraKnjige=" + sifraKnjige + ", sifraPredmeta=" + sifraPredmeta + " ]";
    }
    
}
