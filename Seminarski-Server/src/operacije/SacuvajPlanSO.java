/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import domen.PlanRehabilitacije;
import domen.Tretman;
import repository.db.DbConnectionFactory;
import java.sql.*;
import java.util.List;

/**
 *
 * @author gazda
 */
public class SacuvajPlanSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        ///
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        PlanRehabilitacije plan = (PlanRehabilitacije) objekat;
        broker.add(plan);
        Connection conn = DbConnectionFactory.getInstance().getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
        int generisaniId = 0;
        if (rs.next()) {
            generisaniId = rs.getInt(1);
        }
        rs.close();
        st.close();

        if (generisaniId == 0) {
            throw new Exception("Sistem nije uspeo da generiše ID za plan!");
        }

        // 3. Postavljamo ID u objekat plana i prosleđujemo ga tretmanima
        plan.setPlanId(generisaniId);
        
        List<Tretman> tretmani = plan.getTretmani();
        if (tretmani != null && !tretmani.isEmpty()) {
            for (Tretman t : tretmani) {
                // Ovde vezujemo dete za roditelja
                t.setPlanRehabilitacije(plan);
                
                // Osiguravamo da datum nije null (onaj tvoj stari Exception)
                if (t.getDatumPocetka() == null) {
                    t.setDatumPocetka(new java.util.Date());
                }
                
                // Čuvamo tretman preko istog brokera
                broker.add(t);
            }
        }
    }

}
