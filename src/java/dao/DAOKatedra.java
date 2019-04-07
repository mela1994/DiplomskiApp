/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Katedra;

/**
 *
 * @author Nikola
 */
public interface DAOKatedra {

    public Katedra vratiKatedru(int katedraID) throws Exception;

    public List<Katedra> vratiSveKatedre() throws Exception;

}
