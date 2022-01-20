/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.OUEC.OUECCoordinatorJPanel;

/**
 *
 * @author aamrah
 */
public class OUECCoordinatorRole extends Role{
    private Role.RoleType roleType;
    public OUECCoordinatorRole() {
        roleType=Role.RoleType.OUECCoordinator;
    }
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
         return new OUECCoordinatorJPanel(userProcessContainer, account, system);
    }
}
