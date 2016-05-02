/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountDirectory;
    
    public UserAccountDirectory()   {
        userAccountDirectory = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }
    
    public UserAccount addUserAccount() {
        UserAccount user = new UserAccount();
        userAccountDirectory.add(user);
        return user;
    }
    
    public void deleteUserAccount(UserAccount user) {
        userAccountDirectory.remove(user);
    }
    
}
