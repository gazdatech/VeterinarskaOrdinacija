/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author gazda
 */
public class Posiljalac {
    private Socket soket;
    private ObjectOutputStream izlaz;

    public Posiljalac(Socket socket) throws IOException {
        this.soket = socket;
        this.izlaz = new ObjectOutputStream(socket.getOutputStream());
    }

    public void posalji(Object object) throws IOException {
        izlaz.writeObject(object);
       // System.out.println("Poruka poslata: " + object);
        izlaz.flush();
    }

    public void zatvori() throws IOException {
        izlaz.close();
    }
}
