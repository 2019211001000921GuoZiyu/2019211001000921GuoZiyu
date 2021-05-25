package com.GuoZiyu.controller;

import com.GuoZiyu.dao.ProductDao;
import com.GuoZiyu.model.Category;
import com.GuoZiyu.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con=null;


    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (request.getParameter("id")!=null){
                int productId= Integer.parseInt(request.getParameter("id"));
                ProductDao productDao=new ProductDao();
                Product product=productDao.findById(productId,con);
                request.setAttribute("p",product);
            } }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/views/productDetails.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}