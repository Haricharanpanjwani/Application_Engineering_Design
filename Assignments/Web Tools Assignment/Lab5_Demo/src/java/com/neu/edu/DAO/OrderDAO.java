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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kumaran_jay
 */
public class OrderDAO extends DAO {

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    public void checkout(int customerId, ArrayList<Product> cart) {

        try {
            int orderId = 0;
            conn = getConnection();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String orderDate = dateFormat.format(date);
            String query = "insert into orders (customerId, orderDate) values(?,?)";
            ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            ps.setString(2, orderDate);

            int result = ps.executeUpdate();
            if (result > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                orderId = rs.getInt(1);
            }
            ps.close();
            rs.close();

            String query2 = "insert into orderdetails (orderid, productid, unitprice) values(?,?,?)";
            for (Product p : cart) {
                ps = conn.prepareStatement(query2);
                ps.setInt(1, orderId);
                ps.setInt(2, p.getProductID());
                ps.setFloat(3, p.getPrice());
                ps.executeUpdate();

            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close(conn);
        }
    }
}
