package com.salesforce.dev.pages.Campaigns;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.DetailsBase;
import com.salesforce.dev.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marcelo.Vargas on 13-06-15.
 */
public class CampaignDetail extends DetailsBase{

    @FindBy(id = "cpn1_ileinner")
    WebElement campaignName;

    @FindBy(id = "cpn2_ileinner")
    WebElement campaignType;

    @FindBy(id = "cpn3_ileinner")
    WebElement campaignStatus;

    @FindBy(id = "cpn5_ileinner")
    WebElement campaignStartDate;

    @FindBy(id = "cpn6_ileinner")
    WebElement campaignEndDate;

    @FindBy(id = "cpn8_ileinner")
    WebElement campaignExpectedRevenue;

    @FindBy(id = "cpn9_ileinner")
    WebElement campaignBudgetedCost;

    @FindBy(id = "cpn10_ileinner")
    WebElement campaignActualCost;

    @FindBy(id = "cpn11_ileinner")
    WebElement campaignExpectedResponse;

    @FindBy(id = "cpn13_ileinner")
    WebElement campaignNumSent;

    @FindBy(id = "Parent_ileinner")
    WebElement campaignParent;

    public CampaignDetail(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    @Override
    public CampaignForm clickEditBtn(){
        clickEditButton();
        return new CampaignForm(driver);
    }

    @Override
    public Object clickDeleteBtn(boolean confirmDeletion){
        clickDeleteButton(confirmDeletion);
        return new CampaignsHome(driver);
    }

    public MainPage gotoMainPage(){
        return new MainPage(driver);
    }

    public Boolean validateCampaignNameFld(String value) {
        String realValue = campaignName.getText().substring(0, campaignName.getText().length() - 17);
        return realValue.equals(value);
    }

    public Boolean validateCampaignType(String value) {
        return campaignType.getText().equals(value);
    }

    public Boolean validateCampaignStatus(String value) {
        return campaignStatus.getText().equals(value);
    }

    public Boolean validateCampaignStartDate(String value) {
        return campaignStartDate.getText().equals(value);
    }

    public Boolean validateCampaignEndDate(String value) {
        return campaignEndDate.getText().equals(value);
    }

    public Boolean validateCampaignExpectedRevenue(String value) {
        return campaignExpectedRevenue.getText().equals("¤" + value);
    }

    public Boolean validateCampaignBudgetedCost(String value) {
        return campaignBudgetedCost.getText().equals("¤" + value);
    }

    public Boolean validateCampaignActualCost(String value) {
        System.out.println(value + " ****** " + campaignActualCost.getText());
        return campaignActualCost.getText().equals("¤" + value);
    }

    public Boolean validateCampaignExpectedResponse(String value) {
        return campaignExpectedResponse.getText().equals(value);
    }

    public Boolean validateCampaignNumSent(String value) {
        return campaignNumSent.getText().equals(value);
    }

    public Boolean validateCampaignParent(String value) {
        return campaignParent.getText().equals(value);
    }
}