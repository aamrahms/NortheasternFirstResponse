/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic.OUEC;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class OUECCoordinatorDirectory {
    
    ArrayList<OUECCoordinator> ouecCoordinatorList;

    public OUECCoordinatorDirectory() {
        ouecCoordinatorList = new ArrayList<OUECCoordinator>();
    }

    public void createOUECCoordinator(Employee e) {
        OUECCoordinator ouecCoordinator = new OUECCoordinator(e);
        ouecCoordinatorList.add(ouecCoordinator);
    }

    //first update in Employye Directory it returns Employee object and call below one
    public void updateOUECCoordinator(OUECCoordinator ouecCoordinator, Employee e){
        for (OUECCoordinator ouec : ouecCoordinatorList) {
            if (ouec.getEmployee().getUsername().equals(e.getUsername())) {
                ouec.getEmployee().setName(e.getName());
                ouec.getEmployee().setPassword(e.getPassword());
                ouec.getEmployee().setAddress(e.getAddress());
                ouec.getEmployee().setEmail(e.getEmail());
                ouec.getEmployee().setNeuid(e.getNeuid());
                ouec.getEmployee().setPhone(e.getPhone());
            }
        }
    }

    public void deleteOUECCoordinator(OUECCoordinator ouecCoordinator, Employee e) {
        for (OUECCoordinator ouec : ouecCoordinatorList) {
            if (ouec.getEmployee().getUsername().equals(e.getName())) {
                ouecCoordinatorList.remove(ouec);
                return;
            }
        }        
    }

    public ArrayList<OUECCoordinator> getOuecCoordinatorList() {
        return ouecCoordinatorList;
    }

    public void setOuecCoordinatorList(ArrayList<OUECCoordinator> ouecCoordinatorList) {
        this.ouecCoordinatorList = ouecCoordinatorList;
    }
}
