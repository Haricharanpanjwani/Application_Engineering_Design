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
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeDirectory;
    
    public EmployeeDirectory()  {
        employeeDirectory = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeDirectory;
    }
    
    public Employee addEmployee()   {
        Employee emp = new Employee();
        employeeDirectory.add(emp);
        return emp;
    }
    
    public void deleteEmployee(Employee emp)    {
        employeeDirectory.remove(emp);
    }
    
}
