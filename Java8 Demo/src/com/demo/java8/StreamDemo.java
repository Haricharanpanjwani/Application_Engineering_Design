package com.demo.java8;

import com.demo.pojo.Person;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hpanjwani
 */
public class StreamDemo {
    
    public static void main(String[] args) {
        
        List<Person> personList = new ArrayList<>();   

        personList.add(new Person("Mike", 25));
        personList.add(new Person("Mary", 45));
        personList.add(new Person("Joe", 75));
        personList.add(new Person("Mike", 55));
    
        int sum = personList.stream()
                      .filter(w -> w.getName() == "Mike")
                      .mapToInt(w -> w.getAge())
                      .sum();
        
        System.out.println("Sum of age's of all Mike is: " + sum);
    }
}
