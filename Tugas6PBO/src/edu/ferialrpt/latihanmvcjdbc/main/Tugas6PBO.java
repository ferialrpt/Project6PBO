/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.main;

import edu.ferialrpt.latihanmvcjdbc.database.MahasiswaDatabase;
import edu.ferialrpt.latihanmvcjdbc.entity.Mahasiswa;
import edu.ferialrpt.latihanmvcjdbc.error.mahasiswaException;
import edu.ferialrpt.latihanmvcjdbc.service.MahasiswaDao;
import edu.ferialrpt.latihanmvcjdbc.view.MainViewMahasiswa;
import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author MY PC
 */
public class Tugas6PBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, mahasiswaException {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewMahasiswa mahasiswa = new MainViewMahasiswa();
                    mahasiswa.loadDatabase();
                    mahasiswa.setVisible(true);
                } catch (SQLException ex) {
                } catch (mahasiswaException ex) {
                }

            }
        });
    }
}
