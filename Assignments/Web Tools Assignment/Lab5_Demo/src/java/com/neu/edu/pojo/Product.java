/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.pojo;

/**
 *
 * @author kumaran_jay
 */
public class Product {
    
    int productID;
    String productName, description;
    float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    

    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
