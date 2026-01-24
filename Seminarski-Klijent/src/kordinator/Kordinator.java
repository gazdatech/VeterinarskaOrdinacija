/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import forme.LoginForm;
import kontroleri.LoginController;

/**
 *
 * @author gazda
 */
public class Kordinator {
    private static Kordinator instance;
    private LoginController loginController;
    private Kordinator() {
        
    }

    public static Kordinator getInstance() {
        if(instance == null) {
            instance = new Kordinator();
        }
        return instance;
    }


    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForm());
        loginController.otvoriFormu();
    }
    
}
