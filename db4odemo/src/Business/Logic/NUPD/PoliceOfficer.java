/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic.NUPD;
import Business.Complaint.Complaint;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class PoliceOfficer {
    private String name;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String neuid;
    private Complaint complaint;
    private ArrayList<Complaint> policeComplaints;

    public PoliceOfficer(String name, String username, String password, String address, String phone, String email, String neuid) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.neuid = neuid;
        this.policeComplaints= new ArrayList<Complaint>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNeuid() {
        return neuid;
    }

    public void setNeuid(String neuid) {
        this.neuid = neuid;
    }

    public ArrayList<Complaint> getPoliceComplaints() {
        return policeComplaints;
    }

    public void setPoliceComplaints(ArrayList<Complaint> policeComplaints) {
        this.policeComplaints = policeComplaints;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    
    
    
    
}
