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
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
    , @NamedQuery(name = "Autor.findBySifraAutora", query = "SELECT a FROM Autor a WHERE a.sifraAutora = :sifraAutora")
    , @NamedQuery(name = "Autor.findByImeAutora", query = "SELECT a FROM Autor a WHERE a.imeAutora = :imeAutora")
    , @NamedQuery(name = "Autor.findByPrezimeAutora", query = "SELECT a FROM Autor a WHERE a.prezimeAutora = :prezimeAutora")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraAutora")
    private Integer sifraAutora;
    @Size(max = 200)
    @Column(name = "imeAutora")
    private String imeAutora;
    @Size(max = 200)
    @Column(name = "prezimeAutora")
    private String prezimeAutora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private List<Autorliteratura> autorliteraturaList;

    public Autor() {
    }

    public Autor(Integer sifraAutora) {
        this.sifraAutora = sifraAutora;
    }

    public Integer getSifraAutora() {
        return sifraAutora;
    }

    public void setSifraAutora(Integer sifraAutora) {
        this.sifraAutora = sifraAutora;
    }

    public String getImeAutora() {
        return imeAutora;
    }

    public void setImeAutora(String imeAutora) {
        this.imeAutora = imeAutora;
    }

    public String getPrezimeAutora() {
        return prezimeAutora;
    }

    public void setPrezimeAutora(String prezimeAutora) {
        this.prezimeAutora = prezimeAutora;
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
        hash += (sifraAutora != null ? sifraAutora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.sifraAutora == null && other.sifraAutora != null) || (this.sifraAutora != null && !this.sifraAutora.equals(other.sifraAutora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getImeAutora() + " " + getPrezimeAutora();
    }

}
