/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Hospital;

import Business.Role.Hospital.DiabeteDoctorRole;
import Business.Role.Hospital.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class DiabeteOrganization extends Organization   {

    public DiabeteOrganization() {
        super(Organization.Type.DiabeteDoctor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DiabeteDoctorRole());
        return roles;
    }
    
}
