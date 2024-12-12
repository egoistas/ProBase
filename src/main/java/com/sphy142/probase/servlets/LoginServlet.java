/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sphy142.probase.servlets;

import com.sphy142.probase.beans.UserAccount;
import com.sphy142.probase.utils.DBUtils;
import com.sphy142.probase.utils.MyUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberme");
        boolean remember = "Y".equals(rememberMe);

        UserAccount user = null;
        String errorString = null;
        boolean hasError = false;

        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Username or password is incorrect";
        } else {
            Connection conn = MyUtils.getStoredConnection(req);
            try {
                user = DBUtils.findUser(conn, userName, password);
                if (user == null) {
                    hasError = true;
                    errorString = "Username or password is incorrect";
                }

            } catch (SQLException ex) {
                hasError = true;
                errorString = ex.getMessage();
            }
        }

        if (hasError) {
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            req.setAttribute("user", user);
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            MyUtils.storeLoginedUser(session, user);
            if (remember){
                MyUtils.storeUserCookie(resp, user);
            }else{
                MyUtils.deleteCookie(resp);
            }
            resp.sendRedirect(req.getContextPath() +"/userInfo");
        }//if has error
        
    }//doPost

}
