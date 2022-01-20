/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.UHCS.ManageAdvisorJPanel;

/**
 *
 * @author aamrah
 */
public class AdvisorRole extends Role {
    private Role.RoleType roleType;
    public AdvisorRole() {
        roleType=Role.RoleType.Advisor;
    }
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
         return new ManageAdvisorJPanel(userProcessContainer, account, system);
    }
}
