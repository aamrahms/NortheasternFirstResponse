/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic.UHCS;

import Business.Complaint.Complaint;
import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class Receptionist {
    
    Employee employee;
    Complaint complaint;
    ArrayList<Complaint> complaintsList;

    public Receptionist(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public ArrayList<Complaint> getComplaintsList() {
        return complaintsList;
    }

    public void setComplaintsList(ArrayList<Complaint> complaintsList) {
        this.complaintsList = complaintsList;
    }

    
    
}
