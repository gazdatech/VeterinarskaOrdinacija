/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Veterinar;
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
        // 1. Kreiraš zahtev
        Zahtev zahtev = new Zahtev();
        Veterinar v = new Veterinar();
        v.setKorisnickoIme(user);
        v.setLozinka(password);
        // 2. Postaviš operaciju (proveri da li se enum zove LOGIN)
        zahtev.setOperacija(Operacija.LOGIN); 

        // 3. Ubaciš veterinara kao parametar zahteva
        zahtev.setParametar(v);

        // 4. Šalješ ZAHTEV (ovo je ključno, pre si slao samo 'v')
        posiljalac.posalji(zahtev); 

        // 5. Primis odgovor od servera
        // Ovde moraš da primiš Odgovor jer tvoj server šalje Odgovor
        Odgovor odgovor = (Odgovor) primalac.primi();

        // 6. Iz odgovora izvlačiš rezultat i kastuješ ga nazad u Veterinar
        return (Veterinar) odgovor.getOdgovor();
    }

    public List<Zivotinja> vratiSveZivotinje() throws Exception {
       Zahtev zahtev = new Zahtev(Operacija.VRATI_SVE_ZIVOTINJE,null);
       posiljalac.posalji(zahtev);
       Odgovor odgovor = (Odgovor) primalac.primi();
       return (List<Zivotinja>) odgovor.getOdgovor();
    }
    
    
    
}
