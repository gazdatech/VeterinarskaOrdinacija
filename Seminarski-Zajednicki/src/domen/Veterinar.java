/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author gazda
 */
public class Veterinar {
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
    
}
