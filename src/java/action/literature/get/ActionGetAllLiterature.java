/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.get;

import action.AbstractAction;
import constants.Constants;
import dao.DAOLiteratura;
import dao.impl.DAOLiteraturaImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Literatura;
import servis.LiteraturaServis;
import servis.impl.LiteraturaServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionGetAllLiterature extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        DAOLiteratura daoL = new DAOLiteraturaImpl();
        LiteraturaServis litS = new LiteraturaServisImpl(daoL);
        try {
            List<Literatura> listaLiteratura = litS.vratiSveLiterature();
            request.setAttribute("listaLit", listaLiteratura);

            return Constants.GET_ALL_LITERATURE;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.GET_ALL_LITERATURE;
        }

    }

}
