/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public abstract class Enterprise extends Organization    {
    
    private EnterpriseType entType;
    private OrganizationDirectory organizationDirectory;
    
    public Enterprise(String name, EnterpriseType type)    {
        super(name);
        this.entType = type;
        this.organizationDirectory = new OrganizationDirectory();
    }
    
    public enum EnterpriseType{
        Hospital("Hospital");
        
        private String value;
        
        private EnterpriseType(String value)    {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
        
    }

    public EnterpriseType getEntType() {
        return entType;
    }

    public void setEntType(EnterpriseType entType) {
        this.entType = entType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
    @Override
    public abstract ArrayList<Role> getSupportedRole();
    
}
