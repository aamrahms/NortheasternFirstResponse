/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Complaint.Complaint;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;
    private int id;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String neuid;
    private static int count = 1;
    private boolean isFree;
    ArrayList<Complaint> complaintsList;
    
    public Employee(String name, String username, String password, String address, String phone, String email, String neuid) {
        id = count;
        count++;
        
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.neuid = neuid;
        isFree = true;
        this.complaintsList = new ArrayList<Complaint>();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNeuid() {
        return neuid;
    }

    public void setNeuid(String neuid) {
        this.neuid = neuid;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    public ArrayList<Complaint> getComplaintsList() {
        return complaintsList;
    }

    public void setComplaintsList(ArrayList<Complaint> complaintsList) {
        this.complaintsList = complaintsList;
    }
    
    public void addComplaintToList (Complaint c) {
        this.complaintsList.add(c);
    }

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }
    
    
    
}
