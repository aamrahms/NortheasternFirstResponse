/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import static Business.Organisations.Organisation.Type.DriverOrganisation;
import Business.Role.AdvisorRole;
import Business.Role.DoctorRole;
import Business.Role.DriverRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class RedeyeEnterprise extends Enterprise{
     public RedeyeEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.RedeyeEnterprise);
        this.getOrganisationDirectory().createOrganisation(DriverOrganisation, "DriverOrganisation");

    }
    //aRRAYLIST OF Organisations 

    @Override
    public ArrayList<Role> getSupportedRole() {
        roles=new ArrayList<Role>();
        roles.add(new DriverRole());
        
        return roles;
    }
}
