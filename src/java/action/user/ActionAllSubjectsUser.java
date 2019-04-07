/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.user;

import action.AbstractAction;
import constants.Constants;
import dao.DAOPredmet;
import dao.impl.DAOPredmetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Predmet;
import servis.PredmetServis;
import servis.impl.PredmetServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionAllSubjectsUser extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        int katedraID = Integer.parseInt(request.getParameter("katedraID"));
        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis prS = new PredmetServisImpl(daoP);
        List<Predmet> listPredmeta = new ArrayList<>();
        try {
            listPredmeta = prS.vratiSvePremete(katedraID);
            request.setAttribute("listaPre", listPredmeta);
            return Constants.ALL_SUBJECTS_USER;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_SUBJECTS_USER;
        }

    }

}
