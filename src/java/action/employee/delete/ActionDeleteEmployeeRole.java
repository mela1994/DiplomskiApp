/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.delete;

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
public class ActionDeleteEmployeeRole extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int predmetID = Integer.parseInt(request.getParameter("subjectID"));
        int zaposleniID = Integer.parseInt(request.getParameter("employeeID"));
        int ulogaID = Integer.parseInt(request.getParameter("roleID"));
        DAOPredmet daoPre = new DAOPredmetImpl();
        PredmetServis preS = new PredmetServisImpl(daoPre);
        try {
//            daoPre.obrisiUloguZaposlenogNaPredmetu(predmetID, zaposleniID, ulogaID);
            preS.obrisiUloguZaposlenogNaPredmetu(predmetID, zaposleniID, ulogaID);
//            Predmet p = daoPre.vratiPredmet(predmetID);
            Predmet p = preS.vratiPredmet(predmetID);
//            Set<Zaposleni> lista = daoPre.vratiListuUloga(predmetID);
            Set<Zaposleni> lista = preS.vratiListuUloga(predmetID);
            HttpSession s = request.getSession();
            Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
//            List<Predmet> listaPr = daoPre.vratiSvePredmete(ulogZap.getSifraKatedre().getSifraKatedre());
            List<Predmet> listaPr = preS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());
            request.setAttribute("listaPre", listaPr);
            request.setAttribute("p", p);
            request.setAttribute("lista", lista);

            return Constants.ALL_EMPLOYEE_SUB;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_EMPLOYEE_SUB;
        }

    }

}
