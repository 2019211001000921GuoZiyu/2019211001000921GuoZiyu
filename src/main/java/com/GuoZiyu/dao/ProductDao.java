package com.GuoZiyu.dao;

import com.GuoZiyu.model.Product;


import java.sql.*;
import java.util.Collections;
import java.util.List;

public class ProductDao implements  IProductDao {
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, Product.getProductName());
        pt.setString(2, Product.getProductDescription());
        if (Product.getPicture() != null) {

            pt.setBinaryStream(3, Product.getPicture());

        }
        pt.setDouble(4, Product.getPrice());
        pt.setInt(5, Product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {

        String sql = "delete from product where ProductId=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, Product.getProductId());
        return st.executeUpdate();
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {

        String sql = "update peoduct set ProductName=?,ProductDescription=?,picture=?,price=?,CategoryId=? where ProductId=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, Product.getProductName());
        st.setString(2, Product.getProductDescription());
        st.setBinaryStream(3, Product.getPicture());
        st.setDouble(4, Product.getPrice());
        st.setInt(5, Product.getCategoryId());
        st.setInt(6, Product.getProductId());
        return st.executeUpdate();

    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {

        String sql = "select * from product where ProductId=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, Product.getProductId());
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {

        String sql = "select * from product where CategoryId=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, Product.getCategoryId());
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
        }
        return Collections.singletonList(product);
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {

        String sql = "select * from product where Price between ? and ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setDouble(1, Product.getPrice());
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return Collections.singletonList(product);
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        String sql = "select * from product ";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return Collections.singletonList(product);
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {

        String sql = "select * from product where ProductName=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,Product.getProductName());
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return Collections.singletonList(product);
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {

        String sql = "select * from product where ProductId=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,Product.getProductId());
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()) {
            product = new Product();
            product.setPicture(rs.getBinaryStream("picture"));
        }
        return Collections.singletonList(product);
    }


    public byte[] getPictureById(Integer productId, Connection con) throws SQLException{
        byte[] imgBytes=null;
        String sql ="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs =pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgBytes=blob.getBytes(1,(int) blob.length());

        }
        return imgBytes;

    }
}