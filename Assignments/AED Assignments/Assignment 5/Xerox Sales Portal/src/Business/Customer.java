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
public class Customer {
    
    private int customerID;
    private String customerName;
    private float saleVolume;
    
    private OrderCatalog orderCatalog;
    
    private static int i = 0;
    
    public Customer()   {
        customerID = ++i;
        orderCatalog = new OrderCatalog();
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(float volume) {
        this.saleVolume = volume;
    }
    
    @Override
    public String toString()    {
        return customerName;
    }
}
