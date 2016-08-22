package org.fundacionjala.sfdc.pages.opportunities;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import org.fundacionjala.sfdc.framework.dto.Opportunity;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.fundacionjala.sfdc.pages.leads.LeadSteps;

/**
 * This class will be used to represent Datail opportunity.
 *
 * @author Jimmy Vargas
 */
public class OpportunityDetail extends DetailsBase {

    private static final Logger LOGGER = Logger.getLogger(OpportunityDetail.class.getName());

    @FindBy(id = "opp1_ileinner")
    @CacheLookup
    private WebElement opOwner;

    @FindBy(id = "opp2_chkbox")
    @CacheLookup
    private WebElement privateCheckBox;

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement opName;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement accountName;

    @FindBy(id = "opp5_ileinner")
    @CacheLookup
    private WebElement type;

    @FindBy(id = "opp6_ileinner")
    @CacheLookup
    private WebElement leadSource;

    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::div")
    @CacheLookup
    private WebElement orderNumber;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::div")
    @CacheLookup
    private WebElement currentGenerator;

    @FindBy(xpath = "//td[contains(.,'Tracking Number')]/following::div")
    @CacheLookup
    private WebElement trackingNumber;

    @FindBy(id = "CreatedBy_ileinner")
    @CacheLookup
    private WebElement createdBy;

    @FindBy(id = "opp14_ileinner")
    @CacheLookup
    private WebElement opDescription;

    @FindBy(id = "opp7_ileinner")
    @CacheLookup
    private WebElement amount;

    @FindBy(id = "opp8_ileinner")
    @CacheLookup
    private WebElement expectedRevenue;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDate;

    @FindBy(id = "opp10_ileinner")
    @CacheLookup
    private WebElement nextStep;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement stage;

    @FindBy(id = "opp12_ileinner")
    @CacheLookup
    private WebElement probability;

    @FindBy(id = "opp17_ileinner")
    @CacheLookup
    private WebElement primaryCampaignSource;

    @FindBy(xpath = "//td[contains(.,'Main Competitor')]/following::div")
    @CacheLookup
    private WebElement mainCompetitors;

    @FindBy(xpath = "//td[contains(.,'Delivery/Installation Status')]/following::div")
    @CacheLookup
    private WebElement deliveryInstallationStatus;

    @FindBy(id = "LastModifiedBy_ileinner")
    @CacheLookup
    private WebElement lastModifiedBy;

    /**
     * Returns the Opportunity Form
     */
    @Override
    public OpportunityForm clickEditBtn() {
        super.clickEditButton();
        return new OpportunityForm();
    }

    /**
     * Deletes the Opportunity returning to the opportunities Home
     */
    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        return new OpportunitiesHome();
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        return null;
    }

    /**
     * Deletes the opportunity from its own page
     */

    public String getOpOwner() {
        return opOwner.getText();
    }


    public boolean isPrivate() {
        return "Checked".equalsIgnoreCase(privateCheckBox.getAttribute("title"));
    }

    public String getOpName() {
        return opName.getText();
    }

    public String getAccountName() {
        return accountName.getText();
    }

    public String getType() {
        return type.getText();
    }

    public String getLeadSource() {
        return leadSource.getText();
    }

    public String getOrderNumber() {
        return orderNumber.getText();
    }

    public String getCurrentGenerator() {
        return currentGenerator.getText();
    }

    public String getTrackingNumber() {
        return trackingNumber.getText();
    }

    public String getCreateBy() {
        return createdBy.getText();
    }

    public String getOpDescription() {
        return opDescription.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getExpectedRevenue() {
        return expectedRevenue.getText();
    }

    public String getCloseDate() {
        return closeDate.getText();
    }

    public String getNextStep() {
        return nextStep.getText();
    }

    public String getStage() {
        return stage.getText();
    }

    public String getProbability() {
        return probability.getText();
    }

    public String getPrimaryCampaignSource() {
        return primaryCampaignSource.getText();
    }

    public String getMainCompetitors() {
        return mainCompetitors.getText();
    }

    public String getDeliveryInstallationStatus() {
        return deliveryInstallationStatus.getText();
    }

    public String getLastModifiedBy() {
        return lastModifiedBy.getText();
    }


    public void validateFields(Opportunity oppEnum) {
        try {
            Field[] classFields = oppEnum.getClass().getDeclaredFields();
            for (Field field : classFields) {
                String fieldName = field.getName();
                Object actualFieldValue = getAssertCreateOpportunityMap().get(LeadSteps.valueOf(fieldName.toUpperCase()));
                if (actualFieldValue != null) {
                    String expectedFieldValue = (String) field.get(oppEnum);
                    Assert.assertEquals(actualFieldValue.toString(), expectedFieldValue, String.format("The field %s is not correct", fieldName));
                }
            }
        } catch (IllegalArgumentException e) {
            LOGGER.info(String.format("Illegal argument exception on validate field method: %s", e));
        } catch (IllegalAccessException e) {
            LOGGER.info(String.format("Illegal access exception on validate field method: %s", e));
        }
    }

    public Map<OpportunitySteps, Object> getAssertCreateOpportunityMap() {
        EnumMap<OpportunitySteps, Object> assertionOpportunityMap = new EnumMap<>(OpportunitySteps.class);
        assertionOpportunityMap.put(OpportunitySteps.OPPORTUNITYNAME, getOpName());
        assertionOpportunityMap.put(OpportunitySteps.CLOSEDATE, getCloseDate());
        assertionOpportunityMap.put(OpportunitySteps.STAGE, getStage());
        assertionOpportunityMap.put(OpportunitySteps.PRIVATECHK, isPrivate());
        assertionOpportunityMap.put(OpportunitySteps.TYPE, getType());
        assertionOpportunityMap.put(OpportunitySteps.LEADSOURCE, getLeadSource());
        assertionOpportunityMap.put(OpportunitySteps.NEXTSTEP, getNextStep());
        assertionOpportunityMap.put(OpportunitySteps.AMOUNT, getAmount());
        assertionOpportunityMap.put(OpportunitySteps.PROBABILITY, getProbability());
        assertionOpportunityMap.put(OpportunitySteps.ORDERNUMBER, getOrderNumber());
        assertionOpportunityMap.put(OpportunitySteps.TRACKINGNUMBER, getTrackingNumber());
        assertionOpportunityMap.put(OpportunitySteps.MAINCOMPETITORS, getMainCompetitors());
        assertionOpportunityMap.put(OpportunitySteps.DELIVERYSTATUS, getDeliveryInstallationStatus());
        assertionOpportunityMap.put(OpportunitySteps.DESCRIPTION, getOpDescription());
        return assertionOpportunityMap;
    }
}
