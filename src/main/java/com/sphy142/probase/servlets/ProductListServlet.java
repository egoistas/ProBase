/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sphy142.probase.servlets;

import com.sphy142.probase.beans.Product;
import com.sphy142.probase.beans.UserAccount;
import com.sphy142.probase.utils.DBUtils;
import com.sphy142.probase.utils.MyUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;   
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author georg
 */
@WebServlet(urlPatterns = {"/productList"})
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAccount user = MyUtils.getLoginedUser(req.getSession());
        if (user == null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(req, resp);
        } else {
            Connection con = MyUtils.getStoredConnection(req);
            String errorString  = null;
            List<Product> list = null;
            try {
                list = DBUtils.queryProduct(con);
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                errorString  = ex.getMessage();
            }
            req.setAttribute("errorString", errorString);
            req.setAttribute("products", list);
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productListView.jsp");
            dispatcher.forward(req, resp);
        }// if-else
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
