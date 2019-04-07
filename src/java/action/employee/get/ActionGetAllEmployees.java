/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.get;

import action.AbstractAction;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import constants.Constants;
import dao.DAOZaposleni;
import dao.impl.DAOZaposleniImpl;
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
public class ActionGetAllEmployees extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int katedraID = Integer.parseInt(request.getParameter("katedraID"));
        DAOZaposleni daoZap = new DAOZaposleniImpl();
        ZaposleniServis serZ = new ZaposleniServisImpl(daoZap);
        try {
            List<Zaposleni> listaZaposlenih = serZ.vratiSveZaposleneNaKatedri(katedraID);
            request.setAttribute("listaZap", listaZaposlenih);
   
            return Constants.ALL_EMPLOYEES;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_EMPLOYEES;
        }

    }

}
