/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.impl;

import edu.ferialrpt.latihanmvcjdbc.entity.Mahasiswa;
import edu.ferialrpt.latihanmvcjdbc.error.mahasiswaException;
import edu.ferialrpt.latihanmvcjdbc.service.MahasiswaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class MahasiswaDaoImpl implements MahasiswaDao {

    private Connection connection;

    public MahasiswaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    private final String insertMahasiswa = "INSERT INTO MAHASISWA (NIM,NAMA,KELAS) VALUES (?,?,?)";

    @Override
    public void insertMahasiswa(Mahasiswa mahasiswa) throws mahasiswaException {
        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertMahasiswa, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getKelas());
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                mahasiswa.setNomor(result.getInt(1));
            }

            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException Ex) {

            }
            throw new mahasiswaException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException Ex) {

            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    private final String updateMahasiswa = "UPDATE MAHASISWA SET NIM=?,NAMA=?,KELAS=? WHERE NOMOR=?";

    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa) throws mahasiswaException {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(updateMahasiswa);
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getKelas());

            statement.setInt(4, mahasiswa.getNomor());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new mahasiswaException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    private final String deleteMahasiswa = "DELETE FROM MAHASISWA WHERE NOMOR=?";

    @Override
    public void deleteMahasiswa(Integer nomor) throws mahasiswaException {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(deleteMahasiswa);
            statement.setInt(1, nomor);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new mahasiswaException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    private final String getByNomor = "SELECT * FROM MAHASISWA WHERE NOMOR=?";

    @Override
    public Mahasiswa getMahasiswa(Integer nomor) throws mahasiswaException {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(getByNomor);
            //indeks ke-1 isinya Nomor dari parameter
            statement.setInt(1, nomor);
            ResultSet result = statement.executeQuery();
            Mahasiswa mahasiswa = null;
            if (result.next()) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNomor(result.getInt("NOMOR"));
                mahasiswa.setNim(result.getString("NIM"));
                mahasiswa.setNama(result.getString("NAMA"));
                mahasiswa.setKelas(result.getString("KELAS"));
            } else {
                throw new mahasiswaException("Mahasiswa dengan Nomor " + nomor + " tidak ditemukan!");
            }
            return mahasiswa;
        } catch (SQLException exception) {
            throw new mahasiswaException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    private final String selectAll = "SELECT * FROM MAHASISWA";

    @Override

    public List<Mahasiswa> selectAllMahasiswa() throws mahasiswaException {
        Statement statement = null;
        List<Mahasiswa> list = new ArrayList<Mahasiswa>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNomor(result.getInt("NOMOR"));
                mahasiswa.setNim(result.getString("NIM"));
                mahasiswa.setNama(result.getString("NAMA"));
                mahasiswa.setKelas(result.getString("KELAS"));

                list.add(mahasiswa);
            }
            return list;
        } catch (SQLException exception) {
            throw new mahasiswaException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }
    private final String getByNim = "SELECT * FROM MAHASISWA WHERE NIM=?";

    @Override
    public Mahasiswa getMahasiswa(String nim) throws mahasiswaException {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(getByNim);
            //indeks ke-1 isinya Nomor dari parameter
            statement.setString(1, nim);
            ResultSet result = statement.executeQuery();
            Mahasiswa mahasiswa = null;
            if (result.next()) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNomor(result.getInt("NOMOR"));
                mahasiswa.setNim(result.getString("NIM"));
                mahasiswa.setNama(result.getString("NAMA"));
                mahasiswa.setKelas(result.getString("KELAS"));
            } else {
                throw new mahasiswaException("Mahasiswa dengan Nomor " + nim + " tidak ditemukan!");
            }
            return mahasiswa;
        } catch (SQLException exception) {
            throw new mahasiswaException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

}
