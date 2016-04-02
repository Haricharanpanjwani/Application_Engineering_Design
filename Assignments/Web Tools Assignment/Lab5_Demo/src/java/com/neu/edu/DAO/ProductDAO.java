/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.DAO;

import com.neu.edu.pojo.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.test.web.servlet.ResultHandler;

/**
 *
 * @author kumaran_jay
 */
public class ProductDAO extends DAO {

    Connection conn;

    public List<Product> getAllProducts() {

        List<Product> productList = null;
        try {
            conn = getConnection();
            QueryRunner runner = new QueryRunner();
            ResultSetHandler<List<Product>> resultSetHandler = new BeanListHandler<>(Product.class);
            String q = "select * from products";
            productList = runner.query(conn, q, resultSetHandler);

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
        }

        return productList;
    }

    public Product getProductById(int id) {

        Product product = null;
        try {
            conn = getConnection();
            QueryRunner runner = new QueryRunner();
            ResultSetHandler<Product> result = new BeanHandler<>(Product.class);
            String q = "select * from products where productid=?";
            product = runner.query(conn, q, result, id);

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(conn);
        }

        return product;
    }
}
