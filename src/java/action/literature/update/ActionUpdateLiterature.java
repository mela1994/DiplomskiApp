/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.update;

import action.AbstractAction;
import constants.Constants;
import dao.DAOAutor;
import dao.DAOIzdavac;
import dao.DAOLiteratura;
import dao.impl.DAOAutorImpl;
import dao.impl.DAOIzdavacImpl;
import dao.impl.DAOLiteraturaImpl;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Autor;
import model.Autorliteratura;
import model.Izdavac;
import model.Literatura;
import servis.AutorServis;
import servis.IzdavacServis;
import servis.LiteraturaServis;
import servis.impl.AutorServisImpl;
import servis.impl.IzdavacServisImpl;
import servis.impl.LiteraturaServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionUpdateLiterature extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            int literatureID = Integer.parseInt(request.getParameter("literatureID"));
            DAOAutor daoA = new DAOAutorImpl();
            AutorServis auS = new AutorServisImpl(daoA);
            List<Autor> listaAut = auS.vratiSveAutore();
            DAOIzdavac daoI = new DAOIzdavacImpl();
            IzdavacServis izS = new IzdavacServisImpl(daoI);
            List<Izdavac> listaIzd = izS.vratiSveIzdavace();

            List<Izdavac> listIzdPomocna = new ArrayList<>();
            List<Autor> listaAutoraPomocna = new ArrayList<>();
            DAOLiteratura daoL = new DAOLiteraturaImpl();
            LiteraturaServis litS = new LiteraturaServisImpl(daoL);
            Literatura litDb = litS.vratiLiteraturu(literatureID);
            Izdavac izD = litDb.getSifraIzdavaca();
            List<Autorliteratura> listaAutoraLitDb = litDb.getAutorliteraturaList();

            for (Izdavac izdavac : listaIzd) {
                if (!izdavac.getNazivIzdavaca().equals(izD.getNazivIzdavaca())) {
                    listIzdPomocna.add(izdavac);
                }
            }
            for (Autorliteratura auLit : listaAutoraLitDb) {
                for (Autor au : listaAut) {
                    if (au.equals(auLit.getAutor())) {
                       listaAut.remove(au);
                       break;
                    }
                }
            }

            request.setAttribute("listaI", listIzdPomocna);
            request.setAttribute("listaA", listaAut);
            request.setAttribute("l", litDb);
            request.setAttribute("iz", izD);

            return Constants.UPDATE_LITERATURE;
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            return Constants.UPDATE_LITERATURE;
        }

    }

}
