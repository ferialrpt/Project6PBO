/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.error;

/**
 *
 * @author NIM:10116553 | Nama : Ferial Rachmadiputra | Kelas : PBO-12
 */
public class PelangganException extends Exception {

    /**
     * Creates a new instance of <code>mahasiswaException</code> without detail
     * message.
     */
    public PelangganException() {
    }

    /**
     * Constructs an instance of <code>mahasiswaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PelangganException(String msg) {
        super(msg);
    }
}
