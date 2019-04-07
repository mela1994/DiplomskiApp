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
public class UlogaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rbr")
    private int rbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraPre")
    private int sifraPre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraZap")
    private int sifraZap;

    public UlogaPK() {
    }

    public UlogaPK(int rbr, int sifraPre, int sifraZap) {
        this.rbr = rbr;
        this.sifraPre = sifraPre;
        this.sifraZap = sifraZap;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public int getSifraPre() {
        return sifraPre;
    }

    public void setSifraPre(int sifraPre) {
        this.sifraPre = sifraPre;
    }

    public int getSifraZap() {
        return sifraZap;
    }

    public void setSifraZap(int sifraZap) {
        this.sifraZap = sifraZap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rbr;
        hash += (int) sifraPre;
        hash += (int) sifraZap;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UlogaPK)) {
            return false;
        }
        UlogaPK other = (UlogaPK) object;
        if (this.rbr != other.rbr) {
            return false;
        }
        if (this.sifraPre != other.sifraPre) {
            return false;
        }
        if (this.sifraZap != other.sifraZap) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UlogaPK[ rbr=" + rbr + ", sifraPre=" + sifraPre + ", sifraZap=" + sifraZap + " ]";
    }
    
}
