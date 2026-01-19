/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import enums.VrstaOdgovora;
import java.io.Serializable;

/**
 *
 * @author gazda
 */
public class Odgovor implements Serializable {
    private Object parametar;
    private int operacija;
    private String poruka;
    private VrstaOdgovora vrstaOdgovora;

    public Odgovor() {
    }

    public Odgovor(Object parametar, int operacija, String poruka, VrstaOdgovora vrstaOdgovora) {
        this.parametar = parametar;
        this.operacija = operacija;
        this.poruka = poruka;
        this.vrstaOdgovora = vrstaOdgovora;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public VrstaOdgovora getVrstaOdgovora() {
        return vrstaOdgovora;
    }

    public void setVrstaOdgovora(VrstaOdgovora vrstaOdgovora) {
        this.vrstaOdgovora = vrstaOdgovora;
    }
    
}
