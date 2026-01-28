/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Veterinar;
import forme.GlavnaForma;
import forme.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kordinator.Kordinator;
import komunikacija.Komunikacija;

/**
 *
 * @author gazda
 */
public class LoginController {
    private final LoginForm lf;

    public LoginController(LoginForm lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                try {
                    Veterinar v;
                    String user = lf.getjTextField1().getText().trim();
                    String password = new String(lf.getjPasswordField1().getPassword());
                    Komunikacija.getInstance().konekcija();
                    
                    v = Komunikacija.getInstance().login(user,password);
                    if(v == null) {
                        JOptionPane.showMessageDialog(lf,"Prijava na sistem nije uspesna!", "Nespeh", JOptionPane.ERROR_MESSAGE);
                        
                    }else {
                        Kordinator.getInstance().setUlogovani(v);
                        JOptionPane.showMessageDialog(lf,"Prijava na sistem uspesna!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        Kordinator.getInstance().otvoriGlavnuFormu();
                        lf.dispose();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
}
