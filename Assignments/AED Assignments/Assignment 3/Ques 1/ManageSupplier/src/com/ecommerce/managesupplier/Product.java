/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.managesupplier;

import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class Product {
    
    private ArrayList<String> productName;
     
    public Product(String[] productName)    {
        
        this.productName = new ArrayList();
        
        for(int i = 0; i < productName.length; i++)   {
            this.productName.add(productName[i]);
        }
    }
    
    public ArrayList<String> getProductName()   {
        return productName;
    }
}
