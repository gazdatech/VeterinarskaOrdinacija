/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import enums.Pol;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gazda
 */
public class Zivotinja implements ApstraktniDomenskiObjekat{
    private int zivotinjaId;
    private String ime;
    private Pol pol;
    private int starost;
    private double tezinaKg;
    private String brojCipa;
    private VrstaZivotinje vrstaZivotinje;

    public Zivotinja() {
    }

    public Zivotinja(int zivotinjaId, String ime, Pol pol, int starost, double tezinaKg, String brojCipa, VrstaZivotinje vrstaZivotinje) {
        this.zivotinjaId = zivotinjaId;
        this.ime = ime;
        this.pol = pol;
        this.starost = starost;
        this.tezinaKg = tezinaKg;
        this.brojCipa = brojCipa;
        this.vrstaZivotinje = vrstaZivotinje;
    }

    
    public VrstaZivotinje getVrstaZivotinje() {
        return vrstaZivotinje;
    }

    public void setVrstaZivotinje(VrstaZivotinje vrstaZivotinje) {
        this.vrstaZivotinje = vrstaZivotinje;
    }

    public int getZivotinjaId() {
        return zivotinjaId;
    }

    public void setZivotinjaId(int zivotinjaId) {
        this.zivotinjaId = zivotinjaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public double getTezinaKg() {
        return tezinaKg;
    }

    public void setTezinaKg(double tezinaKg) {
        this.tezinaKg = tezinaKg;
    }

    public void setbrojCipa(String brojCipa) {
        this.brojCipa = brojCipa;
    }

    public String getBrojCipa() {
        return brojCipa;
    }

    
    @Override
    public String vratiNazivTabele() {
        return "zivotinja";
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
        return "ime, pol, starost, tezinaKg, brojCipa, vrstaZivotinjeId";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', " +
               "'" + pol.toString() + "', " +
               starost + ", " +
               tezinaKg + ", " +
               "'" + brojCipa + "', " +
               vrstaZivotinje.getVrstaId();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zivotinjaId=" + zivotinjaId;
    }

     @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        Zivotinja z = new Zivotinja();

        z.setZivotinjaId(rs.getInt("zivotinjaId"));
        z.setIme(rs.getString("ime"));
        z.setPol(Pol.valueOf(rs.getString("pol")));
        z.setStarost(rs.getInt("starost"));
        z.setTezinaKg(rs.getDouble("tezinaKg"));
        z.setbrojCipa(rs.getString("brojCipa"));

        VrstaZivotinje vz = new VrstaZivotinje();
        vz.setVrstaId(rs.getInt("vrstaZivotinjeId"));
        vz.setNazivVrste(rs.getString("naziv_vrste"));
        z.setVrstaZivotinje(vz);

        return z;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
         return "'" + ime + "', " +
               "'" + pol + "', " +
               starost + ", " +
               tezinaKg + ", " +
               "'" + brojCipa + "', " +
               vrstaZivotinje.getVrstaId(); // Pazi na redosled kolona u tabeli!
    }
    
    
    
}
