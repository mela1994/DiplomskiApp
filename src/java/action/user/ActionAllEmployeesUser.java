/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.user;

import action.AbstractAction;
import constants.Constants;
import dao.DAOZaposleni;
import dao.impl.DAOZaposleniImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Zaposleni;
import servis.ZaposleniServis;
import servis.impl.ZaposleniServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionAllEmployeesUser extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int katedraID = Integer.parseInt(request.getParameter("katedraID"));
        DAOZaposleni daoZap = new DAOZaposleniImpl();
        ZaposleniServis zapS = new ZaposleniServisImpl(daoZap);
        List<Zaposleni> lista = new ArrayList<>();
        try {
            lista = zapS.vratiSveZaposleneNaKatedri(katedraID);
            request.setAttribute("listaZap", lista);
            return Constants.ALL_EMPLOYEES_USER;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_EMPLOYEES_USER;
        }
    }

}
