/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nikola
 */
@Entity
@Table(name = "autorliteratura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorliteratura.findAll", query = "SELECT a FROM Autorliteratura a")
    , @NamedQuery(name = "Autorliteratura.findByRbr", query = "SELECT a FROM Autorliteratura a WHERE a.autorliteraturaPK.rbr = :rbr")
    , @NamedQuery(name = "Autorliteratura.findBySifraKnjige", query = "SELECT a FROM Autorliteratura a WHERE a.autorliteraturaPK.sifraKnjige = :sifraKnjige")
    , @NamedQuery(name = "Autorliteratura.findBySifraAutora", query = "SELECT a FROM Autorliteratura a WHERE a.autorliteraturaPK.sifraAutora = :sifraAutora")})
public class Autorliteratura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutorliteraturaPK autorliteraturaPK;
    @JoinColumn(name = "sifraAutora", referencedColumnName = "sifraAutora", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autor autor;
    @JoinColumn(name = "sifraKnjige", referencedColumnName = "sifraKnjige", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Literatura literatura;

    public Autorliteratura() {
    }

    public Autorliteratura(AutorliteraturaPK autorliteraturaPK) {
        this.autorliteraturaPK = autorliteraturaPK;
    }

    public Autorliteratura(int rbr, int sifraKnjige, int sifraAutora) {
        this.autorliteraturaPK = new AutorliteraturaPK(rbr, sifraKnjige, sifraAutora);
    }

    public AutorliteraturaPK getAutorliteraturaPK() {
        return autorliteraturaPK;
    }

    public void setAutorliteraturaPK(AutorliteraturaPK autorliteraturaPK) {
        this.autorliteraturaPK = autorliteraturaPK;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Literatura getLiteratura() {
        return literatura;
    }

    public void setLiteratura(Literatura literatura) {
        this.literatura = literatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autorliteraturaPK != null ? autorliteraturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorliteratura)) {
            return false;
        }
        Autorliteratura other = (Autorliteratura) object;
        if ((this.autorliteraturaPK == null && other.autorliteraturaPK != null) || (this.autorliteraturaPK != null && !this.autorliteraturaPK.equals(other.autorliteraturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Autorliteratura[ autorliteraturaPK=" + autorliteraturaPK + " ]";
    }
    
}
