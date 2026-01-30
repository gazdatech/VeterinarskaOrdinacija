/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Tretman;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gazda
 */
public class ModelTabeleTretman extends AbstractTableModel{
    
    private List<Tretman> lista;
    private String[] kolone = {"Naziv", "Datum pocetka", "Doza", "Tip terapije", "Napomena"};
    
    public ModelTabeleTretman() {
        // OVO TI FALI:
        this.lista = new ArrayList<>(); 
    }
    
    public ModelTabeleTretman(List<Tretman> lista) {
        this.lista = lista;
    }
 
    @Override
    public int getRowCount() {
        if (lista == null) return 0;
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tretman t = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return t.getTerapija().getNazivTerapije();
            case 1: return t.getDatumPocetka();
            case 2: return t.getDoza();
            case 3: return t.getTerapija().getTipTerapije();
            case 4: return t.getNapomena();
            default: return "N/A";
        }
    }
    
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajTretman(Tretman t) {
        lista.add(t);
        fireTableDataChanged();
    }

    public List<Tretman> getLista() {
        return lista;
    }
    
    
    
    
    
}
