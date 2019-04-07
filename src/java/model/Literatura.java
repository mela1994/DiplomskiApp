/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "literatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Literatura.findAll", query = "SELECT l FROM Literatura l")
    , @NamedQuery(name = "Literatura.findBySifraKnjige", query = "SELECT l FROM Literatura l WHERE l.sifraKnjige = :sifraKnjige")
    , @NamedQuery(name = "Literatura.findByNazivKnjige", query = "SELECT l FROM Literatura l WHERE l.nazivKnjige = :nazivKnjige")
    , @NamedQuery(name = "Literatura.findByIzdanje", query = "SELECT l FROM Literatura l WHERE l.izdanje = :izdanje")})
public class Literatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraKnjige")
    private Integer sifraKnjige;
    @Size(max = 200)
    @Column(name = "nazivKnjige")
    private String nazivKnjige;
    @Size(max = 200)
    @Column(name = "izdanje")
    private String izdanje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "literatura")
    private List<Skolskagodina> skolskagodinaList;
    @JoinColumn(name = "sifraIzdavaca", referencedColumnName = "sifraIzdavaca")
    @ManyToOne()
    private Izdavac sifraIzdavaca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "literatura")
    private List<Autorliteratura> autorliteraturaList;

    public Literatura() {
        skolskagodinaList = new ArrayList<>();
        autorliteraturaList = new ArrayList<>();
    }

    public Literatura(Integer sifraKnjige) {
        this.sifraKnjige = sifraKnjige;
    }

    public Integer getSifraKnjige() {
        return sifraKnjige;
    }

    public void setSifraKnjige(Integer sifraKnjige) {
        this.sifraKnjige = sifraKnjige;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getIzdanje() {
        return izdanje;
    }

    public void setIzdanje(String izdanje) {
        this.izdanje = izdanje;
    }

    @XmlTransient
    public List<Skolskagodina> getSkolskagodinaList() {
        return skolskagodinaList;
    }

    public void setSkolskagodinaList(List<Skolskagodina> skolskagodinaList) {
        this.skolskagodinaList = skolskagodinaList;
    }

    public Izdavac getSifraIzdavaca() {
        return sifraIzdavaca;
    }

    public void setSifraIzdavaca(Izdavac sifraIzdavaca) {
        this.sifraIzdavaca = sifraIzdavaca;
    }

    @XmlTransient
    public List<Autorliteratura> getAutorliteraturaList() {
        return autorliteraturaList;
    }

    public void setAutorliteraturaList(List<Autorliteratura> autorliteraturaList) {
        this.autorliteraturaList = autorliteraturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraKnjige != null ? sifraKnjige.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Literatura)) {
            return false;
        }
        Literatura other = (Literatura) object;
        if ((this.sifraKnjige == null && other.sifraKnjige != null) || (this.sifraKnjige != null && !this.sifraKnjige.equals(other.sifraKnjige))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Literatura[ sifraKnjige=" + sifraKnjige + " ]";
    }
    
}
