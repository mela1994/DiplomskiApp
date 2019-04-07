/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author.add;

import action.AbstractAction;
import constants.Constants;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nikola
 */
public class ActionAddAuthor extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        return Constants.ADD_AUTHOR;
    }
}
