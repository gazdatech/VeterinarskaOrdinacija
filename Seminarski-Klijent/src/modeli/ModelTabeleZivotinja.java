/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Zivotinja;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gazda
 */
public class ModelTabeleZivotinja extends AbstractTableModel{
    
    private List<Zivotinja> lista;
    private String[] kolone = {"ID","Ime", "Broj Cipa", "Vrsta", "Pol", "Tezina"};
    
    public ModelTabeleZivotinja(List<Zivotinja> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zivotinja z = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return z.getZivotinjaId();
            case 1: return z.getIme(); // ili broj markice
            case 2: return z.getBrojCipa();
            case 3: return z.getVrstaZivotinje().getNazivVrste();
            case 4: return z.getPol();
            case 5: return z.getTezinaKg();
            default: return "N/A";
        }
    }
    
    public Zivotinja getSelectedZivotinja(int row) {
        return lista.get(row);
    }
    
}
