/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import org.w3c.dom.UserDataHandler;

/**
 *
 * @author hpanjwani
 */
public abstract class Organization {
    
    private EmployeeDirectory empDir;
    private UserAccountDirectory userAccountDir;
    private WorkQueue workQueue;
    private String name;
    private int orgId;
    
    private static int i = 0;
    
    public Organization(String name)   {
        
        orgId = ++i;
        
        this.name = name;
        workQueue = new WorkQueue();
        userAccountDir = new UserAccountDirectory();
        empDir = new EmployeeDirectory();
    }
    
    public enum organizationType    {
        
        Admin("Admin Organization"),
        Doctor("Doctor Organization"),
        Lab("Lab Organization");
        
        private String value;
        
        private organizationType(String value)  {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        @Override
        public String toString()    {
            return value;
        }
    }
    
    public abstract ArrayList<Role> getSupporteRole();

    public EmployeeDirectory getEmpDir() {
        return empDir;
    }

    public void setEmpDir(EmployeeDirectory empDir) {
        this.empDir = empDir;
    }

    public UserAccountDirectory getUserAccountDir() {
        return userAccountDir;
    }

    public void setUserAccountDir(UserAccountDirectory userAccountDir) {
        this.userAccountDir = userAccountDir;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }
    
    @Override
    public String toString()    {
        return name;
    }
    
}
