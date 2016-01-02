/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomizeBusiness.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ReceptionistOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.ReceiptionRole.SelectDonorJPanel;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class ReceptionistRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel pnl, UserAccount ua, Organization o, Enterprise e, EcoSystem es) {
        return new SelectDonorJPanel(pnl, ua, (ReceptionistOrganization)o, e);
    }
   
}
