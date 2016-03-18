/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Pharmacy;

import Business.Organization.Hospital.Organization;
import Business.Pharmacy.Drug.SupplierDirectory;
import Business.Role.Hospital.ReceptionistRole;
import Business.Role.Hospital.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class StoreOrganization extends Organization  {

    private SupplierDirectory supplierDirectory;
    
    public StoreOrganization() {
        super(Organization.Type.Store.getValue());
        supplierDirectory = new SupplierDirectory();
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ReceptionistRole());
        return roles;
    }
    
}
