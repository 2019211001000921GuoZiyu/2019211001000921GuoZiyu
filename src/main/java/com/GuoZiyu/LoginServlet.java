package com.GuoZiyu.Week5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Objects;

@WebServlet (name="LoginServlet" , value="/Login")

public class LoginServlet extends HttpServlet {

    Connection con = null;
    String driver;
    String url;
    String username;
    String password;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get parameter from request

        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        //response

        String  a = null;
        String b = null;
        PrintWriter writer = response.getWriter();
        try {
            Statement Greatest = con.createStatement();
            String User= "select * from userdb.dbo.usertable where username='EXPECT^'and password='123456'";
            ResultSet rs = Greatest.executeQuery(User);
            while(rs.next()) {
                a = rs.getString("username");
                b = rs.getString("password");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (Objects.equals(Username, a) && Objects.equals(Password, b)) {
            writer.println("Login Success!!!");
            writer.println("Welcome  " + a);
        } else {
            writer.println("Username or Password Error!!!");
        }


    }
}