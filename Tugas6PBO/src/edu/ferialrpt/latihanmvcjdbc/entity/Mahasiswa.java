/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.entity;

import java.util.Objects;

/**
 *
 * @author MY PC
 */
public class Mahasiswa {

    private Integer nomor;
    private String nim;
    private String nama;
    private String kelas;

    public Mahasiswa() {

    }

    public Mahasiswa(String nim, String nama, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nomor);
        hash = 67 * hash + Objects.hashCode(this.nim);
        hash = 67 * hash + Objects.hashCode(this.nama);
        hash = 67 * hash + Objects.hashCode(this.kelas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mahasiswa other = (Mahasiswa) obj;
        if (!Objects.equals(this.nim, other.nim)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.kelas, other.kelas)) {
            return false;
        }
        if (!Objects.equals(this.nomor, other.nomor)) {
            return false;
        }
        return true;

    }

    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

}
