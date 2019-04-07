/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.delete;

import action.AbstractAction;
import constants.Constants;
import dao.DAOLiteratura;
import dao.impl.DAOLiteraturaImpl;
import java.util.ArrayList;
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
public class ActionDeleteLiterature extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String literaturaIDStr = request.getParameter("literatureID");
        int literatureIDint = Integer.parseInt(literaturaIDStr);

        DAOLiteratura daoL = new DAOLiteraturaImpl();
        LiteraturaServis litS = new LiteraturaServisImpl(daoL);
        List<Literatura> listaLiteratura = new ArrayList<>();

        try {
            litS.obrisiLiteraturu(literatureIDint);
            listaLiteratura = litS.vratiSveLiterature();
            request.setAttribute("listaLit", listaLiteratura);
            request.setAttribute("suceessMessage", "Sistem je uspesno obrisao literaturu");
            return Constants.GET_ALL_LITERATURE;
        } catch (Exception ex) {
            request.setAttribute("listaLit", listaLiteratura);
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.GET_ALL_LITERATURE;
        }

    }

}
