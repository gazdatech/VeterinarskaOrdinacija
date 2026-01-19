/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import enums.StatusPlana;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gazda
 */
public class PlanRehabilitacije {
    private int planId;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private String opisPlana;
    private Veterinar veterinar;
    private Zivotinja zivotinja;
    private StatusPlana status;
    private List<Tretman> tretmani;

    public PlanRehabilitacije() {
    }

    public PlanRehabilitacije(int planId, Date datumPocetka, Date datumZavrsetka, String opisPlana, Veterinar veterinar, Zivotinja zivotinja, StatusPlana status, List<Tretman> tretmani) {
        this.planId = planId;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.opisPlana = opisPlana;
        this.veterinar = veterinar;
        this.zivotinja = zivotinja;
        this.status = status;
        this.tretmani = tretmani;
    }

    

    public StatusPlana getStatus() {
        return status;
    }

    public void setStatus(StatusPlana status) {
        this.status = status;
    }

    

    public Zivotinja getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(Zivotinja zivotinja) {
        this.zivotinja = zivotinja;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public String getOpisPlana() {
        return opisPlana;
    }

    public void setOpisPlana(String opisPlana) {
        this.opisPlana = opisPlana;
    }

    public Veterinar getVeterinar() {
        return veterinar;
    }

    public void setVeterinar(Veterinar veterinar) {
        this.veterinar = veterinar;
    }

    public List<Tretman> getTretmani() {
        return tretmani;
    }

    public void setTretmani(List<Tretman> tretmani) {
        this.tretmani = tretmani;
    }

    
    
    
}
