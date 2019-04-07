/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.employee.update;

import action.AbstractAction;
import constants.Constants;
import dao.DAOZaposleni;
import dao.impl.DAOZaposleniImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Katedra;
import model.Zaposleni;
import servis.ZaposleniServis;
import servis.impl.ZaposleniServisImpl;

/**
 *
 * @author Nikola
 */
public class ActionUpdateEmployeeExecute extends AbstractAction{

    @Override
    public String execute(HttpServletRequest request) {
        String sifraZap = request.getParameter("employeeID");
        int sifraZapInt = Integer.parseInt(sifraZap);
        String ime = request.getParameter("ime_zap");
        String prezime = request.getParameter("prezime_zap");
        String kontaktTelefon = request.getParameter("tel_zap");
        String brojKabineta = request.getParameter("kab_zap");
        String email = request.getParameter("email_zap");
        String kor_ime = request.getParameter("kor_ime_zap");
        String kor_sifra = request.getParameter("kor_sif_zap");
        HttpSession session = request.getSession();
        Zaposleni zap = (Zaposleni) session.getAttribute("ulogovaniZap");
        Katedra kat = zap.getSifraKatedre();
        Zaposleni noviZap = new Zaposleni();
        noviZap.setSifraZaposlenog(sifraZapInt);
        noviZap.setIme(ime);
        noviZap.setPrezime(prezime);
        noviZap.setBrojKabineta(brojKabineta);
        noviZap.setKontaktTelefon(kontaktTelefon);
        noviZap.setEmail(email);
        noviZap.setKorisnickoIme(kor_ime);
        noviZap.setKorisnickaSifra(kor_sifra);
        noviZap.setSifraKatedre(kat);
        int sifraZvanja = Integer.parseInt(request.getParameter("zvanje"));
        
        DAOZaposleni daoZap = new DAOZaposleniImpl();
        ZaposleniServis zapS = new ZaposleniServisImpl(daoZap);
        try {
            zapS.izmeniZaposlenog(noviZap, sifraZvanja);
            Zaposleni zapNull = new Zaposleni();
            request.setAttribute("zapDB", zapNull);
            request.setAttribute("successMessage", "Sistem je uspesno izmenio zaposlenog");
            return Constants.UPDATE_EMPLOYEE;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return Constants.UPDATE_EMPLOYEE;
        }
    } 
}
