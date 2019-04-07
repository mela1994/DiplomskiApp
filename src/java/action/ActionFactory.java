/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import action.login.ActionLogOut;
import action.login.ActionLoginUser;
import action.login.ActionLogin;
import action.employee.delete.ActionDeleteEmployeeRole;
import action.user.ActionGetAllDepartments;
import action.user.ActionAllEmployeesUser;
import action.user.ActionAllEmployeeSubUser;
import action.user.ActionHomePageUser;
import action.user.ActionHomePage;
import action.user.ActionAllSubjectsUser;
import action.user.ActionAllInfUser;
import action.publisher.add.ActionAddPublisher;
import action.publisher.save.ActionSavePublisher;
import action.author.add.ActionAddAuthor;
import action.author.save.ActionSaveAuthor;
import action.author.get.ActionGetAuthorsLit;
import action.user.ActionSubjectsDetailsUser;
import action.subject.ActionAllSubjects;
import action.literature.get.ActionAllLiterature;
import action.literature.get.ActionGetAllLiterature;
import action.literature.save.ActionSaveLiterature;
import action.literature.add.ActionAddLiterature;
import action.employee.add.ActionAddEmployeeRole;
import action.employee.update.ActionUpdateEmployee;
import action.employee.add.ActionAddEmployee;
import action.employee.delete.ActionDeleteEmployee;
import action.employee.save.ActionSaveEmployeeRole;
import action.employee.get.ActionGetAllEmployeeSub;
import action.employee.save.ActionSaveEmployee;
import action.employee.get.ActionGetAllEmployees;
import action.employee.update.ActionUpdateEmployeeExecute;
import action.literature.add.ActionAddLiteratureSub;
import action.literature.delete.ActionDeleteLiterature;
 
import action.literature.save.ActionSaveLiteratureSub;
import action.literature.update.ActionUpdateLiterature;
import action.literature.update.ActionUpdateLiteratureExecute;
import constants.Constants;

/**
 *
 * @author Nikola
 */
public class ActionFactory {

    public static AbstractAction createAction(String action) {
        AbstractAction command = null;
        switch (action) {
            case Constants.LOGIN:
                return command = new ActionLogin();
            case Constants.ALL_EMPLOYEES:
                return command = new ActionGetAllEmployees();
            case Constants.ADD_EMPLOYEES:
                return command = new ActionAddEmployee();
            case Constants.SAVE_EMPLOYEES:
                return command = new ActionSaveEmployee();
            case Constants.LOGOUT:
                return command = new ActionLogOut();
            case Constants.DELETE_EMPLOYEE:
                return command = new ActionDeleteEmployee();
            case Constants.ALL_SUBJECTS:
                return command = new ActionAllSubjects();
            case Constants.ALL_EMPLOYEE_SUB:
                return command = new ActionGetAllEmployeeSub();
            case Constants.INDEX:
                return command = new ActionHomePage();
            case Constants.DELETE_ROLE:
                return command = new ActionDeleteEmployeeRole();
            case Constants.ALL_LITERATURE_SUB:
                return command = new ActionAllLiterature();
            case Constants.ADD_LITERATURE:
                return command = new ActionAddLiterature();
            case Constants.SAVE_LITERATURE:
                return command = new ActionSaveLiterature();
            case Constants.ADD_EMPOLOYEE_ROLE:
                return command = new ActionAddEmployeeRole();
            case Constants.SAVE_EMPOLOYEE_ROLE:
                return command = new ActionSaveEmployeeRole();
            case Constants.GET_AUTHORS_LIT:
                return command = new ActionGetAuthorsLit();
            case Constants.ALL_DEPARTMENTS_USER:
                return command = new ActionGetAllDepartments();
            case Constants.LOGIN_USER:
                return command = new ActionLoginUser();
            case Constants.INDEX_USER:
                return command = new ActionHomePageUser();
            case Constants.ALL_INF_USER:
                return command = new ActionAllInfUser();
            case Constants.ALL_EMPLOYEES_USER:
                return command = new ActionAllEmployeesUser();
            case Constants.ALL_SUBJECTS_USER:
                return command = new ActionAllSubjectsUser();
            case Constants.ALL_EMPLOYEE_SUB_USER:
                return command = new ActionAllEmployeeSubUser();

            case Constants.UPDATE_EMPLOYEE:
                return command = new ActionUpdateEmployee();
            case Constants.UPDATE_EMPLOYEE_EXECUTE:
                return command = new ActionUpdateEmployeeExecute();
            case Constants.SUBJECTS_DETAILS:
                return command = new ActionSubjectsDetailsUser();
            case Constants.GET_ALL_LITERATURE:
                return command = new ActionGetAllLiterature();
            case Constants.ADD_PUBLISHER:
                return command = new ActionAddPublisher();
            case Constants.SAVE_PUBLISHER:
                return command = new ActionSavePublisher();
            case Constants.ADD_AUTHOR:
                return command = new ActionAddAuthor();
            case Constants.SAVE_AUTHOR:
                return command = new ActionSaveAuthor();
            case Constants.DELETE_LITERATURE:
                return command = new ActionDeleteLiterature();
            case Constants.ADD_LITERATURE_SUB:
                return command = new ActionAddLiteratureSub();
            case Constants.SAVE_LITERATURE_SUB:
                return command = new ActionSaveLiteratureSub();
            case Constants.UPDATE_LITERATURE:
                return command = new ActionUpdateLiterature();
            case Constants.UPDATE_LITERATURE_EXECUTE:
                return command = new ActionUpdateLiteratureExecute();
             
        }
        return command;
    }

}
