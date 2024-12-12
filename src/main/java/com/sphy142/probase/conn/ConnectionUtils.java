/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sphy142.probase.conn;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author georg
 */
public class ConnectionUtils {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public static void closeQuietly(Connection conn){
        try{
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void rollbackQuietly(Connection conn){
        try{
            conn.rollback();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
