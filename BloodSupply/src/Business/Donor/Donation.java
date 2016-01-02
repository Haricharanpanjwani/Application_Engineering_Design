/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import java.util.Date;

/**
 *
 * @author hpanjwani
 */
public class Donation {
    
    private int id;
    private String barCode;
    private int unit;
    private Date ResolveDate;
    private String Nurse;
    
    private static int count = 0;
    
    public Donation()   {
        count++;
        id = count;
    }
    
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getResolveDate() {
        return ResolveDate;
    }

    public void setResolveDate(Date ResolveDate) {
        this.ResolveDate = ResolveDate;
    }

    public String getNurse() {
        return Nurse;
    }

    public void setNurse(String Nurse) {
        this.Nurse = Nurse;
    }
    
    public String toString()    {
        return barCode;
    }
  
}
