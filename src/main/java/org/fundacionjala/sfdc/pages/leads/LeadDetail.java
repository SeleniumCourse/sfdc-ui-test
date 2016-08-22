package org.fundacionjala.sfdc.pages.leads;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import org.fundacionjala.sfdc.framework.dto.Lead;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class will be used to represents Lead details page.
 *
 * @author Jimmy Vargas
 */
public class LeadDetail extends DetailsBase {

    private static final Logger LOGGER = Logger.getLogger(LeadDetail.class.getName());

    @FindBy(id = "lea8_ileinner")
    @CacheLookup
    WebElement phone;

    @FindBy(id = "lea10_ileinner")
    @CacheLookup
    WebElement fax;

    /*Lead Information*/
    @FindBy(id = "lea1_ileinner")
    @CacheLookup
    private WebElement owner;

    @FindBy(id = "lea2_ileinner")
    @CacheLookup
    private WebElement name;

    @FindBy(id = "lea3_ileinner")
    @CacheLookup
    private WebElement company;

    @FindBy(id = "lea4_ileinner")
    @CacheLookup
    private WebElement title;

    @FindBy(id = "lea5_ileinner")
    @CacheLookup
    private WebElement leadSource;

    @FindBy(id = "lea6_ileinner")
    @CacheLookup
    private WebElement industry;

    @FindBy(id = "lea7_ileinner")
    @CacheLookup
    private WebElement annualRevenue;

    @FindBy(id = "lea9_ileinner")
    @CacheLookup
    private WebElement mobile;

    @FindBy(id = "lea11_ileinner")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "lea12_ileinner")
    @CacheLookup
    private WebElement website;

    @FindBy(id = "lea13_ileinner")
    @CacheLookup
    private WebElement leadStatus;

    @FindBy(id = "lea14_ileinner")
    @CacheLookup
    private WebElement rating;

    @FindBy(id = "lea15_ileinner")
    @CacheLookup
    private WebElement numEmployees;

    /*Address Information*/
    @FindBy(id = "lea16_ileinner")
    @CacheLookup
    private WebElement address;

    /*additional information*/
    @FindBy(xpath = "//td[contains(.,'Product Interest')]/following::div")
    @CacheLookup
    private WebElement productInterest;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::div")
    @CacheLookup
    private WebElement sicCode;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::div")
    @CacheLookup
    private WebElement numLocations;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    @CacheLookup
    private WebElement currentGenerators;

    @FindBy(xpath = "//td[contains(.,'Primary')]/following::div")
    @CacheLookup
    private WebElement primary;

    /*Others*/
    @FindBy(id = "lea17_ileinner")
    @CacheLookup
    private WebElement description;

    @FindBy(id = "lea20")
    @CacheLookup
    private WebElement campaign;

    @FindBy(id = "CreatedBy_ileinner")
    @CacheLookup
    private WebElement createdBy;

    @FindBy(id = "LastModifiedBy_ileinner")
    @CacheLookup
    private WebElement lastModifiedBy;


    /*Lead Information*/
    public String getOwner() {
        return owner.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getCompany() {
        return company.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getLeadSource() {
        return leadSource.getText();
    }

    public String getIndustry() {
        return industry.getText();
    }

    public String getAnnualRevenue() {
        return annualRevenue.getText();
    }

    public String getPhone() {
        return phone.getText();
    }

    public String getMobile() {
        return mobile.getText();
    }

    public String getFax() {
        return fax.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getWebsite() {
        return website.getText();
    }

    public String getLeadStatus() {
        return leadStatus.getText();
    }

    public String getRating() {
        return rating.getText();
    }

    public String getNumEmployees() {
        return numEmployees.getText();
    }

    /*Address Information*/
    public String getAddress() {
        return address.getText();
    }

    /*additional information*/
    public String getProductInterest() {
        return productInterest.getText();
    }

    public String getSicCode() {
        return sicCode.getText();
    }

    public String getNumLocations() {
        return numLocations.getText();
    }

    public String getCurrentGenerators() {
        return currentGenerators.getText();
    }

    public String getPrimary() {
        return primary.getText();
    }

    /*Others*/
    public String getDescription() {
        return description.getText();
    }

    public String getCampaign() {
        return campaign.getText();
    }

    public String getCreatedBy() {
        return createdBy.getText();
    }

    public String getLastModifiedBy() {
        return lastModifiedBy.getText();
    }

    @Override
    public LeadForm clickEditBtn() {
        super.clickEditButton();
        return new LeadForm();
    }

    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        LOGGER.info("Lead was deleted");
        return new LeadsHome();
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        return null;
    }

    public void validateFields(Lead lead) {
        try {
            Field[] classFields = lead.getClass().getDeclaredFields();
            for (Field field : classFields) {
                String fieldName = field.getName();
                Object actualFieldValue = getAssertCreateLeadMap().get(LeadSteps.valueOf(fieldName.toUpperCase()));
                if (actualFieldValue != null) {
                    String expectedFieldValue = (String) field.get(lead);
                    Assert.assertEquals(actualFieldValue.toString(), expectedFieldValue, String.format("The field %s is not correct", fieldName));
                }
            }
        } catch (IllegalArgumentException e) {
            LOGGER.info(String.format("Illegal argument exception on validate field method: %s", e));
        } catch (IllegalAccessException e) {
            LOGGER.info(String.format("Illegal access exception on validate field method: %s", e));
        }
    }

    public Map<LeadSteps, Object> getAssertCreateLeadMap() {
        Map<LeadSteps, Object> assertionLeadMap = new EnumMap<>(LeadSteps.class);
        assertionLeadMap.put(LeadSteps.LASTNAME, getName());
        assertionLeadMap.put(LeadSteps.COMPANY, getCompany());
        assertionLeadMap.put(LeadSteps.TITLE, getTitle());
        assertionLeadMap.put(LeadSteps.LEADSOURCE, getLeadSource());
        assertionLeadMap.put(LeadSteps.INDUSTRY, getIndustry());
        assertionLeadMap.put(LeadSteps.PHONE, getPhone());
        assertionLeadMap.put(LeadSteps.MOBILE, getMobile());
        assertionLeadMap.put(LeadSteps.FAX, getFax());
        assertionLeadMap.put(LeadSteps.EMAIL, getEmail());
        assertionLeadMap.put(LeadSteps.LEADSTATUS, getLeadStatus());
        assertionLeadMap.put(LeadSteps.RATING, getRating());
        assertionLeadMap.put(LeadSteps.NUMEMPLOYEES, getNumEmployees());
        assertionLeadMap.put(LeadSteps.PRODUCTINTEREST, getProductInterest());
        assertionLeadMap.put(LeadSteps.SICCODE, getSicCode());
        assertionLeadMap.put(LeadSteps.NUMBERLOCATIONS, getNumLocations());
        assertionLeadMap.put(LeadSteps.DESCRIPTION, getDescription());
        assertionLeadMap.put(LeadSteps.CURRENTGENERATORS, getCurrentGenerators());
        assertionLeadMap.put(LeadSteps.PRIMARY, getPrimary());
        return assertionLeadMap;
    }
}
