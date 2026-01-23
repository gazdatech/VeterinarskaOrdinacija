/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class IstorijaOporavka implements ApstraktniDomenskiObjekat {
    private int istorijaId;
    private Zivotinja zivotinja;
    private Date datumZapisa;
    private String opisStanja;
    private boolean zavrsenOporavak;

    public IstorijaOporavka() {
    }

    public IstorijaOporavka(int istorijaId, Zivotinja zivotinja, Date datumZapisa, String opisStanja, boolean zavrsenOporavak) {
        this.istorijaId = istorijaId;
        this.zivotinja = zivotinja;
        this.datumZapisa = datumZapisa;
        this.opisStanja = opisStanja;
        this.zavrsenOporavak = zavrsenOporavak;
    }

    public Date getDatumZapisa() {
        return datumZapisa;
    }

    public void setDatumZapisa(Date datumZapisa) {
        this.datumZapisa = datumZapisa;
    }
    
    public void setDatumOporavka(Date datumZapisa) {
        this.datumZapisa = datumZapisa;
    }

    public Zivotinja getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(Zivotinja zivotinja) {
        this.zivotinja = zivotinja;
    }

    public int getIstorijaId() {
        return istorijaId;
    }

    public void setIstorijaId(int istorijaId) {
        this.istorijaId = istorijaId;
    }

    public String getOpisStanja() {
        return opisStanja;
    }

    public void setOpisStanja(String opisStanja) {
        this.opisStanja = opisStanja;
    }

    public boolean isZavrsenOporavak() {
        return zavrsenOporavak;
    }

    public void setZavrsenOporavak(boolean zavrsenOporavak) {
        this.zavrsenOporavak = zavrsenOporavak;
    }

    @Override
    public String vratiNazivTabele() {
        return "istorijaoporavka";
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
        return "zivotinjaId, datumZapisa, opisStanja, zavrsenOporavak";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("%d, '%s', '%s', %b", 
            zivotinja.getZivotinjaId(), 
            new java.sql.Date(datumZapisa.getTime()), opisStanja, zavrsenOporavak); 
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "istorijaId = " + istorijaId;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        IstorijaOporavka io = new IstorijaOporavka();
        io.setIstorijaId(rs.getInt("istorijaId"));
        Zivotinja z = new Zivotinja();
        z.setZivotinjaId(rs.getInt("zivotinjaId"));
        io.setZivotinja(z);
        io.setDatumZapisa(new java.util.Date(rs.getDate("datumZapisa").getTime()));
        io.setOpisStanja(rs.getString("opisStanja"));
        io.setZavrsenOporavak(rs.getBoolean("zavrsenOporavak"));
        return io;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return String.format("zivotinjaId=%d, datumZapisa='%s', opisStanja='%s', zavrsenOporavak=%b",zivotinja.getZivotinjaId(), new java.sql.Date(datumZapisa.getTime()), opisStanja, zavrsenOporavak);
    }
    
    
    
}
