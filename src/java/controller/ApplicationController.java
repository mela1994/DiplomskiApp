/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import action.AbstractAction;
import action.ActionFactory;
import constants.Constants;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nikola
 */
public class ApplicationController {

    private static ApplicationController instance;

    private ApplicationController() {
    }

    public static ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
        }
        return instance;
    }

    public String processRequest(HttpServletRequest request) {
        String view = Constants.LOGIN;
        String action = request.getParameter("action");
        AbstractAction command = ActionFactory.createAction(action);
        view = command.execute(request);

        return view;
    }

}
