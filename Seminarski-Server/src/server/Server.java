/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author gazda
 */
public class Server extends Thread {
    
    boolean kraj = false;
    ServerSocket serverSoket;
    List<ObradaKlijentskihZahteva> klijenti;

    public Server() {
        klijenti = new LinkedList<>();
    }

    public void run() {
        try {
            serverSoket = new ServerSocket(9000);
            System.out.println("Server je pokrenut i ceka klijente...");
            while(!kraj) {
                Socket s = serverSoket.accept();
                // Umesto "Klijent je povezan", ispiši nešto neutralnije
                System.out.println("Novi klijent na portu " + s.getPort() + " pokusava da se poveze...");

                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                klijenti.add(okz);
                okz.start();
            }
        } catch(IOException ex) {
            if (!kraj) ex.printStackTrace();
        }
    }
    
    
    
  
    
    public void zaustaviServer() {
        kraj = true;
        try {
            for (ObradaKlijentskihZahteva k : klijenti) {
                k.prekini();
            }
            serverSoket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
