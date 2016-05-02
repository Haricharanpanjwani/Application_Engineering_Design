/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory()  {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password)   {
        
        for(UserAccount user : userAccountList) {
            if((user.getUserName().equals(username)) && (user.getPassword().equals(password)))
                return user;
        }
        
        return null;
    }
    
    public UserAccount addUserAccount(String username, String password, Employee emp, Role role) {
        
        UserAccount user = new UserAccount();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmployee(emp);
        user.setRole(role);
        
        userAccountList.add(user);
        return user;
    }
    
}
