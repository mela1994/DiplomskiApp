/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DAOPredmet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Predmet;
import model.Skolskagodina;
import model.Uloga;
import model.UlogaPK;
import model.Zaposleni;

/**
 *
 * @author Nikola
 */
public class DAOPredmetImpl implements DAOPredmet {

    private EntityManagerFactory emf;

    public DAOPredmetImpl() {
        emf = Persistence.createEntityManagerFactory("WebDiplomskiPU");
    }

    @Override
    public List<Predmet> vratiSvePredmete(int katedraID) throws Exception {
        List<Predmet> listaPredmeta = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        listaPredmeta = em.createQuery("SELECT p FROM Predmet p WHERE p.sifraKatedre.sifraKatedre=:katedraID").setParameter("katedraID", katedraID).getResultList();

        em.close();

        if (listaPredmeta == null) {
            throw new Exception("Sistem ne moze da pronadje predmete po zadatom kriterijumu");
        }

        return listaPredmeta;

    }

    @Override
    public Predmet vratiPredmet(int predmetID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Predmet p = em.find(Predmet.class, predmetID);

        em.close();

        if (p != null) {
            return p;

        } else {
            throw new Exception("Sistem nije pronasao predmet po zadatom kriterijumu");
        }

    }

    @Override
    public void obrisiUloguZaposlenogNaPredmetu(int predmetiID, int zaposleniID, int rbr) throws Exception {
        Uloga u = new Uloga(new UlogaPK(rbr, predmetiID, zaposleniID));

        EntityManager em = emf.createEntityManager();
        Zaposleni zap = em.find(Zaposleni.class, zaposleniID);
        Predmet pr = em.find(Predmet.class, predmetiID);
//        zap.getUlogaList().remove(u);
//        pr.getUlogaList().remove(u);
        List<Uloga> lista = em.createNamedQuery("Uloga.findAll").getResultList();
        for (Uloga uDb : lista) {
            if (u.equals(uDb)) {
                em.getTransaction().begin();
                em.remove(uDb);
//                zap.getUlogaList().remove(u);
//                pr.getUlogaList().remove(u);
                em.getTransaction().commit();

                em.close();

            }
        }

    }

    @Override
    public List<Uloga> vratiListuUloga(int predmetID, int zaposleniID) throws Exception {
        List<Uloga> listaUloga = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        listaUloga = em.createQuery("SELECT u FROM Uloga u WHERE u.predmet.sifraPredmeta =:predmetID AND u.zaposleni.sifraZaposlenog =:zaposleniID ").setParameter("predmetID", predmetID).setParameter("zaposleniID", zaposleniID).getResultList();

        em.close();

        return listaUloga;

    }

    @Override
    public Set<Zaposleni> vratiListuUloga(int predmetID) {
        List<Uloga> listaUloga = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        listaUloga = em.createQuery("SELECT u FROM Uloga u WHERE u.predmet.sifraPredmeta =:predmetID").setParameter("predmetID", predmetID).getResultList();
        Set<Zaposleni> zaposleni = new HashSet<>();
        for (Uloga uloga : listaUloga) {
            zaposleni.add(uloga.getZaposleni());
        }
        em.close();

        return zaposleni;
    }
}
