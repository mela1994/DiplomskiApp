/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.login;

import action.AbstractAction;
import constants.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Zaposleni;

/**
 *
 * @author Nikola
 */
public class ActionLogOut extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return Constants.INDEX_USER;
    }

}
