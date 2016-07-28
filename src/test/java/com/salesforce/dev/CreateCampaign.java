package com.salesforce.dev;

import java.util.Iterator;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.Campaign;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Base.SearchLookupBase;
import com.salesforce.dev.pages.Campaigns.CampaignDetail;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Objects.CampaignGenie;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Marcelo.Vargas on 6/15/2015.
 */
public class CreateCampaign {
    private static final Logger LOGGER = Logger.getLogger(CreateCampaign.class.getName());
    private String parentCampaign = "CampaignParent";

    private CampaignsHome campaignsHome;
    private CampaignDetail campaignDetail;
    private CampaignForm campaignForm;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;


    private SearchLookupBase searchLookup;

    @DataProvider(name = "dataDriven")
    public Iterator<Campaign[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getCampaign("CreateCampaign.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        parentCampaign = CampaignGenie.getCampaign().getParentCampaign();
        CampaignGenie.createParentCampaign(parentCampaign);
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateCampaign(Campaign campaign) {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(campaign.getCampaignName());
        campaignForm.checkActiveCheckbox();
        campaignForm.setTypeSelect(campaign.getCampaignType());
        campaignForm.setStatusSelect(campaign.getCampaignStatus());
        campaignForm.setStartDate(campaign.getStartDate());
        campaignForm.setEndDate(campaign.getEndDate());
        campaignForm.setExpectedRevenue(campaign.getExpectedRevenue());
        campaignForm.setBudgetedCost(campaign.getBudgetedCost());
        campaignForm.setActualCost(campaign.getActualCost());
        campaignForm.setExpectedResponse(campaign.getExpectedResponse());
        campaignForm.setNumSent(campaign.getNumSent());
        searchLookup = campaignForm.clickLookupParentCampaign();
        searchLookup.searchText(parentCampaign);
        campaignForm = searchLookup.goToCampaignForm();
        campaignDetail = campaignForm.clickSaveBtn();
        Assert.assertTrue(campaignDetail.validateCampaignNameFld(campaign.getCampaignName()));
        Assert.assertTrue(campaignDetail.validateCampaignType(campaign.getCampaignType()));
        Assert.assertTrue(campaignDetail.validateCampaignStatus(campaign.getCampaignStatus()));
        Assert.assertTrue(campaignDetail.validateCampaignStartDate(campaign.getStartDate()));
        Assert.assertTrue(campaignDetail.validateCampaignEndDate(campaign.getEndDate()));
        Assert.assertTrue(campaignDetail.validateCampaignParent(parentCampaign));
        LOGGER.info("Campaign has been created");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignDetail.clickDeleteBtn(true);
        LOGGER.info("Campaign was deleted");
        mainPage = campaignDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignDetail = campaignsHome.selectRecentItem(parentCampaign);
        campaignDetail.clickDeleteBtn(true);
        LOGGER.info("Campaign Parent was deleted");
    }
}