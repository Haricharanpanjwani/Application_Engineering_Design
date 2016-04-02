/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author yash
 */
public class UserDao {

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    DataSource dataSource;
    QueryRunner queryRunner;

    public UserDao(DataSource dataSource) {

        this.dataSource = dataSource;
        queryRunner = new QueryRunner(dataSource);

    }

    public void addUser(User user) throws SQLException {

        String query = "insert into users (First,Last,AboutMe,Gender,Email,PhotoName) values(?,?,?,?,?,?)";
        int result = queryRunner.update(query, user.getFirst(), user.getLast(), user.getAboutMe(), user.getGender(), user.getEmail(), user.getPhotoName());
        
        if (result > 0) {
            System.out.println("Success");
        }

    }

    public List<User> searchUsers(String key, String flag) {

        List<User> userList = null;
        try {

            ResultSetHandler<List<User>> resultSetHandler = new BeanListHandler<>(User.class);
            String q = "select * from users";

            if (flag.equalsIgnoreCase("first")) {
                q += " where first LIKE '" + key + "%'";
            } else if (flag.equalsIgnoreCase("last")) {
                q += " where last LIKE '" + key + "%'";
            } else if (flag.equalsIgnoreCase("email")) {
                q += " where email LIKE '" + key + "'";
            } else if (flag.equalsIgnoreCase("gender")) {
                q += " where gender LIKE '" + key + "'";
            }

            userList = queryRunner.query(q, resultSetHandler);

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userList;
    }

}
