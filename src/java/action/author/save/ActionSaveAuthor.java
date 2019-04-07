/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author.save;

import action.AbstractAction;
import constants.Constants;
import dao.DAOAutor;
import dao.DAOIzdavac;
import dao.impl.DAOAutorImpl;
import dao.impl.DAOIzdavacImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Autor;
import model.Izdavac;
import servis.AutorServis;
import servis.IzdavacServis;
import servis.impl.AutorServisImpl;
import servis.impl.IzdavacServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionSaveAuthor extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String imeAutora = request.getParameter("ime_autora");
        String prezimeAutora = request.getParameter("prezime_autora");
        Autor a = new Autor();
        a.setImeAutora(imeAutora);
        a.setPrezimeAutora(prezimeAutora);

        DAOAutor daoA = new DAOAutorImpl();
        DAOIzdavac daoI = new DAOIzdavacImpl();
        AutorServis auS = new AutorServisImpl(daoA);
        IzdavacServis izS = new IzdavacServisImpl(daoI);

        try {
            auS.sacuvajAutora(a);
            List<Autor> listaAutoraS = auS.vratiSveAutore();
            List<Izdavac> listaIzdavacaS = izS.vratiSveIzdavace();
            
            daoA.sacuvajAutora(a);
//            List<Autor> listaAutora = daoA.vratiSveAutore();
//            List<Izdavac> listaIzdavaca = daoI.vratiSveIzdavace();
            request.setAttribute("listaA", listaAutoraS);
            request.setAttribute("listaI", listaIzdavacaS);
            request.setAttribute("successMessage", "Sistem je zapamtio autora");
            return Constants.ADD_LITERATURE;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ADD_AUTHOR;
        }

    }

}
