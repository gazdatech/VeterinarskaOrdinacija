/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author gazda
 */
public class VrstaZivotinje {
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
    
    
}
