/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sphy142.probase.utils;

import com.sphy142.probase.beans.UserAccount;
import java.sql.Connection;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyUtils {

    private static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_STORING_CONNECTION";
    private static final String ATT_NAME_SESSION_USERNAME = "ATTRIBUTE_FOR_SESSION_USERNAME";
    private static final String ATT_NAME_COOKIE_USERNAME = "ATTRIBUTE_FOR_COOKIE_USERNAME";

    // Kano me connection
    public static void storeConnection(ServletRequest req, Connection conn) {
        req.setAttribute(ATT_NAME_CONNECTION, conn);
    }//storeConnection

    public static Connection getStoredConnection(ServletRequest req) {
        return (Connection) req.getAttribute(ATT_NAME_CONNECTION);
    }// getStoredConnection

    //kano me session
    public static void storeLoginedUser(HttpSession session, UserAccount user) {
        session.setAttribute(ATT_NAME_SESSION_USERNAME, user);
    }//storeLoginedUser

    public static UserAccount getLoginedUser(HttpSession session) {
        return (UserAccount) session.getAttribute(ATT_NAME_SESSION_USERNAME);
    }//getLoginedUser

    //me cookies
    public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
        System.out.println("Store user Cookie");
        Cookie cookie = new Cookie(ATT_NAME_COOKIE_USERNAME, user.getUserName());
        // 1 mera diarkia zois
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
    }

    public static String getUserNameInCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_COOKIE_USERNAME.equals(cookie.getName()))
                    return cookie.getValue();
            }
        }
        return null;
    }
    
    public static void deleteCookie(HttpServletResponse res){
        Cookie cookie = new Cookie(ATT_NAME_COOKIE_USERNAME, null);
        // 1 mera diarkia zois
        cookie.setMaxAge(0);
        res.addCookie(cookie);
    }
    
    

}
