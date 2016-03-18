/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.Person;
import Business.Role.Hospital.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author hpanjwani
 */
public class ConfigureSystem {
    
    public static Business configure(){
        
        Business system = Business.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Person employee = system.getPersonDirectory().createPerson("RRH");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("northeastern", "northeastern", employee, new SystemAdminRole());
        
        return system;
    }
}
