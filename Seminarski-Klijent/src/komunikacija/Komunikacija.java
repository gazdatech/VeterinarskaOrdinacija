/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Veterinar;
import java.io.IOException;
import java.net.Socket;
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

    public Veterinar login(String user, String password) throws IOException {
        Veterinar v = new Veterinar();
        v.setKorisnickoIme(user);
        v.setLozinka(password);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, v);
        
        posiljalac.posalji(v);
        
        try {
            Odgovor odg = (Odgovor) primalac.primi();
            v = (Veterinar) odg.getOdgovor();
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
    
    
    
}
