/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import dao.DAOLiteratura;
import java.util.List;
import model.Autor;
import model.Izdavac;
import model.Literatura;
import servis.LiteraturaServis;

/**
 *
 * @author Nikola
 */
public class LiteraturaServisImpl implements LiteraturaServis {

    DAOLiteratura dao_l;

    public LiteraturaServisImpl(DAOLiteratura dao_l) {
        this.dao_l = dao_l;
    }

    @Override
    public List<Literatura> vratiSveLiterature() throws Exception {
        return dao_l.vratiSveLiterature();
    }

    @Override
    public Literatura vratiLiteraturu(int literaturaID) throws Exception {
        return dao_l.vratiLiteraturu(literaturaID);
    }

    @Override
    public void sacuvajLiteraturu(Literatura l, Izdavac i, List<Autor> listaAutora) throws Exception {
        dao_l.sacuvajLiteraturu(l, i, listaAutora);
    }

    @Override
    public void obrisiLiteraturu(int literaturaID) throws Exception {
        dao_l.obrisiLiteraturu(literaturaID);
    }

    @Override
    public void dodajLiteraturuZaPredmet(String sk, int predmetID, int literaturaID) throws Exception {
        dao_l.dodajLiteraturuZaPredmet(sk, predmetID, literaturaID);
    }

    @Override
    public void izmeniLiteraturu(Literatura l, Izdavac i, List<Autor> listaAutora, int literaturaID) throws Exception {
        dao_l.izmeniLitearturu(l, i, listaAutora, literaturaID);
    }

}
