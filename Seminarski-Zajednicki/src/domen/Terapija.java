/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import enums.TipTerapije;

/**
 *
 * @author gazda
 */
public class Terapija {
    private int terapijaId;
    private String nazivTerapije;
    private TipTerapije tipTerapije;
    private String opis;
    private int trajanje;
    private String ucestalost;

    public Terapija() {
    }

    public Terapija(int terapijaId, String nazivTerapije, TipTerapije tipTerapije, String opis, int trajanje, String ucestalost) {
        this.terapijaId = terapijaId;
        this.nazivTerapije = nazivTerapije;
        this.tipTerapije = tipTerapije;
        this.opis = opis;
        this.trajanje = trajanje;
        this.ucestalost = ucestalost;
    }

    public String getUcestalost() {
        return ucestalost;
    }

    public void setUcestalost(String ucestalost) {
        this.ucestalost = ucestalost;
    }

    public int getTerapijaId() {
        return terapijaId;
    }

    public void setTerapijaId(int terapijaId) {
        this.terapijaId = terapijaId;
    }

    public String getNazivTerapije() {
        return nazivTerapije;
    }

    public void setNazivTerapije(String nazivTerapije) {
        this.nazivTerapije = nazivTerapije;
    }

    public TipTerapije getTipTerapije() {
        return tipTerapije;
    }

    public void setTipTerapije(TipTerapije tipTerapije) {
        this.tipTerapije = tipTerapije;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }
    
    
}
