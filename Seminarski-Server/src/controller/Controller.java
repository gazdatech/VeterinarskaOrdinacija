/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.PlanRehabilitacije;
import domen.Terapija;
import domen.Tretman;
import domen.Veterinar;
import domen.VrstaZivotinje;
import domen.Zivotinja;
import java.util.List;
import operacije.DodajTretmanSO;
import operacije.DodajZivotinjuSO;
import operacije.LoginSO;
import operacije.SacuvajPlanSO;
import operacije.UcitajSveTerapijeSO;
import operacije.UcitajSveVrsteSO;
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
        System.out.println("Klasa kontroler veterinar sa id : " + lo.getVeterinar().getVeterinarId());
        return lo.getVeterinar();
    }
    
    public List<Zivotinja> vratiSveZivotinje() throws Exception {
        UcitajSveZivotinjeSO so = new UcitajSveZivotinjeSO();
        so.izvrsi(new Zivotinja(), null);
        return so.getLista();
    }

    public List<VrstaZivotinje> vratiSveVrste() throws Exception {
       UcitajSveVrsteSO so = new UcitajSveVrsteSO();
       so.izvrsi(new VrstaZivotinje(), null);
       return so.getListaVrste();
    }

    public void dodajZivotinju(Zivotinja z) throws Exception {
       DodajZivotinjuSO so = new DodajZivotinjuSO();
       so.izvrsi(z, null);
    }

    public List<Terapija> vratiSveTerapije() throws Exception {
        UcitajSveTerapijeSO so = new UcitajSveTerapijeSO();
        so.izvrsi(new Terapija(), null);
        return so.getLista();
    }

    public void sacuvajPlan(PlanRehabilitacije plan) throws Exception {
        SacuvajPlanSO so = new SacuvajPlanSO();
        so.izvrsi(plan, null);
    }

    
    
}
    