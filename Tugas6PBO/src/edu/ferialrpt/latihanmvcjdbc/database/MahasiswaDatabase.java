/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ferialrpt.latihanmvcjdbc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.ferialrpt.latihanmvcjdbc.impl.MahasiswaDaoImpl;
import edu.ferialrpt.latihanmvcjdbc.service.MahasiswaDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MY PC
 */
public class MahasiswaDatabase {
    private static Connection connection;

    private static MahasiswaDao mahasiswaDao;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/dbmahasiswa");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static MahasiswaDao getMahasiswaDao() throws SQLException {
        if (mahasiswaDao == null) {
            mahasiswaDao = new MahasiswaDaoImpl(getConnection());
        }
        return mahasiswaDao;
    }
}
