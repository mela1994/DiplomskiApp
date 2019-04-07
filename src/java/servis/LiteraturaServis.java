/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import java.util.List;
import model.Autor;
import model.Izdavac;
import model.Literatura;

/**
 *
 * @author Nikola
 */
public interface LiteraturaServis {

    public List<Literatura> vratiSveLiterature() throws Exception;

    public Literatura vratiLiteraturu(int literaturaID) throws Exception;

    public void sacuvajLiteraturu(Literatura l, Izdavac i, List<Autor> listaAutora) throws Exception;

    public void obrisiLiteraturu(int literaturaID) throws Exception;

    public void dodajLiteraturuZaPredmet(String sk, int predmetID, int literaturaID) throws Exception;

    public void izmeniLiteraturu(Literatura l, Izdavac i, List<Autor> listaAutora, int literaturaID) throws Exception;

}
