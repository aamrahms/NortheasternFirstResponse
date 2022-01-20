/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Complaint;

import Business.Logic.NUPD.PoliceOfficer;
import Business.Logic.OUEC.OUECCoordinator;
import Business.Logic.Redeye.Driver;
import Business.Logic.UHCS.Advisor;
import Business.Logic.UHCS.Doctor;
import Business.Student.Student;
import java.util.Date;

/**
 *
 * @author aamrah
 */
public class Complaint {
    
    private static int count =0;
    private String ComplaintID;
    private String status;
    private Student victimStudent;
    private String typeOfComplaint;
    private String dateOfIncident;
    private String location;
    private String typeOfIncident;

    private boolean NUPD;
    private boolean Police;
    private boolean UHCS;
    private boolean OUEC;
    private boolean Redeye;
    private boolean Driver;
    private boolean receptionistAccepted;
    private boolean notifiedChief;
    private boolean suspectApprehended;
    
    //firearm, threats/stalking, plagarism
    private String policeOfficerFeedback;
    private String OUECCoordinatorFeedback;
    //    threats/stalking
    private String DriverFeedback;
    //assault , injury
    private String DoctorFeedback;
    private String AdvisorFeedback;
    private String DoctorName;
    private String AdvisorName;

    //in case of Emergency complaint : location + date
    
    //in case of normal complaint : accused student + date(manual)
    private Student accusedStudent;
    private String natureOfIncident;
    private String description;
    
    private boolean notifyFromDoctor;
    private boolean notifyFromAdvisor;
   

    public Complaint(String typeOfComplaint, Student student, String dateOfIncident,String location, String typeOfIncident) {
        this.ComplaintID = String.valueOf(count++);
        this.status = "FreshCase";
        this.victimStudent=student;
        this.typeOfComplaint=typeOfComplaint;
        this.typeOfIncident = typeOfIncident;
        this.Police=false;
        this.Driver=false;
        this.suspectApprehended=false;
        this.notifiedChief=false;
        this.receptionistAccepted=false;
        this.location = location;
        this.policeOfficerFeedback="";
        this.DoctorFeedback="";
        this.DriverFeedback="";
        this.OUECCoordinatorFeedback="";
        this.AdvisorFeedback="";
        if(typeOfComplaint.equals("Emergency"))
        {
            this.dateOfIncident=String.valueOf(new Date());
            this.accusedStudent=null;
            this.natureOfIncident="";
            this.description="";
            this.NUPD=true;
            this.OUEC=false;
            this.Redeye=false;
            this.UHCS=false;
            
        }
        else if (typeOfComplaint.equals("Normal"))
        {
            this.dateOfIncident=dateOfIncident;
            this.NUPD=true;
            this.OUEC= true;
            this.Redeye=false;
            this.UHCS=false;
        }
        
    }
    //to add complaint to a persons queue
    public Complaint(Complaint newComplaint)
    {
        this.ComplaintID=newComplaint.ComplaintID;
        this.status=newComplaint.status;
        this.victimStudent=newComplaint.victimStudent;
        this.typeOfComplaint=newComplaint.typeOfComplaint;
        this.dateOfIncident=newComplaint.dateOfIncident;
        this.location=newComplaint.location;
        this.typeOfIncident=newComplaint.typeOfIncident;
        this.NUPD=newComplaint.NUPD;
        this.UHCS=newComplaint.UHCS;
        this.OUEC=newComplaint.OUEC;
        this.Redeye=newComplaint.Redeye;
        this.policeOfficerFeedback=newComplaint.policeOfficerFeedback;
        this.OUECCoordinatorFeedback=newComplaint.OUECCoordinatorFeedback;
        this.DriverFeedback=newComplaint.DriverFeedback;
        this.DoctorFeedback=newComplaint.DoctorFeedback;
        this.AdvisorFeedback=newComplaint.AdvisorFeedback;
        this.accusedStudent=newComplaint.accusedStudent;
        this.natureOfIncident=newComplaint.natureOfIncident;
        this.description=newComplaint.description;
    }
 

    public String getComplaintID() {
        return ComplaintID;
    }

