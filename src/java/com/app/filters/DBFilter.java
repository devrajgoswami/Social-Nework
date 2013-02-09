/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.filters;

import com.app.dao.DBService.ConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DBFilter implements Filter {
    
    private static final Logger logger = Logger.getLogger(DBFilter.class.getName());
    private Connection con = null;
        
    public void init(FilterConfig filterConfig) throws ServletException {
        con=ConnectionManager.getMySQLConnection();
        logger.info("Database Filter started...");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(con == null)
            request.getRequestDispatcher("/WEB-INF/ErrorPages/ConnectionError.jsp").forward(request, response);
        else
            chain.doFilter(request, response);
    }

    public void destroy() {
        ConnectionManager.closeMySQLConnection(con);
        logger.info("Database Filter closed...");
    }
    
    
}
