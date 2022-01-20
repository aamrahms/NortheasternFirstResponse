/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organisations;

import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class DoctorOrganisation extends Organisation{
    public DoctorOrganisation() {
        super(Organisation.Type.DoctorOrganisation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles =new ArrayList();
     roles.add(new DoctorRole());
     return roles;
    }
    
    
}
