package com.Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    int click=1;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<center><h1> Total Number of Hits </h1>");
        out.println("<h1>" + click + "</h1></center>");
        out.println("</html></body>");
        click++;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}