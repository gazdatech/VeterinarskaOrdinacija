/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
