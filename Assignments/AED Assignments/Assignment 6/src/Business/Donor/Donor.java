/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class Donor extends Employee {
    
    private ArrayList<Donation> donationList;
    
    private String bloodGroup;
    private int age;
    
    public Donor()  {
        super();
        donationList = new ArrayList<>();
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Donation> getDonationList() {
        return donationList;
    }

    public void setDonationList(ArrayList<Donation> donationList) {
        this.donationList = donationList;
    }
    
    public Donation addDonation()   {
        Donation donation = new Donation();
        donationList.add(donation);
        return donation;
    }
}
