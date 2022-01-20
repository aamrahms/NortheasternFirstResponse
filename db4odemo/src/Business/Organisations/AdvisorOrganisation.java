/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organisations;

import Business.Role.AdvisorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class AdvisorOrganisation extends Organisation{
    public AdvisorOrganisation() {
        super(Organisation.Type.AdvisorOrganisation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles =new ArrayList();
     roles.add(new AdvisorRole());
     return roles;
    }
    
    
}
