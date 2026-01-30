/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.PlanRehabilitacije;
import domen.Veterinar;
import domen.Zivotinja;
import forme.DetaljiZivotinjeForma;
import komunikacija.Komunikacija;

/**
 *
 * @author gazda
 */
public class DetaljiZivotinjeController {
        private final DetaljiZivotinjeForma dzf;
        
        public DetaljiZivotinjeController(DetaljiZivotinjeForma dzf) {
            this.dzf = dzf;
            addActionListeners(); 
    }

    private void addActionListeners() {
        /////
    }

    public void otvoriFormu() {
        Zivotinja z = kordinator.Kordinator.getInstance().getZivotinja();
       // popuniPodatke(z);
        pripremiFormu();
        dzf.setVisible(true);
    }

    private void pripremiFormu() {
        ///
    }

    private void popuniPodatke(Zivotinja z) {
        //
    }
    
    
    
    
    

}
