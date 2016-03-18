/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Patient.Order.MasterOrderCatalog;
import Business.Person.Person;
import Business.Patient.Order.OrderCatalog;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author hpanjwani
 */
public class Patient extends Person {
   
    private int pID;
    private String lastName;
    private Date dob;
    private int age;
    private UserAccount pDocName;
    private String pharmacy;
    private String address;
    private String town;
    private int zipCode;
    private String occupation;
    private String email;
    private double phoneNumber;
    private String gender;

    //private ArrayList<Order> orderHistory;
    private OrderCatalog orderCatalog;
    private MasterOrderCatalog masterOrderCatalog;
    
    private String disease;
    
    private VitalSignHistory vitalSignList;
    private AppointmentHistory appointmentHistory;
    
    public Patient() {
        super();
        //orderHistory = new ArrayList<>();
        orderCatalog = new OrderCatalog();
        masterOrderCatalog = new MasterOrderCatalog();
        vitalSignList = new VitalSignHistory(); 
        appointmentHistory = new AppointmentHistory();
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserAccount getpDocName() {
        return pDocName;
    }

    public void setpDocName(UserAccount pDocName) {
        this.pDocName = pDocName;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
    
    public VitalSignHistory getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(VitalSignHistory vitalSignList) {
        this.vitalSignList = vitalSignList;
    }

    public AppointmentHistory getAppointmentHistory() {
        return appointmentHistory;
    }

    public void setAppointmentHistory(AppointmentHistory appointmentHistory) {
        this.appointmentHistory = appointmentHistory;
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

//    public ArrayList<Order> getOrderHistory() {
//        return orderHistory;
//    }
//
//    public void setOrderHistory(ArrayList<Order> orderHistory) {
//        this.orderHistory = orderHistory;
//    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }
}
