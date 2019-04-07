/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.user;

import action.AbstractAction;
import constants.Constants;
import dao.DAOPredmet;
import dao.impl.DAOPredmetImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Predmet;
import model.Skolskagodina;
import model.Uloga;
import model.Zaposleni;
import org.jboss.weld.executor.DaemonThreadFactory;
import servis.PredmetServis;
import servis.impl.PredmetServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionSubjectsDetailsUser extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String predmetIDs = request.getParameter("predmetID");
        int predmetID = Integer.parseInt(predmetIDs);
        HttpSession s = request.getSession();
        s.setAttribute("predIDUser", predmetID);
        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis prS = new PredmetServisImpl(daoP);
//        List<Uloga> lista = new ArrayList<>();
     
        int godina = Calendar.getInstance().get(Calendar.YEAR);
        List<Skolskagodina> listaPomocna = new ArrayList<>();

        try {
            Predmet pre = prS.vratiPredmet(predmetID);
            for (Skolskagodina sk : pre.getSkolskagodinaList()) {
                String[] skArray = sk.getSkolskaGodina().split("/");
                String skPrvaArray = skArray[0];
                
                int skInt = Integer.parseInt(skPrvaArray);
                if (skInt == godina-1) {
                    listaPomocna.add(sk);
                }
            }
            Set<Zaposleni> lista = new HashSet<>();
            pre.setSkolskagodinaList(listaPomocna);
            lista = prS.vratiListuUloga(predmetID);
            request.setAttribute("lista", lista);
            request.setAttribute("p", pre);
            return Constants.SUBJECTS_DETAILS;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.SUBJECTS_DETAILS;
        }

    }

}
