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
public class AutorliteraturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rbr")
    private int rbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraKnjige")
    private int sifraKnjige;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraAutora")
    private int sifraAutora;

    public AutorliteraturaPK() {
    }

    public AutorliteraturaPK(int rbr, int sifraKnjige, int sifraAutora) {
        this.rbr = rbr;
        this.sifraKnjige = sifraKnjige;
        this.sifraAutora = sifraAutora;
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

    public int getSifraAutora() {
        return sifraAutora;
    }

    public void setSifraAutora(int sifraAutora) {
        this.sifraAutora = sifraAutora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rbr;
        hash += (int) sifraKnjige;
        hash += (int) sifraAutora;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorliteraturaPK)) {
            return false;
        }
        AutorliteraturaPK other = (AutorliteraturaPK) object;
        if (this.rbr != other.rbr) {
            return false;
        }
        if (this.sifraKnjige != other.sifraKnjige) {
            return false;
        }
        if (this.sifraAutora != other.sifraAutora) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AutorliteraturaPK[ rbr=" + rbr + ", sifraKnjige=" + sifraKnjige + ", sifraAutora=" + sifraAutora + " ]";
    }
    
}
