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
public class OrderCatalog {
    
    private ArrayList<Order> orderCatalog;
    
    public OrderCatalog()   {
        orderCatalog = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    
    public Order addOrder(Order order) {
        
        orderCatalog.add(order);
        return order;
    }
    
}
