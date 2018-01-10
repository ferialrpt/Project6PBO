/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.event;

import edu.ferialrpt.latihanmvcjdbc.entity.Mahasiswa;
import edu.ferialrpt.latihanmvcjdbc.model.MahasiswaModel;

/**
 *
 * @author MY PC
 */
public interface MahasiswaListener {

    //diambil dari model
    public void onChange(MahasiswaModel model);

    //diambil dari entity
    public void onInsert(Mahasiswa mahasiswa);

    public void onUpdate(Mahasiswa mahasiswa);

    public void onDelete();
}
