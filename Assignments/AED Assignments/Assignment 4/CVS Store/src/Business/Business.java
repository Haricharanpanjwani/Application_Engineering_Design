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
public class Business {
    
    private SupplierCatalog supplierCatalog;
    private StoreCatalog storeCatalog;
    
    public Business()   {
        supplierCatalog = new SupplierCatalog();
        storeCatalog = new StoreCatalog();
        
        initilization();
    }
    
    public void initilization()  {
        
        Supplier cipla = supplierCatalog.addSupplier("Cipla");
        Drug drug = cipla.getDrugCatalog().addDrug();
        drug.setDrugName("Abacavir");
        drug.setPrice(90);
        drug.setListPrice(100);
        drug.setAvail(20);
        
        Drug drug1 = cipla.getDrugCatalog().addDrug();
        drug1.setDrugName("Acetaminophen");
        drug1.setPrice(90);
        drug1.setListPrice(100);
        drug1.setAvail(15);
        
        Supplier ranbaxy = supplierCatalog.addSupplier("Ranbaxy");
        Drug drug2 = ranbaxy.getDrugCatalog().addDrug();
        drug2.setDrugName("Crocin");
        drug2.setPrice(100);
        drug2.setListPrice(110);
        drug2.setAvail(20);
        
        Drug drug3 = ranbaxy.getDrugCatalog().addDrug();
        drug3.setDrugName("Cetirizine");
        drug3.setPrice(20);
        drug3.setListPrice(30);
        drug3.setAvail(50);
        
    }

    public SupplierCatalog getSupplierCatalog() {
        return supplierCatalog;
    }

    public void setSupplierCatalog(SupplierCatalog supplierCatalog) {
        this.supplierCatalog = supplierCatalog;
    }

    public StoreCatalog getStoreCatalog() {
        return storeCatalog;
    }

    public void setStoreCatalog(StoreCatalog storeCatalog) {
        this.storeCatalog = storeCatalog;
    }
    
}
