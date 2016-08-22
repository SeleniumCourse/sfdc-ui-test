package org.fundacionjala.sfdc.campaign;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.ViewSalesForce;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.base.ViewDetailBase;
import org.fundacionjala.sfdc.pages.campaigns.CampaignView;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;

import static org.testng.Assert.assertTrue;

/**
 * This class will be used to test the edition of a Campaing with a basic view
 *
 * @author Veronica Prado.
 */
public class EditCampaignViewBasic {

    private CampaignsHome campaignsHome;

    private MainPage mainPage;

    private NavigationBar navigationBar;

    private CampaignView campaignView;

    private String nameView;

    private ViewDetailBase campaignViewDetail;

    private ViewSalesForce viewSalesForceUpdate;



    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        viewSalesForceUpdate = JSONMapper.getGeneric(ViewSalesForce.class,"EditCampaignViewBasic.json");
        ViewSalesForce viewSalesForce = JSONMapper.getGeneric(ViewSalesForce.class,"CreateCampaignViewBasic.json");
        nameView = viewSalesForce.getViewName();
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignView = campaignsHome.clickNewViewLnk()
                .setViewName(nameView)
                .setUniqueViewName(viewSalesForce.getUniqueViewName());
        campaignViewDetail = campaignView.clickSaveBtn();
    }

    @Test(groups = {"Acceptance"})
    public void testEditCampaign() {
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignView = campaignsHome.clickEditViewLnk(nameView)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwner(viewSalesForceUpdate.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        campaignViewDetail = campaignView.clickSaveBtn();
        assertTrue(campaignViewDetail.validateNameView(viewSalesForceUpdate.getViewName()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignViewDetail.clickDeleteLnk();
    }
}
