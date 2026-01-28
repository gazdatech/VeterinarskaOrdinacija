/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import domen.Veterinar;
import forme.DodajZivotinjuForma;
import forme.GlavnaForma;
import forme.LoginForm;
import kontroleri.DodajZivotinjuController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;

/**
 *
 * @author gazda
 */
public class Kordinator {
    private static Kordinator instance;
    private Veterinar ulogovani;
    private LoginController loginController;
    private GlavnaFormaController gfController;
    private DodajZivotinjuController dzController;
    private Kordinator() {
        
    }

    public static Kordinator getInstance() {
        if(instance == null) {
            instance = new Kordinator();
        }
        return instance;
    }


    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForm());
        loginController.otvoriFormu();
    }

    public Veterinar getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Veterinar ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriGlavnuFormu() throws Exception {
        gfController = new GlavnaFormaController(new GlavnaForma());
        gfController.otvoriFormu();
    }
    
    public void otvoriDodajZivotinjuFormu() throws Exception {
        dzController = new DodajZivotinjuController(new DodajZivotinjuForma());
        dzController.otvoriFormu();
    }
    
    
    
}
