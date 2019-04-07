/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import dao.DAOAutor;
import java.util.List;
import model.Autor;
import servis.AutorServis;

/**
 *
 * @author Nikola
 */
public class AutorServisImpl implements AutorServis {

    DAOAutor dao_a;

    public AutorServisImpl(DAOAutor dao_a) {
        this.dao_a = dao_a;
    }

    @Override
    public List<Autor> vratiSveAutore() throws Exception {
        return dao_a.vratiSveAutore();
    }
    @Override
    public void sacuvajAutora(Autor a) throws Exception {
        dao_a.sacuvajAutora(a);
    }

    @Override
    public List<Autor> vratiListuAutoraPoID(int[] autorIDovi) throws Exception {
        return dao_a.vratiListuAutoraPoID(autorIDovi);
    }

}
