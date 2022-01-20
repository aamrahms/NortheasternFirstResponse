/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organisations;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public abstract class Organisation {
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    public ArrayList<Role> roles;
    
    public enum Type{
        //Defined absolute values of organisation, each role
        
        StudentOrganisation("StudentOrganisation"),
        PoliceOfficerOrganisation("PoliceOfficerOrganisation"),
        ChiefOfficerOrganisation("ChiefOfficerOrganisation"),
        PoliceInvestigatorOrganisation("PoliceInvestigatorOrganisation"),
        DoctorOrganisation("DoctorOrganisation"),
        ReceptionistOrganisation("ReceptionistOrganisation"),
        AdvisorOrganisation("AdvisorOrganisation"),
        PresidentOrganisation("PresidentOrganisation"),
        OUECCoordinatorOrganisation("OUECCoordinatorOrganisation"),
        OUECInvestigatorOrganisation("OUECInvestigatorOrganisation"),
        DriverOrganisation("DriverOrganisation") ;
        //SysAdmin("Sysadmin");
        
        private String value;//inside bracs value
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organisation(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        roles= new ArrayList<>();
        ++counter;
    }
    public Organisation(){
        
    }
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
