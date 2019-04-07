/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.delete;

import action.AbstractAction;
import constants.Constants;
import dao.DAOZaposleni;
import dao.impl.DAOZaposleniImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Zaposleni;
import servis.ZaposleniServis;
import servis.impl.ZaposleniServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionDeleteEmployee extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            int zaposleniID = Integer.parseInt(request.getParameter("employeeID"));

            DAOZaposleni daoZap = new DAOZaposleniImpl();
            ZaposleniServis zapS = new ZaposleniServisImpl(daoZap);
            zapS.izbrisiZaposlenog(zaposleniID);
//            daoZap.izbrisiZaposlenog(zaposleniID);
            request.setAttribute("suceessMessage", "Sistem je obrisao nastavnika");
            HttpSession session = request.getSession();
            Zaposleni zap = (Zaposleni) session.getAttribute("ulogovaniZap");
            int katedraID = zap.getSifraKatedre().getSifraKatedre();
//            List<Zaposleni> listaZap = daoZap.vratiSveZaposleneNaKatedri(katedraID);
            List<Zaposleni> listaZap = zapS.vratiSveZaposleneNaKatedri(katedraID);
            request.setAttribute("listaZap", listaZap);

            return Constants.ALL_EMPLOYEES;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_EMPLOYEES;
        }

    }

}
