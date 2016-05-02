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
    
    private String name;
    private String price;
    private String avaiNum;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvaiNum() {
        return avaiNum;
    }

    public void setAvaiNum(String avaiNum) {
        this.avaiNum = avaiNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    @Override
    public String toString()    {
        return name;
    }
}
