package com.Lab2;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/Lab2/welcome.jsp","/Lab2/validate.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in LoginFilter-->init()");
    }

    public void destroy() {
        System.out.println("I am in LoginFilter-->destroy()");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("I am in LoginFilter--doFilter()-->request before chain");
        chain.doFilter(request, response);
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse)response;
        Login logger=(Login) req.getAttribute("Logger");
        if(logger.getUsername() != null && logger.getPassword() != null){
            req.getRequestDispatcher("/Lab2/welcome.jsp").forward(request,response);
        }else {
            res.sendRedirect("login.jsp");
        }

        System.out.println("I am in LoginFilter--doFilter()-->request after chain");

    }

}