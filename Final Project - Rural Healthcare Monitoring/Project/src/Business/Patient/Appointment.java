/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Medicine.Medicine;
import Business.Person.Person;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hpanjwani
 */
public class Appointment {
  
    private ArrayList<Medicine> prescribeMedicineList;
    private ArrayList<String> prescribeLabTest;
    private String additonalNotes;
    private Person docName;
    private Date date;
    private String Disease;
    
    public Appointment()   {
        prescribeMedicineList = new ArrayList<>();
        prescribeLabTest = new ArrayList<>();
    }

    public ArrayList<Medicine> getPrescribeMedicineList() {
        return prescribeMedicineList;
    }

    public void setPrescribeMedicineList(ArrayList<Medicine> prescribeMedicineList) {
        this.prescribeMedicineList = prescribeMedicineList;
    }

    public ArrayList<String> getPrescribeLabTest() {
        return prescribeLabTest;
    }

    public void setPrescribeLabTest(ArrayList<String> prescribeLabTest) {
        this.prescribeLabTest = prescribeLabTest;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String Disease) {
        this.Disease = Disease;
    }

    public Person getDocName() {
        return docName;
    }

    public void setDocName(Person docName) {
        this.docName = docName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAdditonalNotes() {
        return additonalNotes;
    }

    public void setAdditonalNotes(String additonalNotes) {
        this.additonalNotes = additonalNotes;
    }
    
    public String toString()    {
        return String.valueOf(date);
    }
}
