/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DAOKatedra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Katedra;

/**
 *
 * @author Nikola
 */
public class DAOKatedraImpl implements DAOKatedra {

    private EntityManagerFactory emf;

    public DAOKatedraImpl() {
        emf = Persistence.createEntityManagerFactory("WebDiplomskiPU");
    }

    @Override
    public List<Katedra> vratiSveKatedre() throws Exception {
        List<Katedra> listaKatedri = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        listaKatedri = em.createQuery("SELECT k FROM Katedra k").getResultList();
        if (listaKatedri.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje katedre");
        }
        em.close();
        return listaKatedri;
    }

    @Override
    public Katedra vratiKatedru(int katedraID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Katedra k = em.find(Katedra.class, katedraID);
        if (k == null) {
            throw new Exception("Sistem ne moze da pronadje katedru");
        }
        return k;
    }
}
