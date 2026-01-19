/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


/**
 *
 * @author gazda
 */
public class Primalac {
    private Socket soket;
    private ObjectInputStream ulaz;

    public Primalac(Socket soket) throws IOException {
        this.soket = soket;
        this.ulaz = new ObjectInputStream(soket.getInputStream());
    }
    
    public Object primi() throws Exception{
        return ulaz.readObject();
    }
    public void zatvori() throws IOException{
        ulaz.close();
    }
}
