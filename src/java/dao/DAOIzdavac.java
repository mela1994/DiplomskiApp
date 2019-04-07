/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Izdavac;

/**
 *
 * @author Nikola
 */
public interface DAOIzdavac {

    public List<Izdavac> vratiSveIzdavace() throws Exception;

    public Izdavac vratiIzdavacaPoID(int izdavacID) throws Exception;

    public void sacuajIzdavaca(Izdavac i) throws Exception;
    
    public int vratiMax() throws Exception;

}
