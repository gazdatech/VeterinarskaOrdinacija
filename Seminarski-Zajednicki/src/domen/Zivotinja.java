/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import enums.Pol;

/**
 *
 * @author gazda
 */
public class Zivotinja {
    private int zivotinjaId;
    private String ime;
    private Pol pol;
    private int starost;
    private double tezinaKg;
    private VrstaZivotinje vrstaZivotinje;

    public Zivotinja() {
    }

    public Zivotinja(int zivotinjaId, String ime, Pol pol, int starost, double tezinaKg, VrstaZivotinje vrstaZivotinje) {
        this.zivotinjaId = zivotinjaId;
        this.ime = ime;
        this.pol = pol;
        this.starost = starost;
        this.tezinaKg = tezinaKg;
        this.vrstaZivotinje = vrstaZivotinje;
    }

    public VrstaZivotinje getVrstaZivotinje() {
        return vrstaZivotinje;
    }

    public void setVrstaZivotinje(VrstaZivotinje vrstaZivotinje) {
        this.vrstaZivotinje = vrstaZivotinje;
    }

    public int getZivotinjaId() {
        return zivotinjaId;
    }

    public void setZivotinjaId(int zivotinjaId) {
        this.zivotinjaId = zivotinjaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public double getTezinaKg() {
        return tezinaKg;
    }

    public void setTezinaKg(double tezinaKg) {
        this.tezinaKg = tezinaKg;
    }
    
    
}
