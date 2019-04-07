/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import dao.DAOZaposleni;
import java.util.List;
import model.Zaposleni;
import model.Zvanje;
import servis.ZaposleniServis;

/**
 *
 * @author Nikola
 */
public class ZaposleniServisImpl implements ZaposleniServis {

    DAOZaposleni dao_z;

    public ZaposleniServisImpl(DAOZaposleni dao_z) {
        this.dao_z = dao_z;
    }

    @Override
    public Zaposleni pronadjiZaposlenog(Zaposleni zaposleni) throws Exception {
        return dao_z.pronadjiZaposlenog(zaposleni);
    }

    @Override
    public List<Zaposleni> vratiSveZaposleneNaKatedri(int katedraId) throws Exception {
        return dao_z.vratiSveZaposleneNaKatedri(katedraId);
    }

    @Override
    public void dodajZaposlenog(Zaposleni zaposleni, int sifraZvanja) throws Exception {
        dao_z.dodajZaposlenog(zaposleni, sifraZvanja);
    }

    @Override
    public void izbrisiZaposlenog(int zaposleniID) throws Exception {
        dao_z.izbrisiZaposlenog(zaposleniID);
    }

    @Override
    public void dodajUlogu(int predmetID, int zaposleniID, String uloga) throws Exception {
        dao_z.dodajUlogu(predmetID, zaposleniID, uloga);
    }

    @Override
    public Zaposleni vratiZaposlenogPoID(int zaposleniID) throws Exception {
        return dao_z.vratiZaposlenogPoID(zaposleniID);
    }

    @Override
    public void izmeniZaposlenog(Zaposleni zap, int sifraZvanja) throws Exception {
        dao_z.izmeniZaposlenog(zap, sifraZvanja);
    }

    @Override
    public List<Zvanje> vratiListuZvanja() throws Exception {
        return dao_z.vratiListuZvanja();
    }

}
