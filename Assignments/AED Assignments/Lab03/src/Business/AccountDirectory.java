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
public class AccountDirectory {
    
    private ArrayList<Account> accountList;
    
    public AccountDirectory()   {
        this.accountList = new ArrayList<>();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
    
    public void addAccount(Account account) {
        
        //add the newly created object to the list
        this.accountList.add(account);
    }
    
    public void deleteAccount(Account account)   {
        this.accountList.remove(account);
    }
    
    public Account searchAccount(String accountNum) {
        
        //tracerse the account List
        for(Account a : this.accountList)   {
            //Looking for account number in the account list
            if(a.getAccountNum().equals(accountNum))    {
                return a;
            }
        }
        return null;
    }
}
