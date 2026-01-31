/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import enums.StatusPlanaEnum;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gazda
 */
public class PlanRehabilitacije implements ApstraktniDomenskiObjekat{
    private int planId;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private String opisPlana;
    private Veterinar veterinar;
    private Zivotinja zivotinja;
    private StatusPlanaEnum status;
    private List<Tretman> tretmani;

    public PlanRehabilitacije() {
        this.status = StatusPlanaEnum.U_TOKU;
    }

    public PlanRehabilitacije(int planId, Date datumPocetka, Date datumZavrsetka, String opisPlana, Veterinar veterinar, Zivotinja zivotinja, StatusPlanaEnum status, List<Tretman> tretmani) {
        this.planId = planId;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.opisPlana = opisPlana;
        this.veterinar = veterinar;
        this.zivotinja = zivotinja;
        this.status = status;
        this.tretmani = tretmani;
    }

    

    public StatusPlanaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPlanaEnum status) {
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

    @Override
    public String vratiNazivTabele() {
        return "planrehabilitacije";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(vratiObjekatIzRs(rs));
        }
        return lista;
    }

        @Override
    public String vratiKoloneZaUbacivanje() {
        // Ovde navodimo kolone bez primarnog ključa (ako je Auto Increment)
        return "datumPocetka, datumZavrsetka, opisPlana, veterinarId, zivotinjaId, status";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
 
        long time = (this.datumPocetka != null) ? this.datumPocetka.getTime() : System.currentTimeMillis();
        java.sql.Date sqlDatum = new java.sql.Date(time);

        int vId = (this.veterinar != null) ? this.veterinar.getVeterinarId() : 0;
        int zId = (this.zivotinja != null) ? this.zivotinja.getZivotinjaId() : 0;
        
        String statusString = (status != null) ? status.toString() : "U_TOKU";

        return String.format("'%s', %s, '%s', %d, %d, '%s'", 
                sqlDatum, 
                (datumZavrsetka != null) ? "'" + new java.sql.Date(datumZavrsetka.getTime()) + "'" : "NULL", 
                opisPlana, vId, zId, statusString);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "planId = " + planId;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        PlanRehabilitacije pr = new PlanRehabilitacije();
        pr.setPlanId(rs.getInt("planId"));
        pr.setDatumPocetka(new java.util.Date(rs.getDate("datumPocetka").getTime()));
        pr.setDatumZavrsetka(new java.util.Date(rs.getDate("datumZavrsetka").getTime()));
        pr.setOpisPlana(rs.getString("opisPlana"));

        // Kreiramo "ljuske" objekata sa ID-evima
        Veterinar v = new Veterinar();
        v.setVeterinarId(rs.getInt("veterinarId"));
        pr.setVeterinar(v);

        Zivotinja z = new Zivotinja();
        z.setZivotinjaId(rs.getInt("zivotinjaId"));
        pr.setZivotinja(z);

        // Mapiranje Enuma iz Stringa
        pr.setStatus(StatusPlanaEnum.valueOf(rs.getString("status")));

        // Napomena: Lista tretmana ostaje prazna ovde! 
        // Ona se puni u posebnom koraku u kontroleru/servisu pozivom za tabelu Tretman.

        return pr;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return String.format("datumPocetka='%s', datumZavrsetka='%s', opisPlana='%s', "
                + "veterinarId=%d, zivotinjaId=%d, status='%s'", 
                new java.sql.Date(datumPocetka.getTime()), 
                new java.sql.Date(datumZavrsetka.getTime()), 
                opisPlana, 
                veterinar.getVeterinarId(), 
                zivotinja.getZivotinjaId(), 
                status.toString());
    }

    
    
    
}
