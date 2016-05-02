/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.managesupplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hpanjwani
 */
public class ManageSupplier {
    
    private static String[] dellDesktopList   = {"DD1", "DD2", "DD3", "DD4", "DD5", "DD6", "DD7", "DD8", "DD9", "DD10"};
    private static String[] dellLaptopList    = {"DL1", "DL2", "DL3", "DL4", "DL5", "DL6", "DL7", "DL8", "DL9", "DL10"};
    private static String[] hpProduct         = {"HP1", "HP2", "HP3", "HP4", "HP5", "HP6", "HP7", "HP8", "HP9", "HP10"};
    private static String[] toshibaProduct    = {"TB1", "TB2", "TB3", "TB4", "TB5", "TB6", "TB7", "TB8", "TB9", "TB10"};
    private static String[] appleProduct      = {"Mac1", "Mac2", "Mac3", "Mac4", "Mac5", "Mac6", "Mac7", "Mac8", "Mac9", "Mac10"};
    private static String[] appleDesktop      = {"iMac1", "iMac2", "iMac3", "iMac4", "iMac5", "iMac6", "iMac7", "iMac8", "iMac9", "iMac10"};
    private static String[] lenovoProduct     = {"LV1", "LV2", "LV3", "LV4", "LV5", "LV6", "LV7", "LV8", "LV9", "LV10"};
     
    public static void main(String[] args)   {
        
        SupplierDirectory supplierDirectory =  new SupplierDirectory();
        
        // Create the Supplier
        Supplier dell = supplierDirectory.addSupplier("Dell");
        Supplier hp = supplierDirectory.addSupplier("HP");
        Supplier toshiba = supplierDirectory.addSupplier("Toshiba");
        Supplier apple = supplierDirectory.addSupplier("Apple");
        Supplier lenovo = supplierDirectory.addSupplier("Lenovo");
        
        // Create the Product Catalog for each Supplier
        dell.addProductCatalog("Dell Desktop").addProduct(dellDesktopList);
        dell.addProductCatalog("Dell Laptop").addProduct(dellLaptopList);
  
        hp.addProductCatalog("HP Desktop").addProduct(hpProduct);
        
        toshiba.addProductCatalog("Toshiba Desktop").addProduct(toshibaProduct);
        apple.addProductCatalog("Apple iMac").addProduct(appleProduct);
        lenovo.addProductCatalog("Lenovo Desktop").addProduct(lenovoProduct);
       
        for(Supplier supplier : supplierDirectory.getSupplierList())    {
            for(ProductCatalog pc : supplier.getProductCatalogList())   {
                
            }
        }
        
        for(Supplier supplier : supplierDirectory.getSupplierList())  {
               System.out.println("Supplier Name : " + supplier.getName());
               System.out.println("-----------------------");
            for(ProductCatalog productCatalog : supplier.getProductCatalogList())    {
                System.out.println("ProductCatalog : " + productCatalog.getCatalogName());
                System.out.println("----------------------------");
                System.out.println("List of Products offered by " + supplier.getName() + " under "+ productCatalog.getCatalogName() + " :");
                    for(int i=0; i < productCatalog.getProductList().size(); i++)    {
                        System.out.println(productCatalog.getProductList().get(i).getProductName());
                    }
            }
            System.out.println("-------------------------------------");
        }
    
    }
}   
