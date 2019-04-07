/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Izdavac;

/**
 *
 * @author Nikola
 */
public class DAOIzdavacImpl implements dao.DAOIzdavac {

    private EntityManagerFactory emf;

    public DAOIzdavacImpl() {
        emf = Persistence.createEntityManagerFactory("WebDiplomskiPU");
    }

    @Override
    public List<Izdavac> vratiSveIzdavace() throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Izdavac> listaIzdavaca = em.createQuery("SELECT i FROM Izdavac i").getResultList();
        if (listaIzdavaca.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje izdavace");
        }
        em.close();
        return listaIzdavaca;

    }

    @Override
    public void sacuajIzdavaca(Izdavac i) throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Izdavac> listaDb = vratiSveIzdavace();
        for (Izdavac iDB : listaDb) {
            if (iDB.getNazivIzdavaca().equals(i.getNazivIzdavaca())) {
                throw new Exception("Izdavac vec postoji u bazi");
            }
        }
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Izdavac vratiIzdavacaPoID(int izdavacID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Izdavac iDB = em.find(Izdavac.class, izdavacID);
        if (iDB == null) {
            throw new Exception("Sistem ne moze da pronadje izdavaca");
        }

        return iDB;
    }

    @Override
    public int vratiMax() throws Exception {
        EntityManager em = emf.createEntityManager();
        int max = 0;
        max = (int) em.createQuery("SELECT MAX(i.sifraIzdavaca) FROM Izdavac i").getSingleResult();
        if (max == 0) {
            throw new Exception("Sistem ne moze da pronadje maksimalnu vrednost");
        }
        return max;
    }

}
