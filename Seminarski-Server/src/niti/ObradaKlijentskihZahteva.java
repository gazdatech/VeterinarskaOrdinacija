/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Veterinar;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import static komunikacija.Operacija.LOGIN;
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
                Odgovor odgovor = new Odgovor();
                switch(zahtev.getOperacija()) {
                    case LOGIN:
                        Veterinar v = (Veterinar) zahtev.getParametar();
                        v = Controller.getInstance().login(v);
                        odgovor.setOdgovor(v);
                        if (v == null) {
                            // Samo šaljemo odgovor da je v null (neuspeh)
                            // NE zatvaramo soket i NE prekidamo nit
                            posiljalac.posalji(odgovor);
                            System.out.println("Pokušaj prijave neuspešan. Čekam novi pokušaj...");
                        } else {
                            // Tek ovde, kada je v != null, ispisujemo ko se povezao
                            odgovor.setOdgovor(v);
                            posiljalac.posalji(odgovor);
                            System.out.println("KLIJENT SE POVEZAO: " + v.getIme() + " " + v.getPrezime());
                        }
                        break;
                    default:
                        System.out.println("GRESKA");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
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
