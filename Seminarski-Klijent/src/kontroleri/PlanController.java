/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import com.sun.java.accessibility.util.AWTEventMonitor;
import domen.PlanRehabilitacije;
import domen.Terapija;
import domen.Tretman;
import domen.Veterinar;
import domen.Zivotinja;
import forme.DetaljiZivotinjeForma;
import forme.NoviPlanRehForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import kordinator.Kordinator;
import modeli.ModelTabeleTretman;
import modeli.ModelTabeleZivotinja;

/**
 *
 * @author gazda
 */
public class PlanController {
    private final NoviPlanRehForma noviF;
    private Zivotinja selektovanaZivotinja;

    public PlanController(NoviPlanRehForma noviF) {
        this.noviF = noviF;
        addActionListeners(); 
    }
    
    
    
    public void otvoriFormu(Zivotinja z) throws Exception {
        this.selektovanaZivotinja = z;
        noviF.getLblZivotinja().setText(z.getIme() + " " + z.getBrojCipa());
        noviF.getTxtDatum().setText(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
        noviF.getTxtDatum().setEditable(false);
        pripremiFormu();
        noviF.setVisible(true);
        
    }

    private void addActionListeners() {
      noviF.getBtnSacuvaj().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              sacuvaj(e);
          }

          private void sacuvaj(ActionEvent e) {
                try {
                    PlanRehabilitacije plan = new PlanRehabilitacije();

                    // Uzmi ulogovanog veterinara
                    Veterinar ulogovani = Kordinator.getInstance().getUlogovani();

                    // TEST: Proveri u konzoli klijenta pre slanja
                    if (ulogovani == null) {
                        JOptionPane.showMessageDialog(noviF, "Greška: Sesija je istekla ili veterinar nije ulogovan!");
                        return;
                    }
                    System.out.println("Klijent salje plan. Veterinar ID: " + ulogovani.getVeterinarId());

                    plan.setVeterinar(ulogovani); // Ovo postavlja ID koji ti fali
                    plan.setZivotinja(selektovanaZivotinja);
                    plan.setDatumPocetka(new Date());
                    plan.setOpisPlana(noviF.getAreaNap().getText());

                    ModelTabeleTretman model = (ModelTabeleTretman) noviF.getTabelaTretmana().getModel();
                    plan.setTretmani(model.getLista());

                    Komunikacija.getInstance().sacuvajPlan(plan);

                    JOptionPane.showMessageDialog(noviF, "Sistem je uspešno zapamtio plan!");
                    noviF.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(noviF, "Greska: " + ex.getMessage());
                }
            }
      });
      
      noviF.getBtnDodajT().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              dodaj(e);
          }

          private void dodaj(ActionEvent e) {
                try {
                    // 1. Kreiramo objekat u memoriji
                    Tretman t = new Tretman();
                    t.setDoza(noviF.getTxtDoza().getText());
                    t.setNapomena(noviF.getAreaNap().getText());
                    t.setTerapija((Terapija) noviF.getCmbTipT().getSelectedItem());

                    // Postavi datum ovde na klijentu da bi model imao šta da prikaže
                    t.setDatumPocetka(new java.util.Date()); 

                    // 2. Dodajemo ga SAMO u model tabele (lokalno)
                    ModelTabeleTretman model = (ModelTabeleTretman) noviF.getTabelaTretmana().getModel();
                    model.dodajTretman(t);

                    // 3. Obavestimo korisnika (opciono, može i bez ovoga jer se vidi u tabeli)
                    // JOptionPane.showMessageDialog(noviF, "Tretman dodat u listu.");

                    // 4. Očisti polja za sledeći unos
                    noviF.getTxtDoza().setText("");
                    noviF.getAreaNap().setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(noviF, "Greška pri dodavanju u tabelu: " + ex.getMessage());
                }
            }
        });
    }

    private void pripremiFormu() throws Exception {
        noviF.getTabelaTretmana().setModel(new ModelTabeleTretman());
       List<Terapija> listTerapija = Komunikacija.getInstance().vratiSveTerapije();
       noviF.getCmbTipT().removeAllItems();
        for (Terapija t : listTerapija) {
            noviF.getCmbTipT().addItem(t);
        }
    }
    
}
