/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Veterinar;
import domen.Zivotinja;
import java.util.List;
import operacije.LoginSO;
import operacije.UcitajSveZivotinjeSO;

/**
 *
 * @author gazda
 */
public class Controller {
    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public Veterinar login(Veterinar v) throws Exception {
        LoginSO lo = new LoginSO();
        lo.izvrsi(v, null);
        System.out.println("Klasa kontroler : " + lo.getVeterinar());
        return lo.getVeterinar();
    }
    
    public List<Zivotinja> vratiSveZivotinje() throws Exception {
        UcitajSveZivotinjeSO so = new UcitajSveZivotinjeSO();
        so.izvrsi(new Zivotinja(), null);
        return so.getLista();
    }
    
}
    