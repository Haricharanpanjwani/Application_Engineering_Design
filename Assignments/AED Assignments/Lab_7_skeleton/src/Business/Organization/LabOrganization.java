/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class LabOrganization extends Organization   {
    
    public LabOrganization()    {
        super(organizationType.Lab.getValue());
    }

    @Override
    public ArrayList<Role> getSupporteRole() {
        ArrayList<Role> role = new ArrayList<>();
        role.add(new LabAssistantRole());
        
        return role;
    }
    
}
