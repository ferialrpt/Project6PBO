/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.service;

import edu.ferialrpt.latihanmvcjdbc.entity.Pelanggan;
import edu.ferialrpt.latihanmvcjdbc.error.PelangganException;
import java.util.List;

/**
 *
 * @author NIM:10116553 | Nama : Ferial Rachmadiputra | Kelas : PBO-12
 */
public interface PelangganDao {
    //CRUD
    //Get by kode_mapel

    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;

    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException;

    public void deletePelanggan(Integer id) throws PelangganException;

    public Pelanggan getPelanggan(Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan(String email) throws PelangganException;

    //reload data_mapel 
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;
}
