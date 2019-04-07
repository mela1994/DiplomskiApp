/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.add;

import action.AbstractAction;
import constants.Constants;
import dao.DAOAutor;
import dao.DAOIzdavac;
import dao.DAOPredmet;
import dao.impl.DAOAutorImpl;
import dao.impl.DAOIzdavacImpl;
import dao.impl.DAOPredmetImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Autor;
import model.Izdavac;
import model.Predmet;
import model.Zaposleni;
import servis.AutorServis;
import servis.IzdavacServis;
import servis.impl.AutorServisImpl;
import servis.impl.IzdavacServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionAddLiterature extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            DAOAutor daoA = new DAOAutorImpl();
            AutorServis autS = new AutorServisImpl(daoA);
            List<Autor> listaAut = autS.vratiSveAutore();
            DAOIzdavac daoI = new DAOIzdavacImpl();
            IzdavacServis izS = new IzdavacServisImpl(daoI);
            List<Izdavac> listaIzd = izS.vratiSveIzdavace();
            request.setAttribute("listaI", listaIzd);
            request.setAttribute("listaA", listaAut);

            return Constants.ADD_LITERATURE;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ADD_LITERATURE;
        }
    }

}
