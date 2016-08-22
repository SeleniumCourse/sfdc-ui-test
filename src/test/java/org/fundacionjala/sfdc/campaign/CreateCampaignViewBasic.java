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
 * This class will be used to test the creation of a campaign with basic view.
 *
 * @author Veronica Prado.
 * @author Mijhail Villarroel.
 */
public class CreateCampaignViewBasic {

    private NavigationBar navigationBar;

    private ViewDetailBase campaignViewDetail;

    private ViewSalesForce viewSalesForce;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        viewSalesForce = JSONMapper.getGeneric(ViewSalesForce.class,"CreateCampaignViewBasic.json");
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateCampaignView( ) {
        CampaignsHome campaignsHome = navigationBar.goToCampaignsHome();
        CampaignView campaignView = campaignsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        campaignViewDetail = campaignView.clickSaveBtn();
        assertTrue(campaignViewDetail.validateNameView(viewSalesForce.getViewName()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignViewDetail.clickDeleteLnk();
    }
}
