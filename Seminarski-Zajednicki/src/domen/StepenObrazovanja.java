/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author gazda
 */
public class StepenObrazovanja {
    private StepenObrazovanja stepenObrazovanjaId;
    private String nivo;
    private String nazivStepena;

    public StepenObrazovanja() {
    }

    public StepenObrazovanja(StepenObrazovanja stepenObrazovanjaId, String nivo, String nazivStepena) {
        this.stepenObrazovanjaId = stepenObrazovanjaId;
        this.nivo = nivo;
        this.nazivStepena = nazivStepena;
    }

    public StepenObrazovanja getStepenObrazovanjaId() {
        return stepenObrazovanjaId;
    }

    public void setStepenObrazovanjaId(StepenObrazovanja stepenObrazovanjaId) {
        this.stepenObrazovanjaId = stepenObrazovanjaId;
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
    
}
