/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient.Order;

import Business.Pharmacy.Drug.Drug;
import Business.Pharmacy.Drug.Supplier;
import java.util.Date;

/**
 *
 * @author hpanjwani
 */
public class Order {
    
    private Drug drug;
    private int quantity;
    private float salePrice;
    private float volume;
    private String pharmacy;
    private Date orderDate;
    private Supplier supplier;
    
    public Order()  {
        drug = new Drug();
    }
    
    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public String toString()    {
        return drug.getDrugName();
    }
}
