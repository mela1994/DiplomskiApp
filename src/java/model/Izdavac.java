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
@Table(name = "izdavac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Izdavac.findAll", query = "SELECT i FROM Izdavac i")
    , @NamedQuery(name = "Izdavac.findBySifraIzdavaca", query = "SELECT i FROM Izdavac i WHERE i.sifraIzdavaca = :sifraIzdavaca")
    , @NamedQuery(name = "Izdavac.findByNazivIzdavaca", query = "SELECT i FROM Izdavac i WHERE i.nazivIzdavaca = :nazivIzdavaca")})
public class Izdavac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraIzdavaca")
    private Integer sifraIzdavaca;
    @Size(max = 200)
    @Column(name = "nazivIzdavaca")
    private String nazivIzdavaca;
    @OneToMany(mappedBy = "sifraIzdavaca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Literatura> literaturaList;

    public Izdavac() {
        literaturaList = new ArrayList<>();
    }

    public Izdavac(Integer sifraIzdavaca) {
        this.sifraIzdavaca = sifraIzdavaca;
    }

    public Integer getSifraIzdavaca() {
        return sifraIzdavaca;
    }

    public void setSifraIzdavaca(Integer sifraIzdavaca) {
        this.sifraIzdavaca = sifraIzdavaca;
    }

    public String getNazivIzdavaca() {
        return nazivIzdavaca;
    }

    public void setNazivIzdavaca(String nazivIzdavaca) {
        this.nazivIzdavaca = nazivIzdavaca;
    }

    @XmlTransient
    public List<Literatura> getLiteraturaList() {
        return literaturaList;
    }

    public void setLiteraturaList(List<Literatura> literaturaList) {
        this.literaturaList = literaturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraIzdavaca != null ? sifraIzdavaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Izdavac)) {
            return false;
        }
        Izdavac other = (Izdavac) object;
        if ((this.sifraIzdavaca == null && other.sifraIzdavaca != null) || (this.sifraIzdavaca != null && !this.sifraIzdavaca.equals(other.sifraIzdavaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  getNazivIzdavaca();
    }

}
