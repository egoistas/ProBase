/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sphy142.probase.utils;

import com.sphy142.probase.beans.Product;
import com.sphy142.probase.beans.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author georg
 */
public class DBUtils {

    public static UserAccount findUser(Connection conn, String username, String password) throws SQLException {

        String sql = "SELECT * FROM useraccount " + "WHERE username=? AND password=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUserName(username);
            user.setPassword(password);
            user.setGender(rs.getString("gender"));
            return user;
        }
        rs.close();
        return null;
    }//findUser

    public static UserAccount findUser(Connection conn, String username) throws SQLException {

        String sql = "SELECT * FROM useraccount " + "WHERE username=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUserName(username);
            user.setPassword(rs.getString("password"));
            user.setGender(rs.getString("gender"));
            return user;
        }
        rs.close();
        return null;
    }//findUser

    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "SELECT * FROM product";
        PreparedStatement pstm = conn.prepareStatement(sql);
        List<Product> products = new ArrayList<>();
        ResultSet rs = pstm.executeQuery(); // kalitera na douleuo me local metablites gia na min ginei mlkia stin basi
        while (rs.next()) {
            Product p = new Product();
            p.setCode(rs.getString("code"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getFloat("price"));
            products.add(p);
        }
        rs.close();
        return products;
    } //queryProduct    

    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "SELECT * FROM product where code = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        ResultSet rs = pstm.executeQuery(); // kalitera na douleuo me local metablites gia na min ginei mlkia stin basi
        if (rs.next()) {
            Product p = new Product();
            p.setCode(rs.getString("code"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getFloat("price"));
            return p;
        }
        rs.close(); // auto an einai adios o pinakas kai to kano close den kseroume an tha galei programa
        return null;
    } //queryProduct    

    public static void insertProduct(Connection conn, Product p) throws SQLException {
        String sql = "insert into product (code,name,price) values "
                + " (?,?,?);";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getCode());
        pstm.setString(2, p.getName());
        pstm.setFloat(3, p.getPrice());
        pstm.executeQuery();
    }

    public static void updateProduct(Connection conn, Product p) throws SQLException {
        String sql = "update product set name=? , price=? where code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(3, p.getCode());
        pstm.setString(1, p.getName());
        pstm.setFloat(2, p.getPrice());
        pstm.executeUpdate();
    }

    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "delete product where code=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        pstm.executeQuery();
    }
    
}
