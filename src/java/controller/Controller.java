/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Autor;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;
    private List<Autor> listaAutora;

    private Controller() {
        listaAutora = new ArrayList<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void addAuthor(Autor a) {
        listaAutora.add(a);
    }

    public List<Autor> getAuthors() {
        return listaAutora;
    }

    public void removeAllItems() {
       listaAutora = new ArrayList<>();
    }

}
