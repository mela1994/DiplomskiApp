/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.save;

import action.AbstractAction;
import constants.Constants;
import controller.Controller;
import dao.DAOAutor;
import dao.DAOIzdavac;
import dao.DAOLiteratura;
import dao.impl.DAOAutorImpl;
import dao.impl.DAOIzdavacImpl;
import dao.impl.DAOLiteraturaImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Autor;
import model.Izdavac;
import model.Literatura;
import servis.AutorServis;
import servis.IzdavacServis;
import servis.LiteraturaServis;
import servis.impl.AutorServisImpl;
import servis.impl.IzdavacServisImpl;
import servis.impl.LiteraturaServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionSaveLiterature extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String nazivKnjige = request.getParameter("naziv_knjige");
        String izdanje = request.getParameter("izdanje");
        String izdavac = request.getParameter("izdavac");
        int izdavacID = Integer.parseInt(izdavac);
        List<Autor> listaAutoraDb = new ArrayList<>();
        String[] autoriIDStr = request.getParameterValues("autori[]");
        int[] autoriIDint = new int[autoriIDStr.length];
        for (int i = 0; i < autoriIDStr.length; i++) {
            int autorID = Integer.parseInt(autoriIDStr[i]);
            autoriIDint[i] = autorID;
        }
        Literatura l = new Literatura();
        l.setNazivKnjige(nazivKnjige);
        l.setIzdanje(izdanje);

        List<Autor> listaAut = new ArrayList<>();
        List<Izdavac> listaIzd = new ArrayList<>();

        DAOIzdavac daoI = new DAOIzdavacImpl();
        IzdavacServis izS = new IzdavacServisImpl(daoI);
        DAOAutor daoA = new DAOAutorImpl();
        AutorServis auS = new AutorServisImpl(daoA);
        DAOLiteratura daoL = new DAOLiteraturaImpl();
        LiteraturaServis litS = new LiteraturaServisImpl(daoL);
        try {
            listaAut = auS.vratiSveAutore();
            listaIzd = izS.vratiSveIzdavace();
            Izdavac izdavacDB = izS.vratiIzdavacaPoID(izdavacID);
            listaAutoraDb = auS.vratiListuAutoraPoID(autoriIDint);
            litS.sacuvajLiteraturu(l, izdavacDB, listaAutoraDb);

            request.setAttribute("listaI", listaIzd);
            request.setAttribute("listaA", listaAut);
            request.setAttribute("successMessage", "Sistem je zapamtio literaturu");

            return Constants.ADD_LITERATURE;
        } catch (Exception ex) {
            request.setAttribute("listaI", listaIzd);
            request.setAttribute("listaA", listaAut);
            request.setAttribute("errorMessage", ex.getMessage());

            return Constants.ADD_LITERATURE;
        }

    }

}
