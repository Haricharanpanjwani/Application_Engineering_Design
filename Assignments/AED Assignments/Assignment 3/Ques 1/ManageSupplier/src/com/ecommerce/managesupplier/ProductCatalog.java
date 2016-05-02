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
public class ProductCatalog {
    
    private ArrayList<Product> productList;
    String catalogName;
    
    public ProductCatalog(String catalogName) {
        productList = new ArrayList();
        this.catalogName = catalogName;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
   
    public Product addProduct(String[] productName)    {
        
        Product product = new Product(productName); 
        this.productList.add(product);
        return product;
    }
    
    public void deleteProduct(Product product)  {
        this.productList.remove(product);
    }
    
}
