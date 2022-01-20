/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organisations;

import Business.Organisations.Organisation.Type;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class OrganisationDirectory {
    private ArrayList<Organisation> organisationList;

    public OrganisationDirectory() {
        this.organisationList = new ArrayList();
    }

    public ArrayList<Organisation> getOrganisationList() {
        return organisationList;
    }

    public void createOrganisation(Type type, String name) {
        Organisation organisation=null;
        if(type.getValue().equals(Type.ChiefOfficerOrganisation.getValue())){
            organisation = new ChiefOfficerOrganisation();
            organisationList.add(organisation);  
        }
        else if(type.getValue().equals(Type.PoliceOfficerOrganisation.getValue())){
            organisation = new PoliceOfficerOrganisation();
            organisationList.add(organisation);  
        }
        else if(type.getValue().equals(Type.StudentOrganisation.getValue())){
            organisation = new StudentOrganisation();
            organisationList.add(organisation);  
        }
        else if(type.getValue().equals(Type.DoctorOrganisation.getValue())){
            organisation = new DoctorOrganisation();
            organisationList.add(organisation);  
        }
        else if(type.getValue().equals(Type.ReceptionistOrganisation.getValue())){
            organisation = new ReceptionistOrganisation();
            organisationList.add(organisation);  
        }
        else if(type.getValue().equals(Type.AdvisorOrganisation.getValue())){
            organisation = new AdvisorOrganisation();
            organisationList.add(organisation);  
        }
        else if(type.getValue().equals(Type.PresidentOrganisation.getValue())){
            organisation = new PresidentOrganisation();
            organisationList.add(organisation);  
        }
        else if(type.getValue().equals(Type.OUECCoordinatorOrganisation.getValue())){
            organisation = new OUECCoordinatorOrganisation();
            organisationList.add(organisation);  
        }
        
        else if(type.getValue().equals(Type.DriverOrganisation.getValue())){
            organisation = new DriverOrganisation();
            organisationList.add(organisation);  
        }
        
    }
    
    
    
}
