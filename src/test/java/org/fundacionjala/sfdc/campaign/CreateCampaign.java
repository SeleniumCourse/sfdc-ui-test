package org.fundacionjala.sfdc.campaign;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.Campaign;
import org.fundacionjala.sfdc.framework.soap.CampaignGenie;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.base.SearchLookupBase;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignSteps;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to test the creation of a new Campaign.
 *
 * @author Marcelo.Vargas.
 * @author Mijhail Villarroel.
 */
public class CreateCampaign {

    private String parentCampaign;

    private DetailsBase campaignDetail;

    private NavigationBar navigationBar;
    Campaign campaign;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        campaign= JSONMapper.getGeneric(Campaign.class,"CreateCampaign.json");
        parentCampaign = campaign.getParentCampaign();
        CampaignGenie.createParentCampaign(parentCampaign);
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateCampaign() {
        CampaignsHome campaignsHome = navigationBar.goToCampaignsHome();
        CampaignForm campaignForm = campaignsHome.clickNewBtn()
                .setEndDate(campaign.getEndDate())
                .setStartDate(campaign.getStartDate())
                .setCampaignName(campaign.getCampaignName())
                .checkActiveCheckbox()
                .setTypeSelect(campaign.getCampaignType())
                .setStatusSelect(campaign.getCampaignStatus())
                .setExpectedRevenue(campaign.getExpectedRevenue())
                .setBudgetedCost(campaign.getBudgetedCost())
                .setActualCost(campaign.getActualCost())
                .setExpectedResponse(campaign.getExpectedResponse())
                .setNumSent(campaign.getNumSent());
        SearchLookupBase searchLookup = campaignForm.clickLookupParentCampaign();
        searchLookup.searchText(parentCampaign);
        campaignForm = searchLookup.goToCampaignForm();
        campaignDetail = campaignForm.clickSaveBtn();
        Map<CampaignSteps, Object> mapExpected = campaign.convertToMap();
        Map<Enum, Object> mapActual = campaignDetail.getAssertionMap();
        mapExpected.keySet().forEach(step -> assertEquals(String.valueOf(mapActual.get(step)), String.valueOf(mapExpected.get(step))));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignDetail.clickDeleteButton();
    }
}
