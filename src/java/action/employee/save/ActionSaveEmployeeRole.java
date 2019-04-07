/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.save;

import action.AbstractAction;
import constants.Constants;
import dao.DAOPredmet;
import dao.DAOZaposleni;
import dao.impl.DAOPredmetImpl;
import dao.impl.DAOZaposleniImpl;
import java.util.ArrayList;
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
public class ActionSaveEmployeeRole extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession s = request.getSession();
        String predmetIDs = (String) s.getAttribute("preID");
        int predmetID = Integer.parseInt(predmetIDs);
        int zaposleniID = Integer.parseInt(request.getParameter("zaposleni"));
        String uloga = request.getParameter("uloga");
        HttpSession session = request.getSession();
        Zaposleni zap = (Zaposleni) session.getAttribute("ulogovaniZap");
        int katedraID = zap.getSifraKatedre().getSifraKatedre();
        List<Zaposleni> lista = new ArrayList<>();
        List<Predmet> listaPr = new ArrayList<>();
        DAOZaposleni daoZap = new DAOZaposleniImpl();
        ZaposleniServis zapS = new ZaposleniServisImpl(daoZap);
        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis preS = new PredmetServisImpl(daoP);

        try {
            lista = zapS.vratiSveZaposleneNaKatedri(katedraID);
            Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
            listaPr = preS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());
            request.setAttribute("listaPre", listaPr);
            zapS.dodajUlogu(predmetID, zaposleniID, uloga);
            request.setAttribute("lista", lista);
            request.setAttribute("successMessage", "Sistem je zapamtio ulogu");

            return Constants.ADD_EMPOLOYEE_ROLE;
        } catch (Exception ex) {
            String poruka = ex.getMessage();
            request.setAttribute("listePre", listaPr);
            request.setAttribute("lista", lista);
            request.setAttribute("errorMessage", poruka);
            return Constants.ADD_EMPOLOYEE_ROLE;
        }

    }

}
