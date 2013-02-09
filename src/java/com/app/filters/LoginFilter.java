/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Devraj
 */
public class LoginFilter implements Filter {
   
    public LoginFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        //if(session.getAttribute("userNo")!=null)
            chain.doFilter(request, response);
        //else
         //   request.getRequestDispatcher("/").forward(request, response);
    }

    public void destroy() {}
    

}
