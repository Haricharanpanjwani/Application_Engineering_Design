/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intuit.quickbase.devint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author hpanjwani
 */
/* This class is created so that DB connection functionality 
    can be separated from the query's for different tables
*/
public class DBStatService extends DBManagerImpl implements IStatService {        
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;    
    
    @Override
    public List<Pair<String, Integer>> GetCountryPopulations() {                

        List<Pair<String, Integer>> list = new ArrayList<Pair<String, Integer>>();                
        
        try {                        
            
            System.out.println("Starting.");
            System.out.print("Getting DB Connection...");
            
            conn = getConnection();
            
            if(conn  != null) {
                String query ="SELECT countryName, SUM(population) as population \n" +
                              "FROM country c\n" +
                              " LEFT JOIN state s ON s.CountryID = c.CountryID\n" +
                              " LEFT JOIN city ON city.StateID = s.StateID\n" +
                              "GROUP BY countryName\n" +
                              "ORDER BY countryName";

                ps = conn.prepareStatement(query);            
                rs = ps.executeQuery();

                while(rs.next()){                                    
                    
                    ImmutablePair<String, Integer> pair = 
                            new ImmutablePair<String, Integer>(rs.getString("countryName").toLowerCase(),rs.getInt("population"));
                    //rs.getString("countryName");
                    //rs.getString("population");                                        
                    list.add(pair);
                }
                return list;
            }
            else {
                System.out.println("Connection failed.");                                
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBStatService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {                        
            try {                
                ps.close();
                rs.close();
                //close(conn);
            }             
            catch (SQLException ex) {
                Logger.getLogger(DBStatService.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        return null;
    }      
    
}
