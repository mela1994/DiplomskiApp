/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author.get;

import action.AbstractAction;
import constants.Constants;
import dao.DAOLiteratura;
import dao.DAOPredmet;
import dao.impl.DAOPredmetImpl;
import dao.impl.DAOLiteraturaImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Autor;
import model.Autorliteratura;
import model.Literatura;
import model.Predmet;
import model.Zaposleni;
import servis.LiteraturaServis;
import servis.PredmetServis;
import servis.impl.LiteraturaServisImpl;
import servis.impl.PredmetServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionGetAuthorsLit extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int literaturaID = Integer.parseInt(request.getParameter("literaturaID"));
        DAOLiteratura daoLit = new DAOLiteraturaImpl();
        DAOPredmet daoP = new DAOPredmetImpl();
        LiteraturaServis litS = new LiteraturaServisImpl(daoLit);
        PredmetServis preS = new PredmetServisImpl(daoP);
        HttpSession s = request.getSession();
        try {
            Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
            List<Predmet> listaPr = preS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());
//            List<Predmet> listaPr = daoP.vratiSvePredmete(ulogZap.getSifraKatedre().getSifraKatedre());
            request.setAttribute("listaPre", listaPr);
            Literatura l = litS.vratiLiteraturu(literaturaID);
//            Literatura l = daoLit.vratiLiteraturu(literaturaID);
            List<Autorliteratura> autori = l.getAutorliteraturaList();
            request.setAttribute("autori", autori);

            return Constants.GET_AUTHORS_LIT;
        } catch (Exception ex) {
            return Constants.GET_AUTHORS_LIT;

        }
    }

}
