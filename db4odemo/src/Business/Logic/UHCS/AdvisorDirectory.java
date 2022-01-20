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
public class AdvisorDirectory {
    
    ArrayList<Advisor> advisorList;

    public AdvisorDirectory() {
        advisorList = new ArrayList<Advisor>();
    }
    

    public ArrayList<Advisor>  getAdvisorList() {
        return advisorList;
    }

    public void setAdvisorList(ArrayList<Advisor> advisorList) {
        this.advisorList = advisorList;
    }

    public void createAdvisor(Employee e){
        Advisor advisor = new Advisor(e);
        advisorList.add(advisor);
    }

    //first update in Employee Directory it returns Employee object and call below one
    public void updateAdvisor(Advisor d, Employee e){
        for (Advisor advisor : advisorList) {
            if (advisor.getEmployee().getUsername().equals(e.getUsername())) {
                advisor.getEmployee().setName(e.getName());
                advisor.getEmployee().setPassword(e.getPassword());
                advisor.getEmployee().setAddress(e.getAddress());
                advisor.getEmployee().setEmail(e.getEmail());
                advisor.getEmployee().setNeuid(e.getNeuid());
                advisor.getEmployee().setPhone(e.getPhone());
            }
        }
    }

    public void deleteAdvisor (Advisor driver, Employee e) {
        for (Advisor advisor : advisorList) {
            if (advisor.getEmployee().getUsername().equals(e.getName())) {
                advisorList.remove(advisor);
                return;
            }
        }        
    }
    
    public Advisor fetchAdvisorWithUserName (String userName) {
        for (Advisor advisor : advisorList) {
            if (advisor.getEmployee().getUsername().equals(userName)) {
                return advisor;
            }
        }
        return null;
    }
    
    
}
