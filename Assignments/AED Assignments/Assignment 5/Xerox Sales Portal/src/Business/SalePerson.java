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
public class SalePerson {
    
    private int salesID;
    private String name;
    private float commission;
    private float saleVolume;
    private int aboveTargetPrice = 0;
    private int belowTargetPrice = 0;
    
    private OrderCatalog orderCatalog;
    
    private static int i = 0;
    
    public SalePerson()    {
        i++;
        salesID = i;
        orderCatalog = new OrderCatalog();
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public int getAboveTargetPrice() {
        return aboveTargetPrice;
    }

    public void setAboveTargetPrice(int aboveTargetPrice) {
        this.aboveTargetPrice = aboveTargetPrice;
    }

    public int getBelowTargetPrice() {
        return belowTargetPrice;
    }

    public void setBelowTargetPrice(int belowTargetPrice) {
        this.belowTargetPrice = belowTargetPrice;
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    public int getSalesID() {
        return salesID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(float saleVolume) {
        this.saleVolume = saleVolume;
    }
    
    @Override
    public String toString()    {
        return name;
    }
}
