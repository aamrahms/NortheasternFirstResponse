/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic.Redeye;

import Business.Complaint.Complaint;
import java.util.ArrayList;
import Business.Employee.Employee;
/**
 *
 * @author aamrah
 */
public class Driver {
    Employee employee;
    ArrayList<Complaint> ridesList;
    Complaint complaint;
    
    public Driver(Employee employee) {
        this.employee = employee;
        this.ridesList= new ArrayList<Complaint>();
    }

    public ArrayList<Complaint> getRidesList() {
        return ridesList;
    }

    public void setRidesList(ArrayList<Complaint> ridesList) {
        this.ridesList = ridesList;
    }



    public Complaint getComplaint() {
            return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

