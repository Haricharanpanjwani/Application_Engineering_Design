/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient.Order;

import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class MasterOrderCatalog {
    
    private ArrayList<OrderCatalog> masterOrderCatalog;
    
    public MasterOrderCatalog()   {
        masterOrderCatalog = new ArrayList<>();
    }

    public ArrayList<OrderCatalog> getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(ArrayList<OrderCatalog> masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }
    
    public OrderCatalog addOrder(OrderCatalog orderCatalog) {
   
        masterOrderCatalog.add(orderCatalog);
        return orderCatalog;
    }
}
