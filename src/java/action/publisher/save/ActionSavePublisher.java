/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.publisher.save;

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
public class ActionSavePublisher extends AbstractAction {
    
    @Override
    public String execute(HttpServletRequest request) {
        String nazivIzdavaca = request.getParameter("naziv_izdavaca");
        DAOIzdavac daoI = new DAOIzdavacImpl();
        IzdavacServis izS = new IzdavacServisImpl(daoI);
        DAOAutor daoA = new DAOAutorImpl();
        AutorServis auS = new AutorServisImpl(daoA);
        int max = 0;
        Izdavac iz = new Izdavac();
        iz.setNazivIzdavaca(nazivIzdavaca);
        try {
            max = izS.vratiMax();
            iz.setSifraIzdavaca(max + 1);
            izS.sacuvajIzdavaca(iz);
            List<Izdavac> listaDB = izS.vratiSveIzdavace();
            List<Autor> listaAutoraDb = auS.vratiSveAutore();
            request.setAttribute("listaI", listaDB);
            request.setAttribute("listaA", listaAutoraDb);
            return Constants.ADD_LITERATURE;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ADD_PUBLISHER;
        }
        
    }
}
