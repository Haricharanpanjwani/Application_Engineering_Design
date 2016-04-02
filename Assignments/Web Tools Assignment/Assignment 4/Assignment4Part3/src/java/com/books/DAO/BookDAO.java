/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books.DAO;

import com.books.POJO.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hpanjwani
 */
public class BookDAO extends DAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void addBook(Book book) throws SQLException {

        //int customerId = 0;

        try {
            conn = getConnection();
            String queryAddBook = "INSERT INTO books values (?, ?, ?, ?)";
                                
            ps = conn.prepareStatement(queryAddBook);
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setFloat(4, book.getPrice()); 
            
            int result = ps.executeUpdate();
                            
            //String query ="insert into customer (username,password,name,city,phone) values(?,?,?,?,?)";
            //ps = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);                       
            
//            int result = ps.executeUpdate();
//            if (result > 0) {
//                rs = ps.getGeneratedKeys();
//                rs.next();
//                customerId = rs.getInt(1);
//                return customerId;
//            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();            
        }

        //return customerId;
    }
}
