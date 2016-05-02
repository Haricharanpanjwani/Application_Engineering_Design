/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory()    {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise createEnterprise(String name, EnterpriseType type)    {
        Enterprise enterprise = null;
        
        if(type == EnterpriseType.Hospital) {        
            enterprise = new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }
    
}
