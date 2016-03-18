/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Hospital;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Organization.Hospital.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.PatientRole.PatientWorkAreaPanel;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class PatientRole extends Role   {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Business business) {
        return new PatientWorkAreaPanel(userProcessContainer, account, enterprise, business);
    }
    
    @Override
    public String toString() {
        return RoleType.Patient.getValue();
    }
    
}
