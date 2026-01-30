/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.Zivotinja;

/**
 *
 * @author gazda
 */
public class DodajZivotinjuSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Zivotinja)) {
            throw new Exception("Sistem nije mogao da doda pacijenta");
        }
        Zivotinja z = (Zivotinja) objekat;
        if(z.getBrojCipa() == null || z.getVrstaZivotinje().getVrstaId() < 0) {
            throw new Exception("Greska u parametrima");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.add((Zivotinja)objekat);
    }
    
}
