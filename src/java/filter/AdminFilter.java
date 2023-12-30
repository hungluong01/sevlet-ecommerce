/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MyUtils;

/**
 *
 * @author ToanPham
 */
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Type cast
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String servletPath = req.getServletPath();
        
        if (servletPath.equalsIgnoreCase("/admin/login")) {
            if (MyUtils.checkLogin(req)) {
                res.sendRedirect("manage-product");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (MyUtils.checkLogin(req)) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect("/Shop/admin/login");
                        
            }
        }
    }

    @Override
    public void destroy() {
        
    }
    
}

