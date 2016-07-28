package com.salesforce.dev;

import java.util.Iterator;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignView;
import com.salesforce.dev.pages.Campaigns.CampaignViewDetail;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
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
 * Created by Veronica Prado on 8/22/2015.
 */
public class EditCampaignViewBasic {
    private static final Logger LOGGER = Logger.getLogger(EditCampaignViewBasic.class.getName());
    private CampaignsHome campaignsHome;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private CampaignView campaignView;
    private String nameView;
    private CampaignViewDetail campaignViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("EditCampaignViewBasic.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        ViewSalesForce viewSalesForce = CampaignGenie.getCampaignView("CreateCampaignViewBasic.json");
        nameView = viewSalesForce.getViewName();
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignView = campaignsHome.clickNewViewLnk()
                .setViewName(nameView)
                .setUniqueViewName(viewSalesForce.getUniqueViewName());
        campaignViewDetail = campaignView.clickSaveBtn();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testEditCampaign(ViewSalesForce viewSalesForceUpdate) {
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignView = campaignsHome.clickEditViewLnk(nameView)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwner(viewSalesForceUpdate.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        campaignViewDetail = campaignView.clickSaveBtn();
        Assert.assertTrue(campaignViewDetail.validateNameView(viewSalesForceUpdate.getViewName()));
        LOGGER.info("Campaign View has been updated");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignViewDetail.clickDeleteLnk(true);
        LOGGER.info("Campaign View was deleted");
    }
}
