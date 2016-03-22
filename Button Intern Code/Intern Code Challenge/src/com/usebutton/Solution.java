/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usebutton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author hpanjwani
 */
public class Solution {
    
    /*  Declaring and initializing an ArrayList (array like datastructure) to 
        store the resultant array. ArrayList can store any data type. 
        It is of object type */
    public static ArrayList<Object> result = new ArrayList<>();
    
    /* 
        flatten function whose return type is array like structure
        and taking the Generic Collection as input type.

        It can be any Array like structure (example List, LinkedList, HashSet) 
        structure and can be deep nested. This fulfill are requirement for 
        deep-nested array like structure. 

        <T> is used for defining the Generic datatype, It would be of object type,
        which can be primitive data type or other collection
        Collection is used for Generic Array like structure.
    */
    public static <T> ArrayList<Object> flatten(Collection<T> input) {            
        
        /* This if condition checks, if the passed argument is null or not.
           If the collection is null, the function will not 
           enter the if loop and just pass the message, 
           collection is null
        */
        if(input != null) {
            /*
                Once we determine the collection is not null.
                We are going iterate through each element using 
                for loop. Each element can be another collection 
                (array-like structure) or primitive data type.
            */
            for(T type : input) {                    
                
                // If the object is not null, then only it will pass through this
                if(type != null) {
                // this if condition checks whether the object is instance of collection
                if(type instanceof Collection) {
                    
                    /* 
                        If the object is of type Collection,
                        same flatten function is going to be 
                        called using recurssion
                    */
                    flatten((Collection)type);
                }
                // this condition checks whether the object is an array or not                    
                else if(type.getClass().isArray()) {
                    
                    // get the componentType of the object
                    Class<?> componentType;
                    componentType = type.getClass().getComponentType();

                    // this condition checks whether the object is an array is of primitive datatype
                    //    or user defined dataype. This will work only for primitive data type
                    if (componentType.isPrimitive()) {
                        
                        // If the array is of int datatype, this condition for travesering through
                        //  that and insert the data into the array
                        if (int.class.isAssignableFrom(componentType)) {
                            for (int element : (int[]) type) {
                                result.add(element);
                            }
                        }
                        else if (boolean.class.isAssignableFrom(componentType)) {
                            for (boolean element : (boolean[]) type) {
                                result.add(element);
                            }
                        }
                        else if (byte.class.isAssignableFrom(componentType)) {
                            for (byte element : (byte[]) type) {
                                result.add(element);
                            }
                        }
                        else if (char.class.isAssignableFrom(componentType)) {
                            for (char element : (char[]) type) {
                                result.add(element);
                            }
                        }
                        else if (double.class.isAssignableFrom(componentType)) {
                            for (double element : (double[]) type) {
                                result.add(element);
                            }
                        }
                        else if (float.class.isAssignableFrom(componentType)) {
                            for (float element : (float[]) type) {
                                result.add(element);
                            }
                        }
                        else if (long.class.isAssignableFrom(componentType)) {
                            for (long element : (long[]) type) {
                                result.add(element);
                            }
                        }
                        else if (short.class.isAssignableFrom(componentType)) {
                            for (short element : (short[]) type) {
                                result.add(element);
                            }
                        }
                    }
                }
                /* this condition checks whether the object is anything 
                   other than collection or array, i.e., it is a primitve datatype */
                else {
                    
                        //elemet is going to be save in the resultant arrayList */                   
                        result.add(type);
                    }
                }
            }           
        }
        // Else loop will execute, if the collection is null
        else {
            System.out.println("Passed collection is null");            
        }
        
        /* 
            Returning the resultant arrayList(flattened array) whose
            has all the values except null. It is not deep nested array
        */
        return result;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Creating a nested array to test
        List<Object> fin = new ArrayList<>();        
        
        HashSet<List<ArrayList<Object>>> input = new HashSet<>();
        
        List<ArrayList<Object>> abc = new ArrayList<>();        
        
        ArrayList<Object> def = new ArrayList<>();
        ArrayList<Object> ghi = new ArrayList<>();
                        
        ArrayList<Object> i = new ArrayList<>();
        
        int[] ar = {11, 22, 33};
        
        i.add(null);
        i.add(null);
        abc.add(i);
        
        def.add(2);
        def.add(3.2);
        def.add(4.3);
        def.add(null);
        abc.add(def);                
        
        ghi.add(null);
        ghi.add(5.1);
        ghi.add(6.5);
        abc.add(ghi);
        
        input.add(abc);
        
        fin.add(i);
        fin.add(20.3);
        fin.add("Hii");
        fin.add(input);
        fin.add(19.8);        
        fin.add(null);
        fin.add("abc");
        fin.add(-100);
        fin.add(def);                                        
        fin.add(ar);
        
        // Calling the flatten function
        ArrayList<Object> output = flatten((Collection) fin);
        
        System.out.println("Result Array: " + output.size());
        
        for(Object obj : output) {
            System.out.print(obj + " ");
        }
    }
    
}
