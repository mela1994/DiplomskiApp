/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import dao.DAOKatedra;
import java.util.List;
import model.Katedra;
import servis.KatedraServis;

/**
 *
 * @author Nikola
 */
public class KatedraServisImpl implements KatedraServis {

    DAOKatedra dao_k;

    public KatedraServisImpl(DAOKatedra dao_k) {
        this.dao_k = dao_k;
    }

    @Override
    public Katedra vratiKatedru(int katedraID) throws Exception {
        return dao_k.vratiKatedru(katedraID);
    }

    @Override
    public List<Katedra> vratiSveKatedre() throws Exception {
        return dao_k.vratiSveKatedre();
    }

}
