/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.java8;

/**
 *
 * @author hpanjwani
 */
public class LambdaDemo {               
    
    public static void main(String[] args) {
        // TODO code application logic here
        //MyRunnable r = new MyRunnable();
        
        //Inner Class
        Runnable r = new Runnable() {

            @Override
            public void run() {
                System.out.println("Implementing Inner class to run the thread");
            }
        };
        
        //Anonymous class
        new Thread(
            new Runnable() {

            @Override
            public void run() {
                System.out.println("Implementing Anonymous class to run the thread");
            }                
        }).start();
        
        
        
        //Lambda
        //Runnable r = () ->  System.out.println("Thread is started");
    
        new Thread(r).start();
    }   

}
