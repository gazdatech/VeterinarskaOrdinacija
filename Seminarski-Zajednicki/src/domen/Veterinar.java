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
public class Veterinar implements ApstraktniDomenskiObjekat{
    private int veterinarId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String email;
    private String brojTelefona;
    private StepenObrazovanja stepenObrazovanja;

    public Veterinar() {
    }

    public Veterinar(int veterinarId, String ime, String prezime, String korisnickoIme, String lozinka, String email, String brojTelefona, StepenObrazovanja stepenObrazovanja) {
        this.veterinarId = veterinarId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.stepenObrazovanja = stepenObrazovanja;
    }

    public StepenObrazovanja getStepenObrazovanja() {
        return stepenObrazovanja;
    }

    public void setStepenObrazovanja(StepenObrazovanja stepenObrazovanja) {
        this.stepenObrazovanja = stepenObrazovanja;
    }

    public int getVeterinarId() {
        return veterinarId;
    }

    public void setVeterinarId(int veterinarId) {
        this.veterinarId = veterinarId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String vratiNazivTabele() {
        return "veterinar";
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
        return "ime, prezime, specijalizacija, stepenId";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("'%s', '%s', %d", 
                ime, 
                prezime, 
                stepenObrazovanja.getStepenId());
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "veterinarId = " + veterinarId;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        Veterinar v = new Veterinar();
        v.setVeterinarId(rs.getInt("veterinarId"));
        v.setIme(rs.getString("ime"));
        v.setPrezime(rs.getString("prezime"));

        // Kreiramo "šuplji" objekat stepena obrazovanja sa ID-em iz baze
        StepenObrazovanja so = new StepenObrazovanja();
        so.setStepenId(rs.getInt("stepenId"));
        v.setStepenObrazovanja(so);

        return v;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return String.format("ime='%s', prezime='%s', stepenId=%d", 
                ime, 
                prezime, 
                stepenObrazovanja.getStepenId());
    }
    
}
