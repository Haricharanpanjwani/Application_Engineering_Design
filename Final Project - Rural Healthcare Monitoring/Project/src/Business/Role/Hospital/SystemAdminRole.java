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
import UserInterface.SystemAdminRole.SystemAdminWorkAreaPanel;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class SystemAdminRole extends Role   {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Business business) {
        return new SystemAdminWorkAreaPanel(userProcessContainer, business);
    }
    
}
