/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.model;

import edu.ferialrpt.latihanmvcjdbc.entity.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MY PC
 */
public class TabelMahasiswaModel extends AbstractTableModel {
    
    private List<Mahasiswa> list = new ArrayList<Mahasiswa>();
    
    public void setList(List<Mahasiswa> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNomor();
            case 1:
                return list.get(rowIndex).getNim();
            case 2:
                return list.get(rowIndex).getNama();
            case 3:
                return list.get(rowIndex).getKelas();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NOMOR";
            case 1:
                return "NIM";
            case 2:
                return "NAMA";
            case 3:
                return "KELAS";
            default:
                return null;
        }
    }
    
    public boolean add(Mahasiswa e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }
    
    public Mahasiswa get(int index) {
        return list.get(index);
    }
    
    public Mahasiswa set(int index, Mahasiswa element) {
        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTableRowsUpdated
            fireTableRowsUpdated(index, index);
        }
    }
    
    public Mahasiswa remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
}
