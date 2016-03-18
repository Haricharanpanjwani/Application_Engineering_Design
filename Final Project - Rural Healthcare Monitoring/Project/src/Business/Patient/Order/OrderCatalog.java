/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient.Order;

import Business.Pharmacy.Drug.Drug;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hpanjwani
 */
public class OrderCatalog {
    
    private ArrayList<Order> orderCatalog;
    
    public OrderCatalog()   {
        orderCatalog = new ArrayList<>();
    }

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    
    public Order addOrder(int quantity, int price, Drug drug) {
       
        float volume = quantity * price;
        
        Order order = new Order();
        
        order.setDrug(drug);
        order.setQuantity(quantity);
        order.setSalePrice(price);
        order.setVolume(volume);
        order.setOrderDate(new Date());
        
        orderCatalog.add(order);
        return order;
    }
    
    public Order addOrder(Order order) {
        orderCatalog.add(order);
        return order;
    }
}