    public void setComplaintID(String ComplaintID) {
        this.ComplaintID = ComplaintID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  
    public String getDateOfIncident() {
        return dateOfIncident;
    }

    public void setDateOfIncident(String dateOfIncident) {
        this.dateOfIncident = dateOfIncident;
    }
    //add once location feature added
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Student getVictimStudent() {
        return victimStudent;
    }

    public void setVictimStudent(Student victimStudent) {
        this.victimStudent = victimStudent;
    }

    public String getTypeOfComplaint() {
        return typeOfComplaint;
    }

    public void setTypeOfComplaint(String typeOfComplaint) {
        this.typeOfComplaint = typeOfComplaint;
    }

    public Student getAccusedStudent() {
        return accusedStudent;
    }

    public void setAccusedStudent(Student accusedStudent) {
        this.accusedStudent = accusedStudent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfIncident() {
        return typeOfIncident;
    }

    public void setTypeOfIncident(String typeOfIncident) {
        this.typeOfIncident = typeOfIncident;
    }

    public String getNatureOfIncident() {
        return natureOfIncident;
    }

    public void setNatureOfIncident(String natureOfIncident) {
        this.natureOfIncident = natureOfIncident;
    }
    
    public boolean isNUPD(){
        return NUPD;
    }

    public void setNUPD(boolean NUPD) {
        this.NUPD = NUPD;
    }

    public boolean isUHCS() {
        return UHCS;
    }

    public void setUHCS(boolean UHCS) {
        this.UHCS = UHCS;
    }

    public String getPoliceOfficerFeedback() {
        return policeOfficerFeedback;
    }

    public void setPoliceOfficerFeedback(String policeOfficerFeedback) {
        this.policeOfficerFeedback = policeOfficerFeedback;
    }

    public boolean isOUEC() {
        return OUEC;
    }

    public void setOUEC(boolean OUEC) {
        this.OUEC = OUEC;
    }

    public String getOUECCoordinatorFeedback() {
        return OUECCoordinatorFeedback;
    }

    public void setOUECCoordinatorFeedback(String OUECCoordinatorFeedback) {
        this.OUECCoordinatorFeedback = OUECCoordinatorFeedback;
    }

   

    public String getDoctorFeedback() {
        return DoctorFeedback;
    }

    public void setDoctorFeedback(String DoctorFeedback) {
        this.DoctorFeedback = DoctorFeedback;
    }

    public String getAdvisorFeedback() {
        return AdvisorFeedback;
    }

    public void setAdvisorFeedback(String AdvisorFeedback) {
        this.AdvisorFeedback = AdvisorFeedback;
    }

    public boolean isRedeye() {
        return Redeye;
    }

    public void setRedeye(boolean Redeye) {
        this.Redeye = Redeye;
    }

    public String getDriverFeedback() {
        return DriverFeedback;
    }
    public void setDriverFeedback(String DriverFeedback) {    
        this.DriverFeedback = DriverFeedback;
    }

    public boolean isPolice() {
        return Police;
    }

    public void setPolice(boolean Police) {
        this.Police = Police;
    }
    
    @Override
    public String toString() {
        return this.ComplaintID;
    }

    public boolean isDriver() {
        return Driver;
    }

    public void setDriver(boolean Driver) {
        this.Driver = Driver;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Complaint.count = count;
    }

    public boolean isNotifyFromDoctor() {
        return notifyFromDoctor;
    }

    public void setNotifyFromDoctor(boolean notifyFromDoctor) {
        this.notifyFromDoctor = notifyFromDoctor;
    }

    public boolean isNotifyFromAdvisor() {
        return notifyFromAdvisor;
    }

    public void setNotifyFromAdvisor(boolean notifyFromAdvisor) {
        this.notifyFromAdvisor = notifyFromAdvisor;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

    public String getAdvisorName() {
        return AdvisorName;
    }

    public void setAdvisorName(String AdvisorName) {
        this.AdvisorName = AdvisorName;
    }

    public boolean isReceptionistAccepted() {
        return receptionistAccepted;
    }

    public void setReceptionistAccepted(boolean receptionistAccepted) {
        this.receptionistAccepted = receptionistAccepted;
    }

    public boolean isNotifiedChief() {
        return notifiedChief;
    }

    public void setNotifiedChief(boolean notifiedChief) {
        this.notifiedChief = notifiedChief;
    }

    public boolean isSuspectApprehended() {
        return suspectApprehended;
    }

    public void setSuspectApprehended(boolean suspectApprehended) {
        this.suspectApprehended = suspectApprehended;
    }

    
    
}  
