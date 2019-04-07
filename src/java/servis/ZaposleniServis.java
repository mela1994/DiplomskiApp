/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import java.util.List;
import model.Zaposleni;
import model.Zvanje;

/**
 *
 * @author Nikola
 */
public interface ZaposleniServis {

    public Zaposleni pronadjiZaposlenog(Zaposleni zaposleni) throws Exception;

    public List<Zaposleni> vratiSveZaposleneNaKatedri(int katedraId) throws Exception;

    public void dodajZaposlenog(Zaposleni zaposleni, int sifraZvanja) throws Exception;

    public void izbrisiZaposlenog(int zaposleniID) throws Exception;

    public void dodajUlogu(int predmetID, int zaposleniID, String uloga) throws Exception;

    public Zaposleni vratiZaposlenogPoID(int zaposleniID) throws Exception;

    public void izmeniZaposlenog(Zaposleni zap, int sifraZvanja) throws Exception;

    public List<Zvanje> vratiListuZvanja() throws Exception;

}
