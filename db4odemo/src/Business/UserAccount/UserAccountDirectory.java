/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.AdvisorRole;
import Business.Role.DoctorRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }
    
    //adding methods to delete and save user
    public void deleteUserAccount(UserAccount user)
    {
        userAccountList.remove(user);
    }
    
    public void saveUserAccount(UserAccount useraccount,String name, String username, String password)
    {
        useraccount.setName(name);
        useraccount.setUsername(username);
        useraccount.setPassword(password);
        
    }
    
    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String name, String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setName(name);
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    //Only 1 receptionist
    public UserAccount fetchReceptionistFromUa () {
        for (UserAccount ua : userAccountList){
            if ( ua.getRole() instanceof ReceptionistRole) {
                return ua;
            }
        }
        return null;     //UHCS has no receptionist; UHCS is not open to accept complaints
    }
    
    public UserAccount fetchUaWithUserName(String userName) {
        for (UserAccount ua : userAccountList){
            if ( userName.equals(ua.getEmployee().getUsername())) {
                return ua;
            }
        }
        return null;
    }
    
    /*public ArrayList<UserAccount> fetchDoctorFromUa () {
        ArrayList<UserAccount> tempList = new ArrayList<UserAccount>();
        for (UserAccount ua : userAccountList){
            if ( ua.getRole() instanceof DoctorRole) {
                tempList.add(ua);
            }
        }
        return tempList;
    }
    
    public ArrayList<UserAccount> fetchAdvisorFromUa () {
        ArrayList<UserAccount> tempList = new ArrayList<UserAccount>();
        for (UserAccount ua : userAccountList){
            if ( ua.getRole() instanceof AdvisorRole) {
                tempList.add(ua);
            }
        }
        return tempList;
    }*/
    
}
