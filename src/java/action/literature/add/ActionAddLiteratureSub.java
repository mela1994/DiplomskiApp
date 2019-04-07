/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.add;

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
public class ActionAddLiteratureSub extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String predmetID = request.getParameter("predmetID");
        int predmetIDint = Integer.parseInt(predmetID);
        DAOPredmet daoP = new DAOPredmetImpl();
        PredmetServis prS = new PredmetServisImpl(daoP);
        HttpSession s = request.getSession();
        Zaposleni ulogZap = (Zaposleni) s.getAttribute("ulogovaniZap");
        List<Predmet> listaPr = new ArrayList<>();
        String skolskaGodina = "";// ide na formu
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
        Predmet p = new Predmet();
//        List<Skolskagodina> skPomocna = new ArrayList<>();//izvucena literatura od prosle godine !!!ide na formu !!!
//        List<Skolskagodina> listaDb = new ArrayList<>();
//      
//        List<Literatura> listLitDb = new ArrayList<>(); // lista Literatura iz baze, odavde izvuci bez SK
//        List<Literatura> listaLitDBBezSK = new ArrayList<>();//pomocna lista za lit bez skolske godine
        try {
            List<Skolskagodina> filtriranaListaSK = new ArrayList<>();
            List<Skolskagodina> listaLitNaPRedmetuDB = new ArrayList<>();

            List<Literatura> listaSvihLiteraturaIzBaze = new ArrayList<>();
             
            p = prS.vratiPredmet(predmetIDint);

            listaLitNaPRedmetuDB = p.getSkolskagodinaList();//lista literatura na predmetu...
            listaSvihLiteraturaIzBaze = litS.vratiSveLiterature();//lista svih literatura iz baze...
      ;

            for (Skolskagodina sk : listaLitNaPRedmetuDB) {
                String[] skGodina = sk.getSkolskaGodina().split("/");
                int[] skGodinaInT = new int[skGodina.length];
                for (int i = 0; i < skGodina.length; i++) {
                    skGodinaInT[i] = Integer.parseInt(skGodina[i]);
                }
                int prvaCifraIntDB = skGodinaInT[0];
                int drugaCifraIntDB = skGodinaInT[1];
                if (prvaCifraInt == prvaCifraIntDB & drugaCifraInt == drugaCifraIntDB) {
                    filtriranaListaSK.add(sk);
                }

            }
            List<Literatura> listPomocnaLita = new ArrayList<>();

            for (Literatura l : listaSvihLiteraturaIzBaze) {
                for (Skolskagodina sk : filtriranaListaSK) {
                    if (l.getNazivKnjige().equals(sk.getLiteratura().getNazivKnjige())
                            && l.getIzdanje().equals(sk.getLiteratura().getIzdanje())) {
                        listPomocnaLita.add(l);
                    }
                }
            }
            listaSvihLiteraturaIzBaze.removeAll(listPomocnaLita);

//            int prvaCifraIntDB = 0;
//            int drugaCifraIntDB = 0;
//            p = daoP.vratiPredmet(predmetIDint);
//            listLitDb = daoL.vratiSveLiterature();
//            for (Literatura litDb : listLitDb) {
//                if (litDb.getSkolskagodinaList().isEmpty()) {
//                    listaLitDBBezSK.add(litDb);
//                }
//                for (Skolskagodina sk : litDb.getSkolskagodinaList()) {
//                    String[] skNizDB = sk.getSkolskaGodina().split("/");
//                    int[] skNizIntDB = new int[skNizDB.length];
//                    for (int i = 0; i < skNizDB.length; i++) {
//                        skNizIntDB[i] = Integer.parseInt(skNizDB[i]);
//                    }
//                    prvaCifraIntDB = skNizIntDB[0];
//                    drugaCifraIntDB = skNizIntDB[1];
//                    if (prvaCifraInt == drugaCifraIntDB) {
//                        skPomocna.add(sk);
//                    }
//                }
//            }
//
//            listaDb = p.getSkolskagodinaList();
//            for (Skolskagodina sk : listaDb) {
//                 String[] skNizDB = sk.getSkolskaGodina().split("/");
//                for (Skolskagodina skPom : skPomocna) {
//                    if(sk.getLiteratura().getNazivKnjige())
//                    
//                }
//                
//            }
//
//            for (Skolskagodina sk : listaDb) {
//                String[] skNizDB = sk.getSkolskaGodina().split("/");
//                int[] skNizIntDB = new int[skNizDB.length];
//                for (int i = 0; i < skNizDB.length; i++) {
//                    skNizIntDB[i] = Integer.parseInt(skNizDB[i]);
//                }
//                prvaCifraIntDB = skNizIntDB[0];
//                drugaCifraIntDB = skNizIntDB[1];
//                if (prvaCifraInt == drugaCifraIntDB) {
//                    skPomocna.add(sk);
//                }
//
//            }
//            for (Skolskagodina i : listaDb) {
//                String[] skNizDB = i.getSkolskaGodina().split("/");
//                if (skNiz[0].equals(skNizDB[0]) && skNiz[1].equals(skNizDB[1])) {
//                    skPomocna = new ArrayList<>();
//                }
//            }
//            for (Literatura li : listaLitDBBezSK) {
//                Skolskagodina sk = new Skolskagodina();
//                sk.setLiteratura(li);
//                skPomocna.add(sk);
//            }
            listaPr = prS.vratiSvePremete(ulogZap.getSifraKatedre().getSifraKatedre());// ide na formu
            request.setAttribute("listaPre", listaPr);
            request.setAttribute("sk", skolskaGodina);
            request.setAttribute("p", p);
            request.setAttribute("listaLit", listaSvihLiteraturaIzBaze);
//            request.setAttribute("skLista", skPomocna);// za drugi slucaj 

            return Constants.ADD_LITERATURE_SUB;
        } catch (Exception ex) {
            request.setAttribute("listaPre", listaPr);
            return Constants.ADD_LITERATURE_SUB;
        }

    }

}
