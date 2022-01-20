/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organisations;
import Business.Role.ChiefOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class ChiefOfficerOrganisation extends Organisation{

    public ChiefOfficerOrganisation() {
        super(Organisation.Type.ChiefOfficerOrganisation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles =new ArrayList();
     roles.add(new ChiefOfficerRole());
     return roles;
    }
    

    
    
}
