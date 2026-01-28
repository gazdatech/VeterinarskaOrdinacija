/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.VrstaZivotinje;
import java.util.List;

/**
 *
 * @author gazda
 */
public class UcitajSveVrsteSO extends ApstraktnaGenerickaOperacija {

    List<VrstaZivotinje> listaVrste;
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        //
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        listaVrste = broker.getAll(objekat, null);
    }

    public List<VrstaZivotinje> getListaVrste() {
        return listaVrste;
    }
    
    
    
}
