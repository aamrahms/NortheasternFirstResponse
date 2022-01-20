/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;
import Business.Enterprise.EnterpriseDirectory;
/**
 *
 * @author aamrah
 */
public class Network {
   
   
   private String city;
   private EnterpriseDirectory enterpriseDirectory;
   //COMPLAINTdIRECTORY
   //STUDENTDIRECTORY

    public Network() {
        this.enterpriseDirectory = new EnterpriseDirectory();
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    @Override
    public String toString(){
        return city;
    }
   
    
}
