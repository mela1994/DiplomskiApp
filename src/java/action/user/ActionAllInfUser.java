/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.user;

import action.AbstractAction;
import constants.Constants;
import dao.DAOKatedra;
import dao.impl.DAOKatedraImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Katedra;
import servis.KatedraServis;
import servis.impl.KatedraServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionAllInfUser extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String katedraID = request.getParameter("katedraID");
        int katedraIDint = Integer.parseInt(katedraID);
        HttpSession session = request.getSession();
        DAOKatedra daoK = new DAOKatedraImpl();
        KatedraServis katS = new KatedraServisImpl(daoK);
        try {
            Katedra kat = katS.vratiKatedru(katedraIDint);
            session.setAttribute("katUser", kat);

            return Constants.ALL_INF_USER;
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            return Constants.ALL_INF_USER;
        }

    }

}
