/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import static Business.Organisations.Organisation.Type.ChiefOfficerOrganisation;
import static Business.Organisations.Organisation.Type.PoliceOfficerOrganisation;
import Business.Role.ChiefOfficerRole;
import Business.Role.PoliceOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class NUPDEnterprise extends Enterprise{

    public NUPDEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.NUPDEnterprise);
        //this.organisationDirectory.add();
//        if()
        this.getOrganisationDirectory().createOrganisation(PoliceOfficerOrganisation, "PoliceOfficerOrganisation");
        this.getOrganisationDirectory().createOrganisation(ChiefOfficerOrganisation, "ChiefOfficerOrganisation");
        
    }
    //aRRAYLIST OF Organisations 

    @Override
    public ArrayList<Role> getSupportedRole() {
        roles=new ArrayList<Role>();
        roles.add(new ChiefOfficerRole());
        roles.add(new PoliceOfficerRole());
        return roles;
    }
    
}
