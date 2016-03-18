/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Pharmacy;

import Business.Business;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.Pharmacy;
import Business.Enterprise.PharmacyEnterprise;
import Business.Organization.Hospital.Organization;
import Business.Role.Hospital.Role;
import Business.UserAccount.UserAccount;
import UserInterface.PharmacyAdminRole.PharmacyAdminWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class PharmacyAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Business business) {
        return new PharmacyAdminWorkArea(userProcessContainer, account, (PharmacyEnterprise)enterprise, business);
    }
    
    @Override
    public String toString() {
        return RoleType.PhamacyAdmin.getValue();
    }
    
}
