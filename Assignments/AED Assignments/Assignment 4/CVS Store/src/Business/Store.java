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
public class Store {
    
    private DrugCatalog drugCatalog;
    private int locationID;
    private String storeName;
    private String location;
    private String street;
    private String city;
    
    private static int counter =0;
    
    public Store()  {
        counter++;
        locationID = counter;
        drugCatalog = new DrugCatalog();
    }

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    public void setDrugCatalog(DrugCatalog drugCatalog) {
        this.drugCatalog = drugCatalog;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Store.counter = counter;
    }
    
    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
           
    @Override
    public String toString()    {
        return location;
    }
}
