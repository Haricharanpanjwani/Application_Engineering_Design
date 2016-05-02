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
public class Order {
    
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private static int count = 0;
    
    public Order()  {
        
        orderItemList = new ArrayList<OrderItem>();
        count++;
        orderNumber = count;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
    
    private void removeOrderItem(OrderItem item)    {
        orderItemList.remove(item);
    } 
    
    public OrderItem addOrderItem(int quantity, int price, Product p) {
        
        OrderItem item = new OrderItem();
        item.setProduct(p);
        item.setQuantity(quantity);
        item.setSalePrice(price);
        
        orderItemList.add(item);
        return item;
    }
    
}
