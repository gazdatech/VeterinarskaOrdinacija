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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import modeli.ModelTabeleZivotinja;

/**
 *
 * @author gazda
 */
public class GlavnaFormaController {
    private final GlavnaForma gf;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners(); 
    }
    
    
   public void otvoriFormu() throws Exception {
       Veterinar ulogovani = kordinator.Kordinator.getInstance().getUlogovani();
       pripremiFormu();
       gf.setVisible(true);
       gf.getjLabelUlogovani().setText(ulogovani.getIme() + " " + ulogovani.getPrezime());
   }

    public void pripremiFormu() throws Exception {
        List<Zivotinja> sveZivotinje = Komunikacija.getInstance().vratiSveZivotinje();
        ModelTabeleZivotinja model = new ModelTabeleZivotinja(sveZivotinje);
        gf.getTabelaZivotinja().setModel(model);

    }
    
    

    private void addActionListeners() {
       gf.getBtnDetalji().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              detalji(e);
           }

           private void detalji(ActionEvent e) {
               try {
                   int row = gf.getTabelaZivotinja().getSelectedRow();
                    if(row != -1) {
                        TableModel model = gf.getTabelaZivotinja().getModel();
                        ModelTabeleZivotinja mojModel = (ModelTabeleZivotinja) model;
                        Zivotinja z = mojModel.getSelectedZivotinja(row);
                        Kordinator.getInstance().otvoriDetaljiZivotinjeFormu(z);
                    }else {
                        JOptionPane.showMessageDialog(gf, "GRESKA", "Odaberite red u tabeli", JOptionPane.ERROR_MESSAGE);
                    }
               } catch (Exception ex) {
                   Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       
       gf.getjMenuDodajPlan().addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               dodaj(e);
           }

           private void dodaj(ActionEvent e) {
               try{
                   int row = gf.getTabelaZivotinja().getSelectedRow();
                   if(row == -1) {
                       JOptionPane.showMessageDialog(gf, "Prvo selektujte životinju iz tabele za koju želite da kreirate plan.");
                       return;
                   }
                   ModelTabeleZivotinja mtz = (ModelTabeleZivotinja) gf.getTabelaZivotinja().getModel();
                   Zivotinja z = mtz.getSelectedZivotinja(row);
                   Kordinator.getInstance().otvoriNoviPlanFormu(z);
               }catch (Exception ex) {
                   Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
       });
       
      
       
    }

    public GlavnaForma getGf() {
        return gf;
    }
    
   

   
    
}
