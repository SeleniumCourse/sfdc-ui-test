package org.fundacionjala.sfdc.campaign;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.FieldToDisplayView;
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
 * This class will be used to test the creation of a Campaing with filters view.
 *
 * @author Veronica.
 */
public class CreateCampaignViewFiltersFieldsAdded {

    private CampaignsHome campaignsHome;

    private CampaignView campaignView;

    private MainPage mainPage;

    private NavigationBar navigationBar;

    private ViewDetailBase campaignViewDetail;

    private ViewSalesForce viewSalesForce;


    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        viewSalesForce = JSONMapper.getGeneric(ViewSalesForce.class,"CreateCampaignViewFiltersFieldAdded.json");
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateCampaignViewWithFilters() {
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignView = campaignsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        campaignView.addAdditionalFilters(viewSalesForce);
        List<FieldToDisplayView> fieldToDisplayViews = campaignView.selectFieldsToDisplay(viewSalesForce);

        campaignViewDetail = campaignView.clickSaveBtn();
        assertTrue(campaignViewDetail.validateNameView(viewSalesForce.getViewName()));
        //validateFieldsAdded
        for (FieldToDisplayView fields : fieldToDisplayViews) {
            Assert.assertTrue(campaignViewDetail.validateFieldDisplayed(fields.getFieldToDisplay()));
        }
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignViewDetail.clickDeleteLnk();
    }
}
