/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic.Redeye;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class DriverDirectory {
    ArrayList<Driver> driverList;

    public DriverDirectory() {
        driverList = new ArrayList<Driver>();
    }

    public ArrayList<Driver>  getDriverList() {
        return driverList;
    }

    public void setDriverList(ArrayList<Driver> driverList) {
        this.driverList = driverList;
    }
    
    public void createDriver(Employee e){
        Driver d = new Driver(e);
        driverList.add(d);
    }

    //first update in Employee Directory it returns Employee object and call below one
    public void updateDriver(Driver d, Employee e){
        for (Driver driver : driverList) {
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

    public void deleteDriver (Driver driver, Employee e) {
        for (Driver d : driverList) {
            if (d.getEmployee().getUsername().equals(e.getName())) {
                driverList.remove(d);
                return;
            }
        }        
    }
}
