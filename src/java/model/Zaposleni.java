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
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z")
    , @NamedQuery(name = "Zaposleni.findBySifraZaposlenog", query = "SELECT z FROM Zaposleni z WHERE z.sifraZaposlenog = :sifraZaposlenog")
    , @NamedQuery(name = "Zaposleni.findByIme", query = "SELECT z FROM Zaposleni z WHERE z.ime = :ime")
    , @NamedQuery(name = "Zaposleni.findByPrezime", query = "SELECT z FROM Zaposleni z WHERE z.prezime = :prezime")
    , @NamedQuery(name = "Zaposleni.findByKontaktTelefon", query = "SELECT z FROM Zaposleni z WHERE z.kontaktTelefon = :kontaktTelefon")
    , @NamedQuery(name = "Zaposleni.findByBrojKabineta", query = "SELECT z FROM Zaposleni z WHERE z.brojKabineta = :brojKabineta")
    , @NamedQuery(name = "Zaposleni.findByEmail", query = "SELECT z FROM Zaposleni z WHERE z.email = :email")
    , @NamedQuery(name = "Zaposleni.findByKorisnickoIme", query = "SELECT z FROM Zaposleni z WHERE z.korisnickoIme = :korisnickoIme")
    , @NamedQuery(name = "Zaposleni.findByKorisnickaSifra", query = "SELECT z FROM Zaposleni z WHERE z.korisnickaSifra = :korisnickaSifra")})
public class Zaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraZaposlenog")
    private Integer sifraZaposlenog;
    @Size(max = 200)
    @Column(name = "ime")
    private String ime;
    @Size(max = 200)
    @Column(name = "prezime")
    private String prezime;
    @Size(max = 200)
    @Column(name = "kontaktTelefon")
    private String kontaktTelefon;
    @Size(max = 200)
    @Column(name = "brojKabineta")
    private String brojKabineta;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "email")
    private String email;
    @Size(max = 200)
    @Column(name = "korisnickoIme")
    private String korisnickoIme;
    @Size(max = 200)
    @Column(name = "korisnickaSifra")
    private String korisnickaSifra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleni")
    private List<Uloga> ulogaList;
    @JoinColumn(name = "sifraKatedre", referencedColumnName = "sifraKatedre")
    @ManyToOne
    private Katedra sifraKatedre;
    @JoinColumn(name = "sifraZvanja", referencedColumnName = "sifraZvanja")
    @ManyToOne
    private Zvanje sifraZvanja;

    public Zaposleni() {
    }

    public Zaposleni(Integer sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public Integer getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(Integer sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getBrojKabineta() {
        return brojKabineta;
    }

    public void setBrojKabineta(String brojKabineta) {
        this.brojKabineta = brojKabineta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    @XmlTransient
    public List<Uloga> getUlogaList() {
        return ulogaList;
    }

    public void setUlogaList(List<Uloga> ulogaList) {
        this.ulogaList = ulogaList;
    }

    public Katedra getSifraKatedre() {
        return sifraKatedre;
    }

    public void setSifraKatedre(Katedra sifraKatedre) {
        this.sifraKatedre = sifraKatedre;
    }

    public Zvanje getSifraZvanja() {
        return sifraZvanja;
    }

    public void setSifraZvanja(Zvanje sifraZvanja) {
        this.sifraZvanja = sifraZvanja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraZaposlenog != null ? sifraZaposlenog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.sifraZaposlenog == null && other.sifraZaposlenog != null) || (this.sifraZaposlenog != null && !this.sifraZaposlenog.equals(other.sifraZaposlenog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIme()+" "+getPrezime();
    }
    
}
