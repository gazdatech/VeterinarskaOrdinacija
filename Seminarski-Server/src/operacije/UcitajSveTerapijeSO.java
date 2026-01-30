/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Terapija;
import java.util.List;

/**
 *
 * @author gazda
 */
public class UcitajSveTerapijeSO extends ApstraktnaGenerickaOperacija {

        private List<Terapija> lista;


    @Override
    protected void preduslovi(Object objekat) throws Exception {
       //////
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
       lista = broker.getAll(objekat, null);
    }

    public List<Terapija> getLista() {
        return lista;
    }
    
    
}
