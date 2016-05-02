/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class ProductCatalog {
    
    private ArrayList<Product> productList;
    
    public ProductCatalog() {
        productList = new ArrayList();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    public Product addProduct() {
        
        Product product = new Product();
        productList.add(product);
        return product;
    }
    
    public void removeProduct(Product product)    {
        productList.remove(product);
    }
    
    public Product searchProduct(int model)   {
        
        for(Product product : productList)  {
            if(product.getModelNo() == model)
                return product;
        }
        return null;
    }
    
}
