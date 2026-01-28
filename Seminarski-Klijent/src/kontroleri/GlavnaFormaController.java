/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Veterinar;
import domen.Zivotinja;
import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import komunikacija.Komunikacija;
import modeli.ModelTabeleZivotinja;

/**
 *
 * @author gazda
 */
public class GlavnaFormaController {
    private final GlavnaForma gf;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
       // addActionListeners(); 
    }
    
    
   public void otvoriFormu() throws Exception {
       Veterinar ulogovani = kordinator.Kordinator.getInstance().getUlogovani();
       pripremiFormu();
       gf.setVisible(true);
       gf.getjLabelUlogovani().setText(ulogovani.getIme() + " " + ulogovani.getPrezime());
   }

    private void pripremiFormu() throws Exception {
        List<Zivotinja> sveZivotinje = Komunikacija.getInstance().vratiSveZivotinje();
        ModelTabeleZivotinja model = new ModelTabeleZivotinja(sveZivotinje);
        gf.getTabelaZivotinja().setModel(model);

    }
    
   

   // private void addActionListeners() {
        //// 
   // }
    
}
