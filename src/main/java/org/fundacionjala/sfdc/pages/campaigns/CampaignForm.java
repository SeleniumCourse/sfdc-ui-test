package org.fundacionjala.sfdc.pages.campaigns;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.SearchLookupBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.waitForWebElement;

/**
 * This class will be used to represent Campaing form.
 *
 * @author Marcelo.Vargas
 */
public class CampaignForm extends FormBase {

    private static final Logger LOGGER = Logger.getLogger(CampaignForm.class.getName());
    // Campaign Information

    @FindBy(id = "cpn1")
    @CacheLookup
    private WebElement campaignNameFld;

    @FindBy(id = "cpn16")
    @CacheLookup
    private WebElement activeCheckbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    private WebElement typeSelect;

    @FindBy(id = "cpn3")
    @CacheLookup
    private WebElement statusSelect;

    @FindBy(id = "cpn5") // calendar
    @CacheLookup
    private WebElement startDate;

    @FindBy(id = "cpn6") // calendar
    @CacheLookup
    private WebElement endDate;

    @FindBy(id = "cpn8")
    @CacheLookup
    private WebElement expectedRevenueFld;

    @FindBy(id = "cpn9")
    @CacheLookup
    private WebElement budgetedCostFld;

    @FindBy(id = "cpn10")
    @CacheLookup
    private WebElement actualCostFld;

    @FindBy(id = "cpn11")
    @CacheLookup
    private WebElement expectedResponseFld;

    @FindBy(id = "cpn13")
    @CacheLookup
    private WebElement numSentFld;

    @FindBy(css = ".lookupIcon")
    @CacheLookup
    private WebElement lookupCampaignImg;

    // Description Information

    @FindBy(id = "cpn4")
    @CacheLookup
    private WebElement descriptionFld;

    @FindBy(className = "detailList")
    private WebElement panel;

    public CampaignForm() {
        waitForWebElement(saveBtn);
    }

    @Override
    public AbstractBasePage clickCancelBtn() {
        return null;
    }

    @Override
    public CampaignDetail clickSaveBtn() {
        clickSaveButton();
        LOGGER.info("Campaign was created");
        return new CampaignDetail();
    }

    public CampaignForm setCampaignName(String text) {
        fillTextBox(campaignNameFld, text);
        return this;
    }

    public CampaignForm checkActiveCheckbox() {
        if (!activeCheckbox.isSelected()) {
            activeCheckbox.click();
        }
        return this;
    }

    public CampaignForm setTypeSelect(String text) {
        selectItemComboBox(typeSelect, text);
        return this;
    }

    public CampaignForm setStatusSelect(String text) {
        selectItemComboBox(statusSelect, text);
        return this;
    }

    public CampaignForm setStartDate(String text) {
        fillTextBox(startDate, text);
        return this;
    }

    public CampaignForm setEndDate(String text) {
        fillTextBox(endDate, text);
        return this;
    }

    public CampaignForm setExpectedRevenue(String text) {
        fillTextBox(expectedRevenueFld, text);
        return this;
    }

    public CampaignForm setBudgetedCost(String text) {
        fillTextBox(budgetedCostFld, text);
        return this;
    }

    public CampaignForm setActualCost(String text) {
        fillTextBox(actualCostFld, text);
        return this;
    }

    public CampaignForm setExpectedResponse(String text) {
        fillTextBox(expectedResponseFld, text);
        return this;
    }

    public CampaignForm setNumSent(String text) {
        fillTextBox(numSentFld, text);
        return this;
    }

    public SearchLookupBase clickLookupParentCampaign() {
        lookupCampaignImg.click();
        return new SearchLookupBase();
    }

    public CampaignForm setDescription(String text) {
        fillTextBox(descriptionFld, text);
        return this;
    }

    public CampaignForm clickPanel() {
        clickWebElement(panel);
        return this;
    }
}
