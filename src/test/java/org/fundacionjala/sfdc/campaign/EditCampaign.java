package org.fundacionjala.sfdc.campaign;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.Campaign;
import org.fundacionjala.sfdc.framework.soap.CampaignGenie;
import org.fundacionjala.sfdc.framework.utils.DataDrivenManager;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.base.SearchLookupBase;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignSteps;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to test the edition of a Campaing.
 *
 * @author Marcelo Vargas.
 */
public class EditCampaign {

    private static final Logger LOGGER = Logger.getLogger(EditCampaign.class.getName());

    private String campaignNameToUpdated;

    private String campaignParentName;

    private CampaignsHome campaignsHome;

    private CampaignDetail campaignDetail;

    private CampaignForm campaignForm;

    private MainPage mainPage;

    private NavigationBar navigationBar;

    private Campaign editCampaignData;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        editCampaignData = JSONMapper.getGeneric(Campaign.class,"EditCampaign.json");
        Campaign campaign = JSONMapper.getGeneric(Campaign.class,"CreateCampaign.json");
        CampaignGenie.createParentCampaign(campaign.getParentCampaign());
        campaignNameToUpdated = campaign.getCampaignName();
        campaignParentName = campaign.getParentCampaign();

        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(campaignNameToUpdated);
        campaignForm.checkActiveCheckbox();
        campaignDetail = campaignForm.clickSaveBtn();
        mainPage = campaignDetail.gotoMainPage();
    }

    @DataProvider(name = "dataDriven")
    public Iterator<Object[]> getValues() {
        return DataDrivenManager.getObjects("EditCampaign.json", Campaign.class);
    }

    @Test(groups = {"Acceptance"})
    public void testEditCampaign() {
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignDetail = campaignsHome.selectRecentItem(campaignNameToUpdated);
        campaignForm = campaignDetail.clickEditBtn()
                .setCampaignName(editCampaignData.getCampaignName())
                .setTypeSelect(editCampaignData.getCampaignType())
                .setStatusSelect(editCampaignData.getCampaignStatus())
                .setStartDate(editCampaignData.getStartDate())
                .setEndDate(editCampaignData.getEndDate())
                .clickPanel()
                .setExpectedRevenue(editCampaignData.getExpectedRevenue())
                .setBudgetedCost(editCampaignData.getBudgetedCost())
                .setActualCost(editCampaignData.getActualCost())
                .setExpectedResponse(editCampaignData.getExpectedResponse())
                .setNumSent(editCampaignData.getNumSent());
        SearchLookupBase searchLookup = campaignForm.clickLookupParentCampaign();
        searchLookup.searchText(editCampaignData.getParentCampaign());
        campaignForm = searchLookup.goToCampaignForm();
        campaignDetail = campaignForm.clickSaveBtn();

        campaignParentName = editCampaignData.getParentCampaign();

        Map<CampaignSteps, Object> mapCampaign = editCampaignData.convertToMap();
        Map<Enum, Object> mapExpected = campaignDetail.getAssertionMap();
        mapCampaign.keySet().forEach(step -> assertEquals(String.valueOf(mapExpected.get(step)), String.valueOf(mapCampaign.get(step))));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignDetail.clickDeleteButton();
        mainPage = campaignDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignDetail = campaignsHome.selectRecentItem(campaignParentName);
        campaignDetail.clickDeleteButton();
    }
}
