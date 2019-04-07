/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.login;

import action.AbstractAction;
import constants.Constants;
import dao.DAOZaposleni;
import dao.impl.DAOZaposleniImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Zaposleni;
import servis.ZaposleniServis;
import servis.impl.ZaposleniServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionLogin extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String korisnickoIme = request.getParameter("korisnickoIme");
        String korisnickaSifra = request.getParameter("korisnickaSifra");

        try {
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.setKorisnickoIme(korisnickoIme);
            zaposleni.setKorisnickaSifra(korisnickaSifra);
            DAOZaposleni daoZap = new DAOZaposleniImpl();
            ZaposleniServis zapS = new ZaposleniServisImpl(daoZap);
            Zaposleni zaposleniDB = zapS.pronadjiZaposlenog(zaposleni);

            HttpSession session = request.getSession();
            session.setAttribute("ulogovaniZap", zaposleniDB);
            request.setAttribute("successMessage", "Uspesno ste se prijavili na sistem");

            return Constants.INDEX;
        } catch (Exception ex) {
            request.setAttribute("erorrMessage", ex.getMessage());
            return Constants.LOGIN_USER;
        }

    }

}
