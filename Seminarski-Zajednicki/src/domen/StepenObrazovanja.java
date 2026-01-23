/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import enums.StepenObrazovanjaEnum;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gazda
 */
public class StepenObrazovanja implements ApstraktniDomenskiObjekat{
    private int stepenId;
    private StepenObrazovanjaEnum stepenObrazovanja;
    private String nivo;
    private String nazivStepena;

    public StepenObrazovanja() {
    }

    public StepenObrazovanja(int stepenId, StepenObrazovanjaEnum stepenObrazovanja, String nivo, String nazivStepena) {
        this.stepenId = stepenId;
        this.stepenObrazovanja = stepenObrazovanja;
        this.nivo = nivo;
        this.nazivStepena = nazivStepena;
    }

    public int getStepenId() {
        return stepenId;
    }

    public void setStepenId(int stepenId) {
        this.stepenId = stepenId;
    }

    public StepenObrazovanjaEnum getStepenObrazovanja() {
        return stepenObrazovanja;
    }

    public void setStepenObrazovanja(StepenObrazovanjaEnum stepenObrazovanja) {
        this.stepenObrazovanja = stepenObrazovanja;
    }

    
    
    public StepenObrazovanjaEnum getStepenObrazovanjaId() {
        return stepenObrazovanja;
    }

    public void setStepenObrazovanjaId(StepenObrazovanjaEnum stepenObrazovanja) {
        this.stepenObrazovanja = stepenObrazovanja;
    }

    

    public String getNazivStepena() {
        return nazivStepena;
    }

    public void setNazivStepena(String nazivStepena) {
        this.nazivStepena = nazivStepena;
    }

    

    public String getNivo() {
        return nivo;
    }

    public void setNivo(String nivo) {
        this.nivo = nivo;
    }

    @Override
    public String vratiNazivTabele() {
        return "stepenobrazovanja";
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
         // Obično se kod šifrarnika ubacuje samo naziv, dok se ID generiše sam
         return "nazivStepena";
     }

     @Override
     public String vratiVrednostiZaUbacivanje() {
         return String.format("'%s'", nazivStepena);
     }

     @Override
     public String vratiPrimarniKljuc() {
         return "stepenId = " + stepenId;
     }

     @Override
     public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
         StepenObrazovanja so = new StepenObrazovanja();
         so.setStepenId(rs.getInt("stepenId"));
         so.setNazivStepena(rs.getString("nazivStepena"));
         return so;
     }

     @Override
     public String vratiVrednostiZaIzmenu() {
         return String.format("nazivStepena='%s'", nazivStepena);
     }
    
}
