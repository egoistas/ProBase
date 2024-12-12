package com.sphy142.probase.filters;

import com.sphy142.probase.beans.UserAccount;
import com.sphy142.probase.utils.DBUtils;
import com.sphy142.probase.utils.MyUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        UserAccount userInSession = MyUtils.getLoginedUser(session);
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }
        Connection conn = MyUtils.getStoredConnection(request);
        String checked = (String) request.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userNameInCookie = MyUtils.getUserNameInCookie((HttpServletRequest) request);
            if (userNameInCookie != null) {
                try {
                    UserAccount user = DBUtils.findUser(conn, userNameInCookie);
                    MyUtils.storeLoginedUser(session, user);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }//try - catch

            } //if userNameInCookie
        }//if checked
        chain.doFilter(request, response);
    }//doFilter

}
