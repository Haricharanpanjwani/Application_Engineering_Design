/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import BusinessPackage.Business;
import UserInterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class LabAssistantRole extends Role  {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Business business) {
        return new LabAssistantWorkAreaJPanel(userProcessContainer);
    }
    
    
}
