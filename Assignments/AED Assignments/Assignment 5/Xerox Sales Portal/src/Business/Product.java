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
public class Product {
    
    private int prodID;
    private String prodName;
    private int avail;
    private int floorPrice;
    private float targetPrice;
    private float ceilingPrice;
    
    private static int count =0;

    public Product() {
    count++;
    prodID = count;
    }

    public int getProdID() {
        return prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(int floorPrice) {
        this.floorPrice = floorPrice;
    }

    public float getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice() {
        this.targetPrice = ((floorPrice + ceilingPrice) / 2);
    }

    public float getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice() {
        this.ceilingPrice = (floorPrice * 2);
    }
    
    @Override
    public String toString() {
        return prodName; 
    }
    
}
