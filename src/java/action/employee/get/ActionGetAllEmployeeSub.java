/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.get;

import action.AbstractAction;
import constants.Constants;
import dao.DAOPredmet;
import dao.impl.DAOPredmetImpl;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Predmet;
import model.Uloga;
import model.Zaposleni;
import servis.PredmetServis;
import servis.impl.PredmetServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionGetAllEmployeeSub extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int predmetID = Integer.parseInt(request.getParameter("predmetID"));
        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis preS = new PredmetServisImpl(daoP);
        try {
//            Predmet pre = daoP.vratiPredmet(predmetID);
            Predmet pre = preS.vratiPredmet(predmetID);
            HttpSession s = request.getSession();
            Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
//            List<Predmet> listaPr = daoP.vratiSvePredmete(ulogZap.getSifraKatedre().getSifraKatedre());
            List<Predmet> listaPr = preS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());
            request.setAttribute("listaPre", listaPr);
//            Set<Zaposleni> lista = daoP.vratiListuUloga(predmetID);
            Set<Zaposleni> lista = preS.vratiListuUloga(predmetID);
            request.setAttribute("p", pre);
            request.setAttribute("lista", lista);

            return Constants.ALL_EMPLOYEE_SUB;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_EMPLOYEE_SUB;
        }
    }
}
