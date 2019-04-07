/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.subject;

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
public class ActionAllSubjects extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        List<Predmet> listaPredmeta = new ArrayList<>();
        int katedraID = Integer.parseInt(request.getParameter("katedraID"));
        try {
            DAOPredmet daoPre = new DAOPredmetImpl();
            PredmetServis prS = new PredmetServisImpl(daoPre);
            listaPredmeta = prS.vratiSvePremete(katedraID);
            request.setAttribute("listaPre", listaPredmeta);
            request.setAttribute("successMessage", "Sistem pronasao predmete po zadatom kriterijumu");
            return Constants.ALL_SUBJECTS;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ALL_SUBJECTS;
        }

    }

}
