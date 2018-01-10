/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.error;

/**
 *
 * @author MY PC
 */
public class mahasiswaException extends Exception {

    /**
     * Creates a new instance of <code>mahasiswaException</code> without detail
     * message.
     */
    public mahasiswaException() {
    }

    /**
     * Constructs an instance of <code>mahasiswaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public mahasiswaException(String msg) {
        super(msg);
    }
}
