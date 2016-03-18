/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Hospital;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Organization.Hospital.DoctorOrganization;
import Business.Organization.Hospital.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DoctorRole.DoctorWorkAreaPanel;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class DoctorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Business business) {
        return new DoctorWorkAreaPanel(userProcessContainer, account, (DoctorOrganization)organization, enterprise, business);
        //return new SelectDiabeticPatient(userProcessContainer, organization);
    }
    
    @Override
    public String toString() {
        return RoleType.Doctor.getValue();
    }
    
}
