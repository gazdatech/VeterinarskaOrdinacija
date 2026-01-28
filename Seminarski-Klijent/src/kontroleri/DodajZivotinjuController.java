/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;
import domen.VrstaZivotinje;
import enums.Pol;
import forme.DodajZivotinjuForma;
import java.util.List;
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

    }

    private void pripremiFormu() throws Exception {
        List<VrstaZivotinje> vrste = komunikacija.Komunikacija.getInstance().vratiSveVrsteZivotinja();

        dzf.getCmbVrsta().removeAllItems(); 

        for (VrstaZivotinje v : vrste) {
           dzf.getCmbVrsta().addItem(v);
        }
        
        dzf.getCmbPol().removeAllItems();
        for(Pol p : Pol.values()) {
            dzf.getCmbPol().addItem(p.toString());
        }
    }
}
