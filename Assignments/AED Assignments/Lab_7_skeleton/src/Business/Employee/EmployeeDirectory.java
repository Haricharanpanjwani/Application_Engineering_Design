/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author hpanjwani
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> empList;
    
    public EmployeeDirectory()  {
        empList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList<Employee> empList) {
        this.empList = empList;
    }
    
    public Employee addEmployee(String empName) {
        Employee emp = new Employee();
        emp.setName(empName);        
        empList.add(emp);
        return emp;
    }
    
}
