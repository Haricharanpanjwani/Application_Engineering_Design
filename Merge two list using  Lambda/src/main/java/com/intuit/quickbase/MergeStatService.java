/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intuit.quickbase;

import com.intuit.quickbase.devint.ConcreteStatService;
import com.intuit.quickbase.devint.DBStatService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 *
 * @author hpanjwani
 */

public class MergeStatService {
    
        public void retrieveCountryPopulationList() {
    
            DBStatService dbStatService = new DBStatService();    
            List<Pair<String, Integer>> dbList = dbStatService.GetCountryPopulations();             
            
            ConcreteStatService conStatService = new ConcreteStatService();
            List<Pair<String, Integer>> apiList = conStatService.GetCountryPopulations();  
            
            //Use of Predicate Interface
            Predicate<Pair<String, Integer>> pred = (pair) -> pair != null;            
            
            if(apiList != null) {        
                // Converting the keys of each element in the API list to lowercase
                List<Pair<String, Integer>> modifiedAPIList = apiList.stream()       
                                            .filter(pred)
                                            .map(p -> new ImmutablePair<String, Integer>(p.getKey().toLowerCase(), p.getValue()))
                                            .collect(Collectors.toList());
                //modifiedAPIList.forEach(pair -> System.out.println("key: " + pair.getLeft() + ": value: " + pair.getRight()));                      
            
                if(dbList != null) {
                    // Merge two list and remove duplicates
                    Collection<Pair<String, Integer>> result = Stream.concat(dbList.stream(), modifiedAPIList.stream())
                            .filter(pred)
                            .collect( Collectors.toMap(Pair::getLeft, p -> p, (p, q) -> p, LinkedHashMap::new))
                            .values();  
                                        
                    // Need to Convert collection to List
                    List<Pair<String, Integer>> merge = new ArrayList<>(result);            
                    merge.forEach(pair -> System.out.println("key: " + pair.getKey() + ": value: " + pair.getValue()));
                    
                }
                else {
                    System.out.println("Country list retrieved form database is empty");
                } 
            } else {
                System.out.println("Country list retrieved form API is empty");
            }                                   
            
//            if(apiList != null) {
//                Iterator itr = apiList.iterator();
//                for(Pair<String, Integer> pair : apiList){                    
//                    //System.out.println("key: " + pair.getLeft() + ": value: " + pair.getRight());
//                }                
//            }    
            
        }
}
