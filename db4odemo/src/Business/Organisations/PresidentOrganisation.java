/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organisations;

import Business.Role.PresidentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class PresidentOrganisation extends Organisation{
    public PresidentOrganisation() {
        super(Organisation.Type.PresidentOrganisation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles =new ArrayList();
     roles.add(new PresidentRole());
     return roles;
    }
}
