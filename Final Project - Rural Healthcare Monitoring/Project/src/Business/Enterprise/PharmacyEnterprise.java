/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Hospital.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class PharmacyEnterprise extends Enterprise {
    
    public PharmacyEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Pharmacy);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
