/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic.NUPD;


import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class PoliceOfficerDirectory {
    PoliceOfficer policeOfficer;
    ArrayList<PoliceOfficer> policeOfficerList;

    public PoliceOfficerDirectory() {
        this.policeOfficerList = new ArrayList<PoliceOfficer>();
    }
    
    public ArrayList<PoliceOfficer> getPoliceOfficerList() {
        return policeOfficerList;
    }

    public void setPoliceOfficerList(ArrayList<PoliceOfficer> policeOfficerList) {
        this.policeOfficerList = policeOfficerList;
    }
    
    //creating student
    public PoliceOfficer createPoliceOfficer(String name, String username, String password, String address, String phone, String email, String neuid)
    {
        policeOfficer=new PoliceOfficer(name, username, password,address, phone, email, neuid);
        policeOfficerList.add(policeOfficer);
        return policeOfficer;
    }
    //updating student profile
    public void updatePoliceOfficer(PoliceOfficer policeOfficer,String name, String username, String password, String address, String phone, String email, String neuid)
    {
        for (PoliceOfficer c: policeOfficerList)
        {
            if(c.getUsername().equalsIgnoreCase(policeOfficer.getUsername()))
            {
                policeOfficer.setName(name);
                policeOfficer.setUsername(username);
                policeOfficer.setPassword(password);
                policeOfficer.setAddress(address);
                policeOfficer.setPhone(phone);
                break;
            }
        }
    }
    //deleting student from dir
    public void deletePoliceOfficer(PoliceOfficer policeOfficer){
                policeOfficerList.remove(policeOfficer);
        
    }
    

    
   
    
}
