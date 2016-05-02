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
public class SupplierCatalog {
    
    private ArrayList<Supplier> supplierCatalog;
    
    public SupplierCatalog()    {
        supplierCatalog = new ArrayList<>();
    }

    public ArrayList<Supplier> getSupplierCatalog() {
        return supplierCatalog;
    }

    public void setSupplierCatalog(ArrayList<Supplier> supplierCatalog) {
        this.supplierCatalog = supplierCatalog;
    }
    
    public Supplier addSupplier(String name){
        Supplier s = new Supplier();
        s.setSupplierName(name);
        supplierCatalog.add(s);
        return s;
    }
    
    public void removeSupplier(Supplier s){
        supplierCatalog.remove(s);
    }
    
    public Supplier searchSupplier(String search){
        for (Supplier supplier : supplierCatalog) {
            if(supplier.getSupplierName().equals(search)){
                return supplier;
            }
        }
        return null;
    }
    
}
