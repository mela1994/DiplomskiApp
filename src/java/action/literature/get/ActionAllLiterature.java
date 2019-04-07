/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.get;

import action.AbstractAction;
import constants.Constants;
import dao.DAOPredmet;
import dao.impl.DAOPredmetImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Predmet;
import model.Zaposleni;
import servis.PredmetServis;
import servis.impl.PredmetServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionAllLiterature extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int predmetID = Integer.parseInt(request.getParameter("predmetID"));
        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis preS = new PredmetServisImpl(daoP);
        try {
            HttpSession s = request.getSession();
            Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
            List<Predmet> listaPr = preS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());
            request.setAttribute("listaPre", listaPr);
            Predmet p = preS.vratiPredmet(predmetID);
            request.setAttribute("p", p);
            return Constants.ALL_LITERATURE_SUB;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_LITERATURE_SUB;
        }

    }

}
