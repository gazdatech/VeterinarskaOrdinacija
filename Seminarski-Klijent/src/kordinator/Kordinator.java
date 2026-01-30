/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import domen.Veterinar;
import domen.Zivotinja;
import forme.DetaljiZivotinjeForma;
import forme.DodajZivotinjuForma;
import forme.GlavnaForma;
import forme.LoginForm;
import forme.NoviPlanRehForma;
import kontroleri.DetaljiZivotinjeController;
import kontroleri.DodajZivotinjuController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PlanController;

/**
 *
 * @author gazda
 */
public class Kordinator {
    private static Kordinator instance;
    private Veterinar ulogovani;
    private Zivotinja zivotinja;
    private LoginController loginController;
    private GlavnaFormaController gfController;
    private DodajZivotinjuController dzController;
    private DetaljiZivotinjeController detaljiController;
    private PlanController planController;
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

    public Zivotinja getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(Zivotinja zivotinja) {
        this.zivotinja = zivotinja;
    }
    
    

    public void otvoriGlavnuFormu() throws Exception {
        gfController = new GlavnaFormaController(new GlavnaForma());
        gfController.otvoriFormu();
    }
    
    public void otvoriDodajZivotinjuFormu() throws Exception {
        dzController = new DodajZivotinjuController(new DodajZivotinjuForma());
        dzController.otvoriFormu();
    }

    public void osveziTabeluZivotinja() throws Exception {
        gfController.pripremiFormu();
    }
    
    public void otvoriDetaljiZivotinjeFormu(Zivotinja z) throws Exception {
        detaljiController = new DetaljiZivotinjeController(new DetaljiZivotinjeForma());
        detaljiController.otvoriFormu();
    }

    public void otvoriNoviPlanFormu(Zivotinja z) throws Exception {
       planController = new PlanController(new NoviPlanRehForma(gfController.getGf(), true));
       planController.otvoriFormu(z);
       
    }
    
    
    
}
