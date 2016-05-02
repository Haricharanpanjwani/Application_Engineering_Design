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
public class SupplierDirectory {
    
    private ArrayList<Supplier> supplierList;
    
    public SupplierDirectory()  {
        supplierList = new ArrayList();
    }

    public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }
    
    public Supplier addSupplier(String name) {
        
        Supplier supplier = new Supplier(name);
        this.supplierList.add(supplier);
        supplier.setName(name);
        return supplier;
    }
    
    public void deleteVitalSign(Supplier supplier)  {
        this.supplierList.remove(supplier);
    }
    
}
