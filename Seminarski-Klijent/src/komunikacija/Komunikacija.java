/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.PlanRehabilitacije;
import domen.Terapija;
import domen.Tretman;
import domen.Veterinar;
import domen.VrstaZivotinje;
import domen.Zivotinja;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gazda
 */
public class Komunikacija {
    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;
    private Komunikacija() {
        
    }

    public static Komunikacija getInstance() {
        if(instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public void konekcija()  {
        try {
            soket = new Socket("localhost",9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
        } catch (IOException ex) {
            System.out.println("Server nije povezan");
        }
    }

    public Veterinar login(String user, String password) throws Exception {
        Zahtev zahtev = new Zahtev();
        Veterinar v = new Veterinar();
        v.setKorisnickoIme(user);
        v.setLozinka(password);
        zahtev.setOperacija(Operacija.LOGIN); 
        zahtev.setParametar(v);
        posiljalac.posalji(zahtev); 
        Odgovor odgovor = (Odgovor) primalac.primi();

        return (Veterinar) odgovor.getOdgovor();
    }

    public List<Zivotinja> vratiSveZivotinje() throws Exception {
       Zahtev zahtev = new Zahtev(Operacija.VRATI_SVE_ZIVOTINJE,null);
       posiljalac.posalji(zahtev);
       Odgovor odgovor = (Odgovor) primalac.primi();
       return (List<Zivotinja>) odgovor.getOdgovor();
    }

    public List<VrstaZivotinje> vratiSveVrsteZivotinja() throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.VRATI_SVE_VRSTE,null);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        return (List<VrstaZivotinje>) odgovor.getOdgovor();
    }

    public void dodajZivotinju(Zivotinja z) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_ZIVOTINJU, z);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
    }

    public PlanRehabilitacije vratiPlanZaZivotinju(Zivotinja z) {
       ///
        return null;
       ///
    }

   

    public List<Terapija> vratiSveTerapije() throws Exception{
       Zahtev zahtev = new Zahtev(Operacija.VRATI_TERAPIJE,null);
       posiljalac.posalji(zahtev);
       Odgovor odgovor = (Odgovor) primalac.primi();
       return (List<Terapija>) odgovor.getOdgovor();
    }

    public List<Tretman> vratiSveTretmane() {
        return null;
    }

    public void sacuvajPlan(PlanRehabilitacije plan) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.SACUVAJ_PLAN,plan);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
    }

    
    
    
    
}
