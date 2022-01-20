/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name, String username, String password, String address, String phone, String email, String neuid){
        Employee employee = new Employee(name, username, password,address, phone, email, neuid);
        employeeList.add(employee);
        return employee;
    }
    
    //returns Employee object to update in respective classes as well
    public Employee updateEmployee(String name, String username, String password, String address, String phone, String email, String neuid){
        for (Employee employee : employeeList) {
            if (employee.getUsername().equals(username)) {
                employee.setName(name);
                employee.setEmail(email);
                employee.setAddress(address);
                employee.setNeuid(neuid);
                employee.setPhone(phone);
                employee.setPassword(password);
            }
        }
        return new Employee(name, username, password,address, phone, email, neuid);
    }

    public void deleteEmployee(Employee e) {
                employeeList.remove(e);                
    }
    
}