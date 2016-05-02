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

public class Supplier {
    
    private ProductCatalog productCatalog;
    private ArrayList<ProductCatalog> productCatalogList;
    private String name;
    
    public Supplier(String name)   {
        this.name = name;
        productCatalogList = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ProductCatalog> getProductCatalogList() {
        return productCatalogList;
    }
   
    
    public ProductCatalog addProductCatalog(String catalogName) {
        productCatalog = new ProductCatalog(catalogName);
        productCatalogList.add(productCatalog);
        return productCatalog;
    }
}
