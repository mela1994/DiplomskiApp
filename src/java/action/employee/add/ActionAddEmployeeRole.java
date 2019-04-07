/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.add;

import action.AbstractAction;
import constants.Constants;
import dao.DAOPredmet;
import dao.DAOZaposleni;
import dao.impl.DAOPredmetImpl;
import dao.impl.DAOZaposleniImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Predmet;
import model.Zaposleni;
import servis.PredmetServis;
import servis.ZaposleniServis;
import servis.impl.PredmetServisImpl;
import servis.impl.ZaposleniServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionAddEmployeeRole extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int katedraID = Integer.parseInt(request.getParameter("katedraID"));
        String prID = request.getParameter("predmetID");
        DAOZaposleni daoZap = new DAOZaposleniImpl();
        DAOPredmet daoP = new DAOPredmetImpl();
        ZaposleniServis zapS = new ZaposleniServisImpl(daoZap);
        PredmetServis preS = new PredmetServisImpl(daoP);
        try {
//            List<Zaposleni> lista = daoZap.vratiSveZaposleneNaKatedri(katedraID);
            List<Zaposleni> lista = zapS.vratiSveZaposleneNaKatedri(katedraID);
            request.setAttribute("lista", lista);
            HttpSession s = request.getSession();
            s.setAttribute("preID", prID);
            Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
//            List<Predmet> listaPr = daoP.vratiSvePredmete(ulogZap.getSifraKatedre().getSifraKatedre());
            List<Predmet> listaPr = preS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());
            request.setAttribute("listaPre", listaPr);

            return Constants.ADD_EMPOLOYEE_ROLE;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ADD_EMPOLOYEE_ROLE;
        }

    }

}
