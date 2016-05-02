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
public class StoreCatalog {
    
    private ArrayList<Store> storeCatalog;
    
    public StoreCatalog()   {
        storeCatalog = new ArrayList<>();
    }

    public ArrayList<Store> getStoreCatalog() {
        return storeCatalog;
    }

    public void setStoreCatalog(ArrayList<Store> storeCatalog) {
        this.storeCatalog = storeCatalog;
    }
    
    public Store addStore() {
        Store store = new Store();
        storeCatalog.add(store);
        return store;
    }
    
    public void removeStore(Store store)   {
        storeCatalog.remove(store);
    }
}
