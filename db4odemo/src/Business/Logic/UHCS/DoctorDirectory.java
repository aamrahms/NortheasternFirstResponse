/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic.UHCS;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class DoctorDirectory {
    
    ArrayList<Doctor> doctorList;

    public DoctorDirectory() {
        doctorList = new ArrayList<Doctor>();
    }

    public ArrayList<Doctor>  getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public void createDoctor(Employee e){
        Doctor d = new Doctor(e);
        doctorList.add(d);
    }

    //first update in Employee Directory it returns Employee object and call below one
    public void updateDoctor(Doctor d, Employee e){
        for (Doctor driver : doctorList) {
            if (d.getEmployee().getUsername().equals(e.getUsername())) {
                d.getEmployee().setName(e.getName());
                d.getEmployee().setPassword(e.getPassword());
                d.getEmployee().setAddress(e.getAddress());
                d.getEmployee().setEmail(e.getEmail());
                d.getEmployee().setNeuid(e.getNeuid());
                d.getEmployee().setPhone(e.getPhone());
            }
        }
    }

    public void deleteDoctor (Doctor driver, Employee e) {
        for (Doctor d : doctorList) {
            if (d.getEmployee().getUsername().equals(e.getName())) {
                doctorList.remove(d);
                return;
            }
        }        
    }
    
    public Doctor fetchDoctorWithUserName (String userName) {
        for (Doctor d : doctorList) {
            if (d.getEmployee().getUsername().equals(userName)) {
                return d;
            }
        }
        return null;
    }
    
}
