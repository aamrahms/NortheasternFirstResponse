/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Complaint.ComplaintDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Logic.UHCS.AdvisorDirectory;
import Business.Logic.UHCS.DoctorDirectory;
import Business.Logic.OUEC.OUECCoordinatorDirectory;
import Business.Logic.NUPD.PoliceOfficerDirectory;
import Business.Logic.Redeye.DriverDirectory;
import Business.Network.Network;
import Business.Organisations.Organisation;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Student.StudentDirectory;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class EcoSystem extends Organisation{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private EnterpriseDirectory enterpriseDirectory;
    private ComplaintDirectory complaintDirectory;
    private StudentDirectory studentDirectory;
//   --------------------Not needed now, uncommenting to make program error free------------------------- 
    private PoliceOfficerDirectory policeDirectory;
    private OUECCoordinatorDirectory ouecCoordinators;
    private DoctorDirectory doctorDirectory;
    private AdvisorDirectory advisorDirectory;
    private DriverDirectory driverDirectory;
    

    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        this.complaintDirectory= new ComplaintDirectory();
        this.enterpriseDirectory= new EnterpriseDirectory();
        this.studentDirectory= new StudentDirectory();
    }

    
    public boolean checkIfUserIsUnique(String userName){
       //
       return false;
    }
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public ComplaintDirectory getComplaintDirectory() {
        return complaintDirectory;
    }

    public void setComplaintDirectory(ComplaintDirectory complaintDirectory) {
        this.complaintDirectory = complaintDirectory;
    }
    public PoliceOfficerDirectory getPoliceDirectory() {
        if (policeDirectory==null)
            this.policeDirectory= new PoliceOfficerDirectory();
        return this.policeDirectory;
    }

    public void setPoliceDirectory(PoliceOfficerDirectory policeDirectory) {
        this.policeDirectory = policeDirectory;
    }

    public StudentDirectory getStudentDirectory() {
        if(studentDirectory==null)
            this.studentDirectory = new StudentDirectory();
        
        return this.studentDirectory;
        
    }

    public void setStudentDirectory(StudentDirectory studentDirectory) {
        this.studentDirectory = studentDirectory;
        
    }

    public OUECCoordinatorDirectory getOuecCoordinators() {
        if(ouecCoordinators==null)
        {
            this.ouecCoordinators=new OUECCoordinatorDirectory();
        }
        return ouecCoordinators;
    }

    public void setOuecCoordinators(OUECCoordinatorDirectory ouecCoordinators) {
        this.ouecCoordinators = ouecCoordinators;
    }

    public DoctorDirectory getDoctorDirectory() {
        if(doctorDirectory==null)
            this.doctorDirectory= new DoctorDirectory();
        return doctorDirectory;
    }

    public void setDoctorDirectory(DoctorDirectory doctorDirectory) {
        this.doctorDirectory = doctorDirectory;
    }

    public AdvisorDirectory getAdvisorDirectory() {
        if(advisorDirectory==null)
            this.advisorDirectory= new AdvisorDirectory();
        return advisorDirectory;
    }

    public void setAdvisorDirectory(AdvisorDirectory advisorDirectory) {
        this.advisorDirectory = advisorDirectory;
    }

 

    public DriverDirectory getDriverDirectory() {
        if (driverDirectory==null)
            this.driverDirectory= new DriverDirectory();
        return driverDirectory;
    }

    public void setDriverDirectory(DriverDirectory driverDirectory) {
        this.driverDirectory = driverDirectory;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
}
