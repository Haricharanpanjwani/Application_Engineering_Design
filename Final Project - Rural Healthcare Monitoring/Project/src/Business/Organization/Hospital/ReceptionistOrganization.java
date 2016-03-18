/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Hospital;

import Business.Role.Hospital.ReceptionistRole;
import Business.Role.Hospital.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class ReceptionistOrganization extends Organization  {
    
    public ReceptionistOrganization() {
        super(Organization.Type.Receptionist.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ReceptionistRole());
        return roles;
    }
}
