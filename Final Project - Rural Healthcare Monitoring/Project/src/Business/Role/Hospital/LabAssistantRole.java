/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Hospital;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Organization.Hospital.LabOrganization;
import Business.Organization.Hospital.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.LabAssistantRole.LabAssistantWorkAreaPanel;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class LabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Business business) {
        return new LabAssistantWorkAreaPanel(userProcessContainer, account, (LabOrganization)organization, enterprise);
    }
    
    @Override
    public String toString() {
        return RoleType.LabAssistant.getValue();
    }
    
}
