/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Veterinar;
import java.util.List;


/**
 *
 * @author gazda
 */
public class LoginSO extends ApstraktnaGenerickaOperacija {
    
    Veterinar veterinar;

    public Veterinar getVeterinar() {
        return veterinar;
    }

    public void setVeterinar(Veterinar veterinar) {
        this.veterinar = veterinar;
    }
    
    

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if (!(objekat instanceof Veterinar)) {
        throw new Exception("Sistem nije poslao validne podatke za veterinara!");
    }
    }

    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        Veterinar klijentVeterinar = (Veterinar) objekat; // Kastujemo ulazni objekat
        List<Veterinar> sviVeterinari = broker.getAll(objekat, null);

        for(Veterinar v : sviVeterinari) {
    // Provera da li su polja u bazi slucajno null da ne bi opet puklo
            if(v.getKorisnickoIme() != null && v.getLozinka() != null) {
                if(v.getKorisnickoIme().equals(klijentVeterinar.getKorisnickoIme()) && 
                   v.getLozinka().equals(klijentVeterinar.getLozinka())) {
                    this.veterinar = v;
                    return;
                }
            }
        }
        this.veterinar = null;
    }
    
}
