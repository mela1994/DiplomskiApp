/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.literature.update;

import action.AbstractAction;
import constants.Constants;
import dao.DAOAutor;
import dao.DAOIzdavac;
import dao.impl.DAOAutorImpl;
import dao.impl.DAOIzdavacImpl;
import dao.impl.DAOLiteraturaImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
public class ActionUpdateLiteratureExecute extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String nazivKnjige = request.getParameter("naziv_knjige");
        String izdanje = request.getParameter("izdanje");
        String izdavac = request.getParameter("izdavac");
        int izdavacID = Integer.parseInt(izdavac);
        String literatureID = request.getParameter("litaratureID");
        int liteartureIDint = Integer.parseInt(literatureID);
        String[] autoriIDNOVI = request.getParameterValues("autori[]");
        String[] sifreAutoraStari = request.getParameterValues("sifre[]");
        try {
            DAOAutor daoA = new DAOAutorImpl();
            AutorServis auS = new AutorServisImpl(daoA);
            DAOLiteraturaImpl daoL = new DAOLiteraturaImpl();
            LiteraturaServis litS = new LiteraturaServisImpl(daoL);
            DAOIzdavac daoI = new DAOIzdavacImpl();
            IzdavacServis izS = new IzdavacServisImpl(daoI);
            Izdavac izdavacDB = new Izdavac();
            Literatura l = new Literatura();

            List<Autor> listaAutoraStari = new ArrayList<>();
            List<Autor> listaAutoraNovi = new ArrayList<>();
            List<Autor> listaAutoraZaBazu = new ArrayList<>();

            int[] sifreAutoraIntStari = new int[sifreAutoraStari.length];
            for (int i = 0; i < sifreAutoraStari.length; i++) {
                sifreAutoraIntStari[i] = Integer.parseInt(sifreAutoraStari[i]);
            }

            int[] autoriIDintNovi = new int[autoriIDNOVI.length];
            for (int i = 0; i < autoriIDNOVI.length; i++) {
                int autorID = Integer.parseInt(autoriIDNOVI[i]);
                autoriIDintNovi[i] = autorID;
            }

            izdavacDB = izS.vratiIzdavacaPoID(izdavacID);
            listaAutoraStari = auS.vratiListuAutoraPoID(sifreAutoraIntStari);
            listaAutoraNovi = auS.vratiListuAutoraPoID(autoriIDintNovi);
            if (!listaAutoraStari.isEmpty()) {
                for (Autor autor : listaAutoraStari) {
                    listaAutoraZaBazu.add(autor);
                }
            }
            if (!listaAutoraNovi.isEmpty()) {
                for (Autor autor : listaAutoraNovi) {
                    listaAutoraZaBazu.add(autor);
                }
            }
            l.setNazivKnjige(nazivKnjige);
            l.setIzdanje(izdanje);
            l.setSifraKnjige(liteartureIDint);

            litS.izmeniLiteraturu(l, izdavacDB, listaAutoraZaBazu, liteartureIDint);
            List<Literatura> listaLiteratura = litS.vratiSveLiterature();
            request.setAttribute("listaLit", listaLiteratura);
            request.setAttribute("suceessMessage", "Sistem je izmenio literaturu");

            return Constants.GET_ALL_LITERATURE;
        } catch (Exception ex) {
            return Constants.UPDATE_LITERATURE;
        }

    }

}
