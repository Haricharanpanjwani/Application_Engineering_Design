/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy.Drug;

/**
 *
 * @author hpanjwani
 */
public class Supplier {
    
    private int supplierID;
    private String supplierName;
    private DrugCatalog drugCatalog;
    
    private static int sid = 1;
    
    public Supplier()   {
        drugCatalog = new DrugCatalog();
        supplierID = sid;
        sid++;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
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
