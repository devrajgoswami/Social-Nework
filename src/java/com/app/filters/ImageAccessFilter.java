
package com.app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ImageAccessFilter implements Filter {
   
    public ImageAccessFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //response.getWriter().println("Error...");
        chain.doFilter(request, response);
    }

    public void destroy() {}
    
}
