/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Complaint.Complaint;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<Complaint> complaintList;     //WorkRequest is ComplaintRequest

    public WorkQueue() {
        complaintList = new ArrayList();
    }

    public ArrayList<Complaint> getComplaintList() {
        return complaintList;
    }
}