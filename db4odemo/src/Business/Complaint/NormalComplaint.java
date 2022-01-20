/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Complaint;

import Business.Student.Student;

/**
 *
 * @author aamrah
 */
public class NormalComplaint extends Complaint{
    private Student accusedStudent;
    private String natureOfIncident;
    private String description;
    public NormalComplaint(String typeOfComplaint, Student student, String dateOfIncident, String location, String typeOfIncident) {
        super(typeOfComplaint, student, dateOfIncident, location, typeOfIncident);
    }
    
}
