/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class AppointmentHistory {
    
    private ArrayList<Appointment> appointmentHistory;
    
    public AppointmentHistory()    {
        appointmentHistory = new ArrayList<>();
    }

    public ArrayList<Appointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    public void setAppointmentHistory(ArrayList<Appointment> appointmentHistory) {
        this.appointmentHistory = appointmentHistory;
    }
    
    public Appointment addAppointment() {
        
        Appointment app = new Appointment();
        appointmentHistory.add(app);
        return app;
    }
    
    public void removeAppointment(Appointment appoint) {
        appointmentHistory.remove(appoint);
    }
}
