/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Complaint;

import Business.Student.Student;
import java.util.Date;

/**
 *
 * @author aamrah
 */
public class EmergencyComplaint extends Complaint{
    String dateOfIncident;
    public EmergencyComplaint(String typeOfComplaint, Student student, String dateOfIncident, String location, String typeOfIncident) {
        super(typeOfComplaint, student, dateOfIncident, location, typeOfIncident);
        this.dateOfIncident=String.valueOf(new Date());
////            this.receiver="ChiefOfficer";
    }
    
}
