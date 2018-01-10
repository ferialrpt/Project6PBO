/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.service;

import edu.ferialrpt.latihanmvcjdbc.entity.Mahasiswa;
import edu.ferialrpt.latihanmvcjdbc.error.mahasiswaException;
import java.util.List;

/**
 *
 * @author MY PC
 */
public interface MahasiswaDao {
    //CRUD
    //Get by kode_mapel

    public void insertMahasiswa(Mahasiswa mahasiswa) throws mahasiswaException;

    public void updateMahasiswa(Mahasiswa mahasiswa) throws mahasiswaException;

    public void deleteMahasiswa(Integer nomor) throws mahasiswaException;

    public Mahasiswa getMahasiswa(Integer nomor) throws mahasiswaException;
    
    public Mahasiswa getMahasiswa(String nim) throws mahasiswaException;

    //reload data_mapel 
    public List<Mahasiswa> selectAllMahasiswa() throws mahasiswaException;
}
