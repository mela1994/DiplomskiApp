/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DAOZaposleni;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Predmet;
import model.Uloga;
import model.UlogaPK;
import model.Zaposleni;
import model.Zvanje;

/**
 *
 * @author Nikola
 */
public class DAOZaposleniImpl implements DAOZaposleni {

    private EntityManagerFactory emf;

    public DAOZaposleniImpl() {
        emf = Persistence.createEntityManagerFactory("WebDiplomskiPU");
    }

    @Override
    public Zaposleni pronadjiZaposlenog(Zaposleni zaposleni) throws Exception {
        Zaposleni zap = null;
        EntityManager em = emf.createEntityManager();
        List<Zaposleni> listaZaposlenih = em.createQuery("SELECT z FROM Zaposleni z WHERE z.korisnickoIme =:korisnickoIme").setParameter("korisnickoIme", zaposleni.getKorisnickoIme()).getResultList();

        em.close();

        if (listaZaposlenih.size() == 0) {
            throw new Exception("Ne postoji nalog sa datim podacima u sistemu");
        }
        zap = listaZaposlenih.get(0);
        if (!zap.getKorisnickaSifra().equals(zaposleni.getKorisnickaSifra())) {
            throw new Exception("Uneta lozinka nije tacna");
        } else {
            return zap;
        }

    }

    @Override
    public List<Zaposleni> vratiSveZaposleneNaKatedri(int katedraID) throws Exception {
        List<Zaposleni> listaZaposlenih = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        listaZaposlenih = em.createQuery("SELECT z FROM Zaposleni z WHERE z.sifraKatedre.sifraKatedre=:katedraID").setParameter("katedraID", katedraID).getResultList();

        em.close();

        if (listaZaposlenih.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje zaposlene po datom kriterijumu");
        }
        return listaZaposlenih;
    }

    @Override
    public void dodajZaposlenog(Zaposleni zaposleni, int sifraZvanja) throws Exception {
        EntityManager em = emf.createEntityManager();
        Zvanje zvanje = em.find(Zvanje.class, sifraZvanja);
        List<Zaposleni> listaZaposlenih = em.createQuery("SELECT z FROM Zaposleni z").getResultList();
        for (Zaposleni z : listaZaposlenih) {
            if (z.getKorisnickoIme().equals(zaposleni.getKorisnickoIme()) && z.getKorisnickaSifra().equals(zaposleni.getKorisnickaSifra())) {
                throw new Exception("Sistem ne moze da zapamti novog nastavnika");
            }
        }
        zaposleni.setSifraZvanja(zvanje);
        em.getTransaction().begin();
        em.persist(zaposleni);
        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void izbrisiZaposlenog(int zaposleniID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Zaposleni zapDb = em.find(Zaposleni.class, zaposleniID);
        if (zapDb != null) {
            em.getTransaction().begin();
            em.remove(zapDb);
            em.getTransaction().commit();

            em.close();

        } else {
            throw new Exception("Neuspesno brisanje zaposlenog");
        }
    }

    @Override
    public void dodajUlogu(int predmetID, int zaposleniID, String uloga) throws Exception {
        EntityManager em = emf.createEntityManager();
        Zaposleni zap = em.find(Zaposleni.class, zaposleniID);
        Predmet pr = em.find(Predmet.class, predmetID);
        List<Uloga> lista = em.createQuery("SELECT u FROM Uloga u WHERE u.predmet.sifraPredmeta =:predmetID AND u.nazivUloge=:uloga AND u.zaposleni.sifraZaposlenog =:zaposleniID").setParameter("predmetID", pr.getSifraPredmeta()).setParameter("zaposleniID", zap.getSifraZaposlenog()).setParameter("uloga", uloga).getResultList();
        UlogaPK uk = new UlogaPK();
        uk.setSifraPre(pr.getSifraPredmeta());
        uk.setSifraZap(zap.getSifraZaposlenog());

        Uloga u = new Uloga(uk);
        u.setNazivUloge(uloga);
        u.setZaposleni(zap);
        u.setPredmet(pr);

        if (!lista.isEmpty()) {
            Uloga udb = lista.get(0);
            if (u.getZaposleni().getSifraZaposlenog().equals(udb.getZaposleni().getSifraZaposlenog()) && u.getPredmet().getSifraPredmeta().equals(udb.getPredmet().getSifraPredmeta()) && u.getNazivUloge().equals(udb.getNazivUloge())) {
                throw new Exception("Sistem ne moze da zapamti ulogu");
            }
        }

        em.getTransaction().begin();

        em.persist(u);

        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Zaposleni vratiZaposlenogPoID(int zaposleniID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Zaposleni zap = em.find(Zaposleni.class, zaposleniID);
        if (zap == null) {
            throw new Exception("Sistem ne moze da pronadje zaposlenog");
        }
        em.close();
        return zap;
    }

    @Override
    public void izmeniZaposlenog(Zaposleni zap, int sifraZvanja) throws Exception {
        EntityManager em = emf.createEntityManager();
        Zvanje zvanje = em.find(Zvanje.class, sifraZvanja);
        Zaposleni zapDB = em.find(Zaposleni.class, zap.getSifraZaposlenog());
        zap.setSifraZvanja(zvanje);
        if (zapDB == null) {
            throw new Exception("Sistem ne moze da pronadje zaposlenog");
        }
        em.getTransaction().begin();
        zapDB = em.merge(zap);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public List<Zvanje> vratiListuZvanja() throws Exception {
        List<Zvanje> listaZvanja = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        listaZvanja = em.createQuery("SELECT z FROM Zvanje z").getResultList();
        if (listaZvanja.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje zvanja");
        }
        em.close();
        return listaZvanja;

    }

}
