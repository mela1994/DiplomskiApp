/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import java.util.List;
import model.Izdavac;
import model.Izdavac_;

/**
 *
 * @author Nikola
 */
public interface IzdavacServis {

    public List<Izdavac> vratiSveIzdavace() throws Exception;

    public Izdavac vratiIzdavacaPoID(int izdavacID) throws Exception;

    public void sacuvajIzdavaca(Izdavac i) throws Exception;

    public int vratiMax() throws Exception;

}
