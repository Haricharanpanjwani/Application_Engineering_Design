/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.organizationType;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory()  {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(organizationType type)   {
        
        Organization organization = null;
        
        if(type.getValue().equals(organizationType.Doctor.getValue()))  {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }   
        else if(type.getValue().equals(organizationType.Lab.getValue()))  {
                organization = new LabOrganization();
                organizationList.add(organization);
        }
        else if(type.getValue().equals(organizationType.Admin.getValue()))  {
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
    
}
