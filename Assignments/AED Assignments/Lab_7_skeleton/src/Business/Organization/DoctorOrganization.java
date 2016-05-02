/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class DoctorOrganization extends Organization    {
    
    public DoctorOrganization() {
        super(organizationType.Doctor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupporteRole() {
        ArrayList<Role> role = new ArrayList<>();
        role.add(new DoctorRole());
        
        return role;
    }
    
}
