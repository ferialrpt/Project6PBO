/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.model;

import edu.ferialrpt.latihanmvcjdbc.database.MahasiswaDatabase;
import edu.ferialrpt.latihanmvcjdbc.entity.Mahasiswa;
import edu.ferialrpt.latihanmvcjdbc.error.mahasiswaException;
import edu.ferialrpt.latihanmvcjdbc.event.MahasiswaListener;
import edu.ferialrpt.latihanmvcjdbc.service.MahasiswaDao;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class MahasiswaModel {

    private int no;
    private String nim;
    private String nama;
    private String kelas;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
        fireOnChange();
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
        fireOnChange();
    }

    private MahasiswaListener listener;

    public MahasiswaListener getListener() {
        return listener;
    }

    public void setListener(MahasiswaListener listener) {
        this.listener = listener;
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Mahasiswa mahasiswa) {
        if (listener != null) {
            listener.onInsert(mahasiswa);
        }
    }

    protected void fireOnUpdate(Mahasiswa mahasiswa) {
        if (listener != null) {
            listener.onUpdate(mahasiswa);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertMahasiswa() throws SQLException, mahasiswaException {
        MahasiswaDao dao = MahasiswaDatabase.getMahasiswaDao();

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(nim);
        mahasiswa.setNama(nama);
        mahasiswa.setKelas(kelas);

        dao.insertMahasiswa(mahasiswa);
        fireOnInsert(mahasiswa);
    }

    public void updateMahasiswa() throws SQLException, mahasiswaException {
        MahasiswaDao dao = MahasiswaDatabase.getMahasiswaDao();

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(nim);
        mahasiswa.setNama(nama);
        mahasiswa.setKelas(kelas);
        mahasiswa.setNomor(no);

        dao.updateMahasiswa(mahasiswa);
        fireOnUpdate(mahasiswa);
    }

    public void deleteMahasiswa() throws SQLException, mahasiswaException {
        MahasiswaDao dao = MahasiswaDatabase.getMahasiswaDao();

        dao.deleteMahasiswa(no);
        fireOnDelete();
    }

    public void resetMahasiswa() {
        setNo(0);
        setNim("");
        setNama("");
        setKelas("");
    }
}
