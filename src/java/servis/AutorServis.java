/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import java.util.List;
import model.Autor;

/**
 *
 * @author Nikola
 */
public interface AutorServis {

    public List<Autor> vratiSveAutore() throws Exception;

    public void sacuvajAutora(Autor a) throws Exception;

    public List<Autor> vratiListuAutoraPoID(int[] autorIDovi) throws Exception;

}
