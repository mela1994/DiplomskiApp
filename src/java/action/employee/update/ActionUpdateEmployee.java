/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.update;

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
import model.Zvanje;
import servis.ZaposleniServis;
import servis.impl.ZaposleniServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionUpdateEmployee extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            int zaposleniID = Integer.parseInt(request.getParameter("employeeID"));
            DAOZaposleni daoZap = new DAOZaposleniImpl();
             ZaposleniServis zapS = new ZaposleniServisImpl(daoZap);
            Zaposleni zapDB = zapS.vratiZaposlenogPoID(zaposleniID);
            
            Zvanje zv = zapDB.getSifraZvanja();
            List<Zvanje> listaZvanja = new ArrayList();
            List<Zvanje> listaZvanjaPom = new ArrayList();
            listaZvanja = zapS.vratiListuZvanja();

            for (Zvanje zvanje : listaZvanja) {
                if (!zv.equals(zvanje)) {
                    listaZvanjaPom.add(zvanje);
                }
            }

            request.setAttribute("zapDB", zapDB);

            request.setAttribute("listaZv", listaZvanjaPom);

            return Constants.UPDATE_EMPLOYEE;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.UPDATE_EMPLOYEE;
        }
    }

}
