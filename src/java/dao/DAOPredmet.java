/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Set;
import model.Predmet;
import model.Uloga;
import model.Zaposleni;

/**
 *
 * @author Nikola
 */
public interface DAOPredmet {

    public List<Predmet> vratiSvePredmete(int katedraID) throws Exception;

    public Predmet vratiPredmet(int predmetID) throws Exception;

    public void obrisiUloguZaposlenogNaPredmetu(int predmetiID, int zaposleniID, int rbr) throws Exception;

    public List<Uloga> vratiListuUloga(int predmetID, int zaposleniID) throws Exception;

    public Set<Zaposleni> vratiListuUloga(int predmetID);
}
