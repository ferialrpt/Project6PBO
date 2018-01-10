/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.controller;

import edu.ferialrpt.latihanmvcjdbc.error.mahasiswaException;
import edu.ferialrpt.latihanmvcjdbc.model.MahasiswaModel;
import edu.ferialrpt.latihanmvcjdbc.view.MainViewMahasiswa;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MY PC
 */
public class MahasiswaController {

    private MahasiswaModel model;

    public void setModel(MahasiswaModel model) {
        this.model = model;
    }

    public void resetMahasiswa(MainViewMahasiswa view) {
        model.resetMahasiswa();
    }

    public void insertMahasiswa(MainViewMahasiswa view) {
        String nim = view.getTxtNim().getText();
        String nama = view.getTxtNama().getText();
        String kelas = view.getTxtKelas().getText();

        if (nim.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "NIM masih kosong!");
        }
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama masih kosong!");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255!");
        } else if (nim.length() < 8) {
            JOptionPane.showMessageDialog(view, "NIM tidak boleh kurang dari 8!");
        } else if (kelas.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kelas masih kosong!");
        } else {
            model.setNim(nim);
            model.setNama(nama);
            model.setKelas(kelas);
            try {
                model.insertMahasiswa();
                JOptionPane.showMessageDialog(view, "Data mahasiswa berhasil ditambahkan!");
                model.resetMahasiswa();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error didatabase dengan pesan", throwable.getMessage()
                });
            }
        }
    }

    public void updateMahasiswa(MainViewMahasiswa view) {
        //jika tidak ada data yg dipilih, kasih peringatan
        if (view.getTblMahasiswa().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan diubah!");
            return;
        }
        Integer nomor = Integer.parseInt(view.getTxtNo().getText());
        String nim = view.getTxtNim().getText();
        String nama = view.getTxtNama().getText();
        String kelas = view.getTxtKelas().getText();

        if (nim.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "NIM masih kosong!");
        }
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama masih kosong!");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255!");
        } else if (nim.length() < 8) {
            JOptionPane.showMessageDialog(view, "NIM tidak boleh kurang dari 8!");
        } else if (kelas.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kelas masih kosong!");
        } else {
            model.setNo(nomor);
            model.setNim(nim);
            model.setNama(nama);
            model.setKelas(kelas);
            try {
                model.updateMahasiswa();
                JOptionPane.showMessageDialog(view, "Data mahasiswa berhasil diubah!");
                model.resetMahasiswa();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error didatabase dengan pesan", throwable.getMessage()
                });
            }
        }
    }

    public void deleteMahasiswa(MainViewMahasiswa view) {
        //jika tidak ada data yg dipilih, kasih peringatan
        if (view.getTblMahasiswa().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan dihapus!");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {
            Integer nomor = Integer.parseInt(view.getTxtNo().getText());
            model.setNo(nomor);
            try {
                model.deleteMahasiswa();
                JOptionPane.showMessageDialog(view, "Data mahasiswa berhasil dihapus!");
                model.resetMahasiswa();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error didatabase dengan pesan", throwable.getMessage()
                });
            }
        }
    }
}
