/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DAOLiteratura;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Autor;
import model.Autorliteratura;
import model.AutorliteraturaPK;
import model.Izdavac;
import model.Literatura;
import model.Predmet;
import model.Skolskagodina;
import model.SkolskagodinaPK;

/**
 *
 * @author Nikola
 */
public class DAOLiteraturaImpl implements DAOLiteratura {

    private EntityManagerFactory emf;

    public DAOLiteraturaImpl() {
        emf = Persistence.createEntityManagerFactory("WebDiplomskiPU");
    }

    @Override
    public Literatura vratiLiteraturu(int literaturaID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Literatura litDB = em.find(Literatura.class, literaturaID);

        em.close();

        if (litDB == null) {
            throw new Exception("Sistem ne moze da pronadje literaturu po zadatom kriterijumu");
        } else {
            return litDB;
        }
    }

    @Override
    public void sacuvajLiteraturu(Literatura l, Izdavac i, List<Autor> listaAutoraForma) throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Literatura> listaLitDB = em.createQuery("SELECT l FROM Literatura l").getResultList();
        for (Literatura lDB : listaLitDB) {
            if (lDB.getNazivKnjige().equals(l.getNazivKnjige()) && lDB.getIzdanje().equals(l.getIzdanje())) {
                throw new Exception("Sistem ne moze da zapamti novu literaturu");
            }
        }
        em.getTransaction().begin();
        em.persist(l);
        l.setSifraIzdavaca(i);
        em.getTransaction().commit();
        em.close();
        updateAutorLiteratura(l, listaAutoraForma);

    }

    @Override
    public void izmeniLitearturu(Literatura l, Izdavac i, List<Autor> listaAutoraStari, int literaturaID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Literatura lDB = em.find(Literatura.class, literaturaID);
        l.setSifraIzdavaca(i);
        l.setSkolskagodinaList(lDB.getSkolskagodinaList());

        List<Autorliteratura> lista = new ArrayList<>();
        for (Autor autor : listaAutoraStari) {
            Autorliteratura al = new Autorliteratura(1, l.getSifraKnjige(), autor.getSifraAutora());
            al.setAutor(autor);
            al.setLiteratura(l);
            lista.add(al);
        }
        l.setAutorliteraturaList(lista);

        em.getTransaction().begin();
        lDB = em.merge(l);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Literatura> vratiSveLiterature() throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Literatura> listaLiteratura = em.createQuery("SELECT sk FROM Literatura sk").getResultList();
        em.close();
        if (listaLiteratura.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje literature");
        }

        return listaLiteratura;

    }

    private void updateAutorLiteratura(Literatura l, List<Autor> listaAutoraForma) throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Literatura> listaLiteraturaDB = new ArrayList<>();
        listaLiteraturaDB = em.createQuery("SELECT l FROM Literatura l WHERE l.nazivKnjige=:nazivLit AND l.izdanje=:izdanje").setParameter("nazivLit", l.getNazivKnjige()).setParameter("izdanje", l.getIzdanje()).getResultList();
        if (listaLiteraturaDB.isEmpty()) {
            throw new Exception("Serverska greskaka");
        }
        Literatura litDb = listaLiteraturaDB.get(0);
        int rbr = 1;
        List<Autorliteratura> listaAutorLiteratura = new ArrayList<>();

        for (Autor a : listaAutoraForma) {
            Autorliteratura al = new Autorliteratura(rbr, litDb.getSifraKnjige(), a.getSifraAutora());
            al.setAutor(a);
            al.setLiteratura(litDb);
            listaAutorLiteratura.add(al);
            rbr++;
        }
        em.getTransaction().begin();
        for (Autorliteratura autorliteratura : listaAutorLiteratura) {
            em.persist(autorliteratura);
        }
        litDb.setAutorliteraturaList(listaAutorLiteratura);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void obrisiLiteraturu(int literaturaID) throws Exception {
        EntityManager em = emf.createEntityManager();
        Literatura lDB = em.find(Literatura.class, literaturaID);
        if (lDB == null) {
            throw new Exception("Sistem ne moze da pronadje literaturu");
        }
        em.getTransaction().begin();
        em.remove(lDB);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void dodajLiteraturuZaPredmet(String sk, int predmetID, int literaturaId) throws Exception {
        EntityManager em = emf.createEntityManager();
        Predmet pDB = em.find(Predmet.class, predmetID);
        Literatura lDB = em.find(Literatura.class, literaturaId);

        SkolskagodinaPK skPk = new SkolskagodinaPK();
        skPk.setSifraKnjige(lDB.getSifraKnjige());
        skPk.setSifraPredmeta(pDB.getSifraPredmeta());
        Skolskagodina skolskagodina = new Skolskagodina();
        skolskagodina.setSkolskagodinaPK(skPk);
        skolskagodina.setLiteratura(lDB);
        skolskagodina.setPredmet(pDB);
        skolskagodina.setSkolskaGodina(sk);

        em.getTransaction().begin();
        em.persist(skolskagodina);
        lDB.getSkolskagodinaList().add(skolskagodina);
        pDB.getSkolskagodinaList().add(skolskagodina);
        em.getTransaction().commit();
        em.close();
    }

  

}
