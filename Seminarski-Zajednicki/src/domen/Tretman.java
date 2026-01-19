/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domen;

import java.util.Date;

/**
 *
 * @author gazda
 */
public class Tretman {
    private int tretmanId;
    private PlanRehabilitacije planRehabilitacije;
    private Terapija terapija;
    private Date datumPocetka;
    private String doza;
    private String napomena;

    public Tretman() {
    }

    public Tretman(int tretmanId, PlanRehabilitacije planRehabilitacije, Terapija terapija, Date datumPocetka, String doza, String napomena) {
        this.tretmanId = tretmanId;
        this.planRehabilitacije = planRehabilitacije;
        this.terapija = terapija;
        this.datumPocetka = datumPocetka;
        this.doza = doza;
        this.napomena = napomena;
    }

    public int getTretmanId() {
        return tretmanId;
    }

    public void setTretmanId(int tretmanId) {
        this.tretmanId = tretmanId;
    }

    public PlanRehabilitacije getPlanRehabilitacije() {
        return planRehabilitacije;
    }

    public void setPlanRehabilitacije(PlanRehabilitacije planRehabilitacije) {
        this.planRehabilitacije = planRehabilitacije;
    }

    public Terapija getTerapija() {
        return terapija;
    }

    public void setTerapija(Terapija terapija) {
        this.terapija = terapija;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public String getDoza() {
        return doza;
    }

    public void setDoza(String doza) {
        this.doza = doza;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    
    
}
