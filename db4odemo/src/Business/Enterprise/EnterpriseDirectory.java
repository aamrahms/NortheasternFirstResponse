/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        this.enterpriseList = new ArrayList<Enterprise>();
    }

    
    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    public Enterprise getEnterprise(Enterprise.EnterpriseType type)
    {
        for (Enterprise enterprise : enterpriseList)
        {
            if(enterprise.getEnterpriseType().equals(type))
            {
                return enterprise;
            }
            
        }
        return null;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise createEnterpriseForDirectory(String name, Enterprise.EnterpriseType type)
    {
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.NUPDEnterprise)
        {
            enterprise=new NUPDEnterprise(name);
        }
        else if(type==Enterprise.EnterpriseType.OUECEnterprise)
        {
            enterprise= new OUECEnterprise(name);
        }
        else if(type==Enterprise.EnterpriseType.RedeyeEnterprise)
        {
            enterprise= new RedeyeEnterprise(name);
        }
        else if(type==Enterprise.EnterpriseType.UHCSEnterprise)
        {
            enterprise= new UHCSEnterprise(name);
        }
        
        enterpriseList.add(enterprise);
        return enterprise;
    }
    public void removeEnterprise(Enterprise enterprise)
    {
        enterpriseList.remove(enterprise);
    }
    
}
