/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gazda
 */
public class VrstaZivotinje implements ApstraktniDomenskiObjekat{

    
    private int vrstaId;
    private String nazivVrste;
    private String latinskiNaziv;
    private String opis;

    public VrstaZivotinje() {
    }

    public VrstaZivotinje(int vrstaId, String nazivVrste, String latinskiNaziv, String opis) {
        this.vrstaId = vrstaId;
        this.nazivVrste = nazivVrste;
        this.latinskiNaziv = latinskiNaziv;
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getVrstaId() {
        return vrstaId;
    }

    public void setVrstaId(int vrstaId) {
        this.vrstaId = vrstaId;
    }

    public String getNazivVrste() {
        return nazivVrste;
    }

    public void setNazivVrste(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }

    public String getLatinskiNaziv() {
        return latinskiNaziv;
    }

    public void setLatinskiNaziv(String latinskiNaziv) {
        this.latinskiNaziv = latinskiNaziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "vrstazivotinje";
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
        return "naziv_vrste";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("'%s'", nazivVrste);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "vrsta_id = " + vrstaId;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        VrstaZivotinje vz = new VrstaZivotinje();
        vz.setVrstaId(rs.getInt("vrsta_id"));
        vz.setNazivVrste(rs.getString("naziv_vrste"));
        return vz;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return String.format("naziv_vrste='%s'", nazivVrste);
    }
    
    
}
