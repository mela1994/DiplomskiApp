/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.save;

import action.AbstractAction;
import constants.Constants;
import dao.DAOLiteratura;
import dao.DAOPredmet;
import dao.impl.DAOLiteraturaImpl;
import dao.impl.DAOPredmetImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Literatura;
import model.Predmet;
import model.Skolskagodina;
import model.Zaposleni;
import servis.LiteraturaServis;
import servis.PredmetServis;
import servis.impl.LiteraturaServisImpl;
import servis.impl.PredmetServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionSaveLiteratureSub extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String sk = request.getParameter("sk");
        String predmetID = request.getParameter("predmetID");
        String literaturaID = request.getParameter("literaturaID");

        int predmetIDint = Integer.parseInt(predmetID);
        int literaturaIDint = Integer.parseInt(literaturaID);

        HttpSession s = request.getSession();
        Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
        List<Predmet> listaPr = new ArrayList<>();

        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis preS = new PredmetServisImpl(daoP);
        DAOLiteratura daoL = new DAOLiteraturaImpl();
        LiteraturaServis litS = new LiteraturaServisImpl(daoL);
        Predmet p = new Predmet();
        try {
            litS.dodajLiteraturuZaPredmet(sk, predmetIDint, literaturaIDint);
            request.setAttribute("successMessage", "Sistem je zapamtio literaturu");
            listaPr = preS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());// ide na formu
            p = preS.vratiPredmet(predmetIDint);
            List<Literatura> listaNova = vratiListuLitreartura(sk, p);
            request.setAttribute("listaPre", listaPr);
            request.setAttribute("sk", sk);
            request.setAttribute("p", p);
            request.setAttribute("listaLit", listaNova);

            return Constants.ADD_LITERATURE_SUB;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.ADD_LITERATURE_SUB;

        }

    }

    private List<Literatura> vratiListuLitreartura(String sk, Predmet p) {
        String skolskaGodina = "";
        Calendar cal = Calendar.getInstance();
        int calY = cal.get(Calendar.YEAR);
        if (cal.get(Calendar.MONTH) > Calendar.OCTOBER) {
            skolskaGodina = calY + "/" + (calY + 1);
        } else {
            skolskaGodina = (calY - 1) + "/" + calY;
        }
        String[] skNiz = skolskaGodina.split("/");
        int[] skNizInt = new int[skNiz.length];
        for (int i = 0; i < skNiz.length; i++) {
            skNizInt[i] = Integer.parseInt(skNiz[i]);
        }
        int prvaCifraInt = skNizInt[0];
        int drugaCifraInt = skNizInt[1];
        DAOLiteratura daoL = new DAOLiteraturaImpl();
        LiteraturaServis litS = new LiteraturaServisImpl(daoL);

        List<Skolskagodina> filtriranaListaSK = new ArrayList<>();
        List<Skolskagodina> listaLitNaPRedmetuDB = new ArrayList<>();

        List<Literatura> listaSvihLiteraturaIzBaze = new ArrayList<>();

        try {
            listaLitNaPRedmetuDB = p.getSkolskagodinaList();//lista literatura na predmetu...
            listaSvihLiteraturaIzBaze = litS.vratiSveLiterature();//lista svih literatura iz baze...
            for (Skolskagodina skG : listaLitNaPRedmetuDB) {
                String[] skGodina = skG.getSkolskaGodina().split("/");
                int[] skGodinaInT = new int[skGodina.length];
                for (int i = 0; i < skGodina.length; i++) {
                    skGodinaInT[i] = Integer.parseInt(skGodina[i]);
                }
                int prvaCifraIntDB = skGodinaInT[0];
                int drugaCifraIntDB = skGodinaInT[1];
                if (prvaCifraInt == prvaCifraIntDB & drugaCifraInt == drugaCifraIntDB) {
                    filtriranaListaSK.add(skG);
                }

            }
            List<Literatura> listPomocnaLita = new ArrayList<>();

            for (Literatura l : listaSvihLiteraturaIzBaze) {
                for (Skolskagodina skGod : filtriranaListaSK) {
                    if (l.getNazivKnjige().equals(skGod.getLiteratura().getNazivKnjige())
                            && l.getIzdanje().equals(skGod.getLiteratura().getIzdanje())) {
                        listPomocnaLita.add(l);
                    }
                }
            }
            listaSvihLiteraturaIzBaze.removeAll(listPomocnaLita);

        } catch (Exception e) {
            
        }

        return listaSvihLiteraturaIzBaze;
    }

}
