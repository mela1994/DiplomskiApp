/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import dao.DAOPredmet;
import java.util.List;
import java.util.Set;
import model.Predmet;
import model.Uloga;
import model.Zaposleni;
import servis.PredmetServis;

/**
 *
 * @author Nikola
 */
public class PredmetServisImpl implements PredmetServis {

    DAOPredmet dao_p;

    public PredmetServisImpl(DAOPredmet dao_p) {
        this.dao_p = dao_p;
    }

    @Override
    public List<Predmet> vratiSvePremete(int katedraID) throws Exception {
        return dao_p.vratiSvePredmete(katedraID);
    }

    @Override
    public Predmet vratiPredmet(int predmetID) throws Exception {
        return dao_p.vratiPredmet(predmetID);
    }

    @Override
    public void obrisiUloguZaposlenogNaPredmetu(int predmetId, int zaposleniID, int rbr) throws Exception {
        dao_p.obrisiUloguZaposlenogNaPredmetu(predmetId, zaposleniID, rbr);
    }

    @Override
    public List<Uloga> vratiListuUloga(int predmetID, int zaposleniID) throws Exception {
        return dao_p.vratiListuUloga(predmetID, zaposleniID);
    }

    @Override
    public Set<Zaposleni> vratiListuUloga(int predmetID) {
        return dao_p.vratiListuUloga(predmetID);
    }

}
