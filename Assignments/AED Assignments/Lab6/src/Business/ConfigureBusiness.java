/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author hpanjwani
 */
public class ConfigureBusiness {
    
    public static Business initializeBusiness()    {
        
        Business business = Business.getInstance();
        
        //create an Employee
        Employee emp = business.getEmployeeDirectory().addEmployee();
        emp.setFirstName("Hari");
        emp.setLastName("Panjwani");
        emp.setOrganization("NEU");
        
        //add a user account
        UserAccount userAccount = business.getUserAccountDirectory().addUserAccount();
        userAccount.setUserName("admin");
        userAccount.setPassword("admin");
        userAccount.setIsActive("Yes");
        userAccount.setPerson(emp);
        userAccount.setRole(UserAccount.ADMIN_ROLE);
        
        return business;
    }
}
