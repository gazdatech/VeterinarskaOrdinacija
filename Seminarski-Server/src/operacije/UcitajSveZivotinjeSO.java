/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Zivotinja;
import java.util.List;

/**
 *
 * @author gazda
 */
public class UcitajSveZivotinjeSO extends ApstraktnaGenerickaOperacija {

    private List<Zivotinja> lista;
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        /////
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        lista = broker.getAll(objekat, null);
        System.out.println("DEBUG: Broker vratio listu veličine: " + (lista == null ? "NULL" : lista.size()));
    }

    public List<Zivotinja> getLista() {
        return lista;
    }

   
    
    
}
