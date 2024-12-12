/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sphy142.probase.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author georg
 */
public class MySQLConnUtils {
    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException{
        String hostName = "localhost";
        String dbName = "productbase";
        String userName = "root"; // pote den xrisimopoioume to root genika..
        String password = "root"; 
        return getMySQLConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMySQLConnection(String hostName, String dbName, 
            String userName, String password) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver"); // Fortono opotedipote opiadipote classi, module ktl ktl xoris import kateuthehian
        String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName + "?characterEncoding=utf8";
        
        Connection conn = DriverManager.getConnection(connectionURL, userName, password); // edo orizete to connection
        conn.setAutoCommit(false); // gia transaction!!
        return conn;
    }
}
