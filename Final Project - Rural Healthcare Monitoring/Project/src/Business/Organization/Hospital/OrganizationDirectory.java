/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Hospital;

import Business.Organization.Pharmacy.StoreOrganization;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.DiabeteDoctor.getValue())){
            organization = new DiabeteOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Receptionist.getValue())){
            organization = new ReceptionistOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        //Pharmacy Enterprise
        else if (type.getValue().equals(Organization.Type.Store.getValue())){
            organization = new StoreOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}
