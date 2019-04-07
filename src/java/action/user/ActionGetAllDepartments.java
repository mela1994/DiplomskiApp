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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Katedra;
import servis.KatedraServis;
import servis.impl.KatedraServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionGetAllDepartments extends AbstractAction{

    @Override
    public String execute(HttpServletRequest request) {
        List<Katedra> katedre = new ArrayList<>();
        DAOKatedra daoK = new DAOKatedraImpl();
        KatedraServis katS = new KatedraServisImpl(daoK);
        try {
            katedre = katS.vratiSveKatedre();
            request.setAttribute("k", katedre);
            return Constants.ALL_DEPARTMENTS_USER;
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            return Constants.ALL_DEPARTMENTS_USER;
        }
    }
}
