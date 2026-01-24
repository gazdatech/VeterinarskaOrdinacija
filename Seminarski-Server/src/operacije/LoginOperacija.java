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
public class LoginOperacija extends ApstraktnaGenerickaOperacija {
    
    Veterinar veterinar;

    public Veterinar getVeterinar() {
        return veterinar;
    }

    public void setVeterinar(Veterinar veterinar) {
        this.veterinar = veterinar;
    }
    
    

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        List<Veterinar> sviVeterinari = broker.getAll(objekat, null);
        System.out.println("Login operacija SO" +sviVeterinari);
        for(Veterinar v : sviVeterinari) {
            if(v.equals(objekat)) {
                veterinar = v;
                return;
            }
        }
        veterinar = null;
    }
    
}
