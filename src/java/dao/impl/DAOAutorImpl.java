/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DAOAutor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Autor;

/**
 *
 * @author Nikola
 */
public class DAOAutorImpl implements DAOAutor {

    private EntityManagerFactory emf;

    public DAOAutorImpl() {
        emf = Persistence.createEntityManagerFactory("WebDiplomskiPU");
    }

    @Override
    public List<Autor> vratiSveAutore() throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Autor> listaAutora = em.createQuery("SELECT a FROM Autor a").getResultList();
        if (listaAutora.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje autore");
        }
        return listaAutora;
    }

    @Override
    public void sacuvajAutora(Autor a) throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Autor> listaAutoraDB = em.createQuery("SELECT a FROM Autor a ").getResultList();
        for (Autor aDB : listaAutoraDB) {
            if (aDB.getImeAutora().equals(a.getImeAutora()) && aDB.getPrezimeAutora().equals(a.getPrezimeAutora())) {
                throw new Exception("Autor vec postoji u bazi");
            }
        }
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Autor> vratiListuAutoraPoID(int[] autorIDovi) throws Exception {
        List<Autor> listaAutoraDb = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        for (int i = 0; i < autorIDovi.length; i++) {
            Autor a = em.find(Autor.class, autorIDovi[i]);
            listaAutoraDb.add(a);
        }
        if (listaAutoraDb.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje autore");
        }
        em.close();
        return listaAutoraDb;

    }
}
