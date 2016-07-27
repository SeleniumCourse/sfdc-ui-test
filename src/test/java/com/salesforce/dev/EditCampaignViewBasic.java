package com.salesforce.dev;

import com.google.common.collect.Iterables;
import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Base.SearchLookupBase;
import com.salesforce.dev.pages.Campaigns.*;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Objects.CampaignGenie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Veronica Prado on 8/22/2015.
 */
public class EditCampaignViewBasic {
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
        Transporter.login ();
        nameView = viewSalesForce.getViewName();
        mainPage = Transporter.driverMainPage();
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
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Campaign View has been updated");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        campaignViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Campaign View was deleted");
    }
}
