/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gazda
 */
public class Tretman implements ApstraktniDomenskiObjekat{
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

    @Override
    public String vratiNazivTabele() {
        return "tretman";
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
        // Ovde ubacujemo i planId jer tretman ne može postojati bez plana
        return "planId, terapijaId, datumPocetka, doza, napomena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("%d, %d, '%s', '%s', '%s'", 
            planRehabilitacije.getPlanId(), 
            terapija.getTerapijaId(), 
            new java.sql.Date(datumPocetka.getTime()), 
            doza, 
            napomena);
    }

    @Override
    public String vratiPrimarniKljuc() {
        // Pošto je tretman stavka, primarni ključ je obično kombinacija ID-ja tretmana i ID-ja plana
        return "tretmanId = " + tretmanId + " AND planId = " + planRehabilitacije.getPlanId();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        Tretman t = new Tretman();
        t.setTretmanId(rs.getInt("tretmanId"));

        // Povezivanje sa planom (samo ID)
        PlanRehabilitacije pr = new PlanRehabilitacije();
        pr.setPlanId(rs.getInt("planId"));
        t.setPlanRehabilitacije(pr);

        // Povezivanje sa terapijom (samo ID)
        Terapija ter = new Terapija();
        ter.setTerapijaId(rs.getInt("terapijaId"));
        t.setTerapija(ter);

        t.setDatumPocetka(new java.util.Date(rs.getDate("datumPocetka").getTime()));
        t.setDoza(rs.getString("doza"));
        t.setNapomena(rs.getString("napomena"));

        return t;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return String.format("terapijaId=%d, doza='%s', napomena='%s'", 
                terapija.getTerapijaId(),  
                doza, 
                napomena);
    }
    
    
}
