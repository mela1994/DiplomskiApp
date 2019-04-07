/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.publisher.add;

import action.AbstractAction;
import constants.Constants;
import dao.DAOAutor;
import dao.DAOIzdavac;
import dao.impl.DAOAutorImpl;
import dao.impl.DAOIzdavacImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nikola
 */
public class ActionAddPublisher extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
       
        return Constants.ADD_PUBLISHER;
    }

}
