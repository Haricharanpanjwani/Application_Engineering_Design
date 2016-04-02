/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intuit.quickbase;

import com.intuit.quickbase.devint.ConcreteStatService;
import com.intuit.quickbase.devint.DBStatService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;


/**
 *
 * @author hpanjwani
 */
public class MergeStatServiceHashMap {
    
    public void retrieveCountryPopulationList() {
    
            DBStatService dbStatService = new DBStatService();    
            List<Pair<String, Integer>> dbList = dbStatService.GetCountryPopulations();             
            
            ConcreteStatService conStatService = new ConcreteStatService();
            List<Pair<String, Integer>> apiList = conStatService.GetCountryPopulations();                        
            
            List<Pair<String, Integer>> modifiedAPIList = new ArrayList<>();
            
            if(apiList != null) {        
                
                // Converting the keys of each element in the API list to lowercase                                                                
                Iterator iterator = apiList.iterator();
                
                while(iterator.hasNext()) {
                    Pair<String, Integer> pair = (Pair)  iterator.next();
                    String key = pair.getKey().toLowerCase();
                    Integer value = pair.getValue();                    
                    
                    modifiedAPIList.add(new ImmutablePair<String, Integer>(key, value));
                }                                
            }
            
            if(modifiedAPIList != null) {
                Iterator iterator = modifiedAPIList.iterator();
                
                while(iterator.hasNext()) {
                    Pair<String, Integer> pair = (Pair)  iterator.next();
                    System.out.println("key: " + pair.getLeft() + ": value: " + pair.getRight());
                }
            }                
            
//                if(dbList != null) {
//                    // Merge two list and remove duplicates
//                    Collection<Pair<String, Integer>> result = Stream.concat(dbList.stream(), modifiedAPIList.stream())
//                            .filter(pred)
//                            .collect( Collectors.toMap(Pair::getLeft, p -> p, (p, q) -> p, LinkedHashMap::new))
//                            .values();  
//                                        
//                    // Need to Convert collection to List
//                    List<Pair<String, Integer>> merge = new ArrayList<>(result);            
//                    merge.forEach(pair -> System.out.println("key: " + pair.getLeft() + ": value: " + pair.getRight()));
//                    
//                }
//                else {
//                    System.out.println("Country list retrieved form database is empty");
//                } 
//            } else {
//                System.out.println("Country list retrieved form API is empty");
//            }
    }
}
