/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvtelecom10.sotore.conection;

import java.sql.*;

/**
 *
 * @author mv
 */
public class ConnectionModule {

    // method for establishing the connection
    public static Connection connection() {
        java.sql.Connection c = null;
        //call the driver
        String driver = "com.mysql.jdbc.Driver";
        //store information related to the database
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "";
        //connect to the database

        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, password);
            return c;
        } catch (Exception e) {
            System.out.println(c);
            return null;
        }
    }
}
