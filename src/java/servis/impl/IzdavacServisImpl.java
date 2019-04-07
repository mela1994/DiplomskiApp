/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import dao.DAOIzdavac;
import java.util.List;
import model.Izdavac;
import servis.IzdavacServis;

/**
 *
 * @author Nikola
 */
public class IzdavacServisImpl implements IzdavacServis {

    DAOIzdavac dao_i;

    public IzdavacServisImpl(DAOIzdavac dao_i) {
        this.dao_i = dao_i;
    }

    @Override
    public List<Izdavac> vratiSveIzdavace() throws Exception {
        return dao_i.vratiSveIzdavace();
    }

    @Override
    public Izdavac vratiIzdavacaPoID(int izdavacID) throws Exception {
        return dao_i.vratiIzdavacaPoID(izdavacID);
    }

    @Override
    public void sacuvajIzdavaca(Izdavac i) throws Exception {
        dao_i.sacuajIzdavaca(i);
    }

    @Override
    public int vratiMax() throws Exception {
        return dao_i.vratiMax();
    }

}
