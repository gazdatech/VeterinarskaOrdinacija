/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import enums.TipTerapijeEnum;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gazda
 */
public class Terapija implements ApstraktniDomenskiObjekat{
    private int terapijaId;
    private String nazivTerapije;
    private TipTerapijeEnum tipTerapije;
    private String opis;
    private int trajanje;
    private String ucestalost;

    public Terapija() {
    }

    public Terapija(int terapijaId, String nazivTerapije, TipTerapijeEnum tipTerapije, String opis, int trajanje, String ucestalost) {
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

    public TipTerapijeEnum getTipTerapije() {
        return tipTerapije;
    }

    public void setTipTerapije(TipTerapijeEnum tipTerapije) {
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

    @Override
    public String vratiNazivTabele() {
        return "terapija";
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
        return "nazivTerapije, tipTerapije, opis, trajanje, ucestalost";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("'%s', '%s', '%s', %d, '%s'", 
                nazivTerapije, 
                tipTerapije.toString(), 
                opis, 
                trajanje, 
                ucestalost);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "terapijaId = " + terapijaId;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        Terapija t = new Terapija();
        t.setTerapijaId(rs.getInt("terapijaId"));
        t.setNazivTerapije(rs.getString("nazivTerapije"));

        // Konverzija Stringa iz baze nazad u Enum
        String tipStr = rs.getString("tipTerapije");
        if (tipStr != null) {
            t.setTipTerapije(TipTerapijeEnum.valueOf(tipStr));
        }

        t.setOpis(rs.getString("opis"));
        t.setTrajanje(rs.getInt("trajanje"));
        t.setUcestalost(rs.getString("ucestalost"));

        return t;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return String.format("nazivTerapije='%s', tipTerapije='%s', opis='%s', trajanje=%d, ucestalost='%s'", 
                nazivTerapije, 
                tipTerapije.toString(), 
                opis, 
                trajanje, 
                ucestalost);
    }

    @Override
    public String toString() {
        return nazivTerapije;
    }
    
    
    
    
}
