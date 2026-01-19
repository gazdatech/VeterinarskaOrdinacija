/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.Date;

/**
 *
 * @author gazda
 */
public class IstorijaOporavka {
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
    
    
    
}
