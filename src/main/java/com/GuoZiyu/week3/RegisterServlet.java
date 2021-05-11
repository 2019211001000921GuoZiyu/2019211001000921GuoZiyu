
package com.GuoZiyu.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(
        urlPatterns = {"/register"},loadOnStartup = 1
        //name = "RegisterServlet", value = "/RegisterServlet"
)

public class RegisterServlet extends HttpServlet {


    Connection con = null;
    String driver;
    String url;
    String username;
    String password;

    public void init(){
 /*       ServletContext context = getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
*/
        con= (Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*      //get parameter from request
        String Username = request.getParameter("username");//name of input
        String Password = request.getParameter("password");//
        String Email = request.getParameter("email");//
        String Gander = request.getParameter("gander");//
        String Birthdate = request.getParameter("birthdate");//
        //response
        PrintWriter writer = response.getWriter();
        writer.println("<br>Username :"+Username);
        writer.println("<br>Password :"+Password);
        writer.println("<br>Email :"+Email);
        writer.println("<br>Gander :"+Gander);
        writer.println("<br>Birthdate :"+Birthdate);
        writer.close();
        }
}
*/
        //get parameter
        String ID = null;
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        String Birthdate = request.getParameter("birthdate");



        //response
        PrintWriter writer = response.getWriter();
        try {
            Statement Greatest = con.createStatement();
            String insertDb = "insert into userdb.dbo.usertable(username,password,email,gender,birthdate) values('"+Username+"','"+Password+"','"+Email+"','"+Gender+"','"+Birthdate+"')";
            int n= Greatest.executeUpdate(insertDb);
            System.out.println("n-->"+n);
            // String selectDb = "select * from userdb.dbo.usertable";
            //ResultSet rs = Greatest.executeQuery(selectDb);
 /*           writer.println(
                    "<table border=\"1\">" +
                            "<tr>"               +
                            "<td>ID</td>"        +
                            "<td>Username</td>"  +
                            "<td>Password</td>"  +
                            "<td>Email</td>"     +
                            "<td>Gender</td>"    +
                            "<td>BirthDate</td>" +
                            "</tr>"
            );
            while(rs.next()) {
                ID =rs.getString("ID");
                Username = rs.getString("Username");
                Password = rs.getString("Password");
                Email = rs.getString("Email");
                Gender = rs.getString("Gender");
                Birthdate = rs.getString("Birthdate");
                writer.println(
                        "<tr>"     +
                                "<td>" + ID       + "</td>"   +
                                "<td>" + Username + "</td>" +
                                "<td>" + Password  + "</td>" +
                                "<td>" + Email     + "</td>" +
                                "<td>" + Gender    + "</td>" +
                                "<td>" + Birthdate + "</td>" +
                                "</tr>"
                );
            }
*/
            //use request Attribute

            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userList.jsp").forward(request,response);


            // System.out.println("i am in RegisterServlet --> doPost() --> after forward()");
            response.sendRedirect("Login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//          writer.println("</table>");





    }
}