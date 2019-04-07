/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.user;

import action.AbstractAction;
import constants.Constants;
import dao.DAOPredmet;
import dao.DAOZaposleni;
import dao.impl.DAOPredmetImpl;
import dao.impl.DAOZaposleniImpl;
import java.util.ArrayList;
import java.util.HashSet;
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
public class ActionAllEmployeeSubUser extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String predmetIDs =  request.getParameter("predmetID") ;
        int predmetID = Integer.parseInt(predmetIDs);
         
        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis prS = new PredmetServisImpl(daoP);
        List<Uloga> lista = new ArrayList<>();
        Set<Zaposleni> listaZaposleniNaPredmetu = new HashSet<>();
        try {
            Predmet pre = prS.vratiPredmet(predmetID);
            listaZaposleniNaPredmetu = prS.vratiListuUloga(predmetID);
            request.setAttribute("lista", lista);
            request.setAttribute("p", pre);

        } catch (Exception ex) {
            Logger.getLogger(ActionAllEmployeeSubUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Constants.ALL_EMPLOYEE_SUB_USER;
    }

}
