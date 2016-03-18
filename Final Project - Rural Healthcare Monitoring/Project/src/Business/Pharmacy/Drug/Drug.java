/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy.Drug;

/**
 *
 * @author hpanjwani
 */
public class Drug {
 
    private int drugID;
    private String drugName;
    private int serialNumber;
    private String expDate;
    private int price;
    private int listPrice;
    private int avail;
    private String saltName;
    private String strength;
    private String stability;
    private String color;
    
    private static int count =0;
    
    public Drug() {
        count++;
        drugID = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    public int getDrugID() {
        return drugID;
    }

    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSaltName() {
        return saltName;
    }

    public void setSaltName(String saltName) {
        this.saltName = saltName;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getStability() {
        return stability;
    }

    public void setStability(String stability) {
        this.stability = stability;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Drug.count = count;
    }
    
    @Override
    public String toString() {
        return drugName; 
    }
}
