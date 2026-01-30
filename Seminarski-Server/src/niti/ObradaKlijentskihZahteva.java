/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
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
import komunikacija.Odgovor;
import static komunikacija.Operacija.*;

import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author gazda
 */
public class ObradaKlijentskihZahteva extends Thread {
    Socket soket;
    Posiljalac posiljalac;
    Primalac primalac;
    boolean kraj=false;

    public ObradaKlijentskihZahteva(Socket soket) throws IOException {
        this.soket = soket;
        posiljalac = new Posiljalac(soket);
        primalac = new Primalac(soket);
    }
    
    

    @Override
    public void run() {
        while(!kraj) {
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = new Odgovor(); // Kreiraš prazan odgovor

                switch(zahtev.getOperacija()) {
                    case LOGIN:
                        Veterinar v = (Veterinar) zahtev.getParametar();
                        v = Controller.getInstance().login(v);
                        odgovor.setOdgovor(v);
                        break;
                    case VRATI_SVE_ZIVOTINJE:
                        List<Zivotinja> lista = Controller.getInstance().vratiSveZivotinje();
                        odgovor.setOdgovor(lista);
                        break;
                    case VRATI_SVE_VRSTE:
                        List<VrstaZivotinje> listaVrste = Controller.getInstance().vratiSveVrste();
                        odgovor.setOdgovor(listaVrste);
                        break;
                    case DODAJ_ZIVOTINJU:
                        Zivotinja z = (Zivotinja) zahtev.getParametar();
                        Controller.getInstance().dodajZivotinju(z);
                        odgovor.setOdgovor(z);
                        System.out.println("SERVER PRIMIO: " + z.getIme() + ", " + z.getTezinaKg());
                    case VRATI_TERAPIJE:
                        List<Terapija> listaTerapija = Controller.getInstance().vratiSveTerapije();
                        odgovor.setOdgovor(listaTerapija);
                        break;
                    case SACUVAJ_PLAN:
                        PlanRehabilitacije plan = (PlanRehabilitacije) zahtev.getParametar();
                        Controller.getInstance().sacuvajPlan(plan);
                        odgovor.setOdgovor(plan);
                }
                // KLJUČNO: Samo jedno slanje na samom kraju switch-a
                posiljalac.posalji(odgovor);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void prekini() {
        kraj = true;
        try {
            soket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();
    }
    
    
}
