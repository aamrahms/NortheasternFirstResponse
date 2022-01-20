/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organisations.Organisation;
import Business.Organisations.OrganisationDirectory;
import Business.Student.StudentDirectory;
/**
 *
 * @author aamrah
 */
public abstract class Enterprise extends Organisation{
    private EnterpriseType enterpriseType;
    private OrganisationDirectory organisationDirectory;
    private StudentDirectory studentDirectory;
    private Organisation organisation;
    public enum EnterpriseType {
        NUPDEnterprise("NUPDEnterprise"),
        OUECEnterprise("OUECEnterprise"),
        RedeyeEnterprise("RedeyeEnterprise"),
        UHCSEnterprise("UHCSEnterprise");
        private String value;//inside bracs value
        private EnterpriseType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    //constructor
    public Enterprise(String name, EnterpriseType enterpriseType) {
        super(name);
        this.enterpriseType = enterpriseType;
        this.organisationDirectory = new OrganisationDirectory();

    }
    
    //getters and setters
    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }
    

    public OrganisationDirectory getOrganisationDirectory() {
        return organisationDirectory;
    }

    public void setOrganisationDirectory(OrganisationDirectory organisationDirectory) {
        this.organisationDirectory = organisationDirectory;
    }
    
    
}
