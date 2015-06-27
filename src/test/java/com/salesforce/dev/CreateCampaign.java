package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignDetail;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.SearchLookup.SearchLookupBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Marcelo.Vargas on 6/15/2015.
 */
public class CreateCampaign {

    private String campaignName = "Campaign Name 03";
    private String campaignType = "Webinar"; //Conference, Webinar, Trade Show, Public Relations, Partners, Referral Program, Advertisement, Banner Ads, Direct Mail, Email, Telemarketing, Other
    private String campaignStatus = "Completed"; //--None--, Planned, In Progress, Completed, Aborted
    private String startDate = "6/15/2016";
    private String endDate = "6/17/2016";
    private String expectedRevenue = "2500";
    private String budgetedCost = "2000";
    private String actualCost = "3500";
    private String expectedResponse = "78";
    private String numSent = "10";
    private String parentCampaign = "CampaignParent";

    private CampaignsHome campaignsHome;
    private CampaignDetail campaignDetail;
    private CampaignForm campaignForm;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;

    private SearchLookupBase searchLookup;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCamapaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(parentCampaign);
        campaignForm.checkActiveCheckbox();
        campaignDetail = campaignForm.clickSaveBtn();
        mainPage = campaignDetail.gotoMainPage();
    }

    @Test
    public void testCreateCampaign() {
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCamapaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(campaignName);
        campaignForm.checkActiveCheckbox();
        campaignForm.setTypeSelect(campaignType);
        campaignForm.setStatusSelect(campaignStatus);
        campaignForm.setStartDate(startDate);
        campaignForm.setEndDate(endDate);
        campaignForm.setExpectedRevenue(expectedRevenue);
        campaignForm.setBudgetedCost(budgetedCost);
        campaignForm.setActualCost(actualCost);
        campaignForm.setExpectedResponse(expectedResponse);
        campaignForm.setNumSent(numSent);
        searchLookup = campaignForm.clickLookupParentCampaign();
        searchLookup.searchText(parentCampaign);
        campaignForm = searchLookup.goToCampaignForm();

        campaignDetail = campaignForm.clickSaveBtn();

        Assert.assertTrue(campaignDetail.validateCampaignNameFld(campaignName));
        Assert.assertTrue(campaignDetail.validateCampaignType(campaignType));
        Assert.assertTrue(campaignDetail.validateCampaignStatus(campaignStatus));
        Assert.assertTrue(campaignDetail.validateCampaignStartDate(startDate));
        Assert.assertTrue(campaignDetail.validateCampaignEndDate(endDate));
        Assert.assertTrue(campaignDetail.validateCampaignParent(parentCampaign));
    }

    @AfterMethod
    public void tearDown() {
        campaignDetail.clickDeleteBtn(true);
        mainPage = campaignDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCamapaignsHome();
        campaignDetail = campaignsHome.selectRecentItem(parentCampaign);
        campaignDetail.clickDeleteBtn(true);
    }
} 