/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;
import domen.VrstaZivotinje;
import domen.Zivotinja;
import enums.Pol;
import forme.DodajZivotinjuForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author gazda
 */
public class DodajZivotinjuController {
    private final DodajZivotinjuForma dzf;

    public DodajZivotinjuController(DodajZivotinjuForma dzf) {
        this.dzf = dzf;
        addActionListeners(); 
    }
    
    
   public void otvoriFormu() throws Exception {
       pripremiFormu();
       dzf.setVisible(true);
   }

    private void addActionListeners() {
        dzf.dodajAddActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                try {
                // 1. Validacija praznih polja
                    if (dzf.getTxtIme().getText().isEmpty() || dzf.getTxtTezina().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(dzf, "Sva polja moraju biti popunjena!", "Greška", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // 2. Provera formata brojeva (Težina i Starost)
                    double tezina;
                    int starost;
                    try {
                        tezina = Double.parseDouble(dzf.getTxtTezina().getText().trim());
                        starost = Integer.parseInt(dzf.getTxtStarost().getText().trim());

                        if (tezina <= 0 || starost < 0) {
                            throw new Exception("Brojevi moraju biti pozitivni!");
                        }
                    } catch (NumberFormatException er) {
                        JOptionPane.showMessageDialog(dzf, "Težina i starost moraju biti pravilno uneti brojevi!", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // 3. Pakovanje objekta (ako je sve prošlo)
                    Zivotinja z = new Zivotinja();
                    z.setIme(dzf.getTxtIme().getText().trim());
                    z.setTezinaKg(tezina);
                    z.setStarost(starost);
                    z.setPol((Pol) dzf.getCmbPol().getSelectedItem());
                    z.setVrstaZivotinje((VrstaZivotinje) dzf.getCmbVrsta().getSelectedItem());
                    z.setbrojCipa(dzf.getTxtBrCipa().getText().trim());

                    // 4. Slanje na server
                    komunikacija.Komunikacija.getInstance().dodajZivotinju(z);

                    JOptionPane.showMessageDialog(dzf, "Sistem je uspešno zapamtio životinju!");
                    dzf.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dzf, "Greška pri čuvanju: " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            }
                }
        });
    }

    private void pripremiFormu() throws Exception {
        List<VrstaZivotinje> vrste = komunikacija.Komunikacija.getInstance().vratiSveVrsteZivotinja();

        dzf.getCmbVrsta().removeAllItems(); 

        for (VrstaZivotinje v : vrste) {
           dzf.getCmbVrsta().addItem(v);
        }
        
        dzf.getCmbPol().removeAllItems();
        for(Pol p : Pol.values()) {
            dzf.getCmbPol().addItem(p);
        }
    }
}
