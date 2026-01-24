/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import konfiguracija.Konfiguracija;

/**
 *
 * @author gazda
 */
public class DbConnectionFactory { // klasicna konekcija 
    private static DbConnectionFactory instance;
    private Connection connection;
    
    private DbConnectionFactory() {   
    }

    public static DbConnectionFactory getInstance() {
        if(instance == null) {
            instance = new DbConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = Konfiguracija.getInstanca().getProperty("url");
            String username = Konfiguracija.getInstanca().getProperty("username");
            String password = Konfiguracija.getInstanca().getProperty("password");
            
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            System.out.println("Nova konekcija sa bazom je uspesno otvorena.");
        }
        return connection;
        }
    }
 
  
