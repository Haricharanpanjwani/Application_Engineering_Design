/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author hpanjwani
 */
public class Supplier {
    
    private String supplierName;
    private DrugCatalog drugCatalog;
    
    public Supplier()   {
        drugCatalog = new DrugCatalog();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    public void setDrugCatalog(DrugCatalog drugCatalog) {
        this.drugCatalog = drugCatalog;
    }
    
    @Override
    public String toString()    {
        return supplierName;
    }
}
