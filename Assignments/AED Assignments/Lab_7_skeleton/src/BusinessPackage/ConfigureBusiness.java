/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessPackage;

import Business.Employee.Employee;
import Business.Organization.AdminOrganization;
import Business.Role.AdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author hpanjwani
 */
public class ConfigureBusiness {
    
    public static Business configure()  {
        
        Business business = Business.getInstance();
        
        // Create Admin Organization
        AdminOrganization adminOrganization = new AdminOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(adminOrganization);
        
        //  Create an Employee
        Employee emp = new Employee();
        emp.setName("Hari");
        
        //  Create UserAccount
        UserAccount adminAccount = new UserAccount();
        adminAccount.setUserName("admin");
        adminAccount.setPassword("admin");
        adminAccount.setEmployee(emp);
        adminAccount.setRole(new AdminRole());
        
        adminOrganization.getEmpDir().getEmpList().add(emp);
        adminOrganization.getUserAccountDir().getUserAccountList().add(adminAccount);
                
        return business;
    }
    
}
