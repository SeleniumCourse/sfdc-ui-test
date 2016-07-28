package com.salesforce.dev;

import java.util.Iterator;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Leads.LeadView;
import com.salesforce.dev.pages.Leads.LeadViewDetail;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Ariel Mattos on 06/09/2015.
 */
public class CreateLeadsViewBasic {
    private static final Logger LOGGER = Logger.getLogger(CreateLeadsViewBasic.class.getName());
    HomePage homePage;
    MainPage mainPage;
    NavigationBar navBar;
    LeadsHome leadsHome;
    LeadView leadView;
    LeadViewDetail leadViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateLeadsViewBasic.json");
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateLeadView(ViewSalesForce viewSalesForce) {
        mainPage = LoginPage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();
        leadsHome = navBar.gotToLeadsHome();
        leadView = leadsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        leadViewDetail = leadView.clickSaveBtn();
        LOGGER.info("Basic Leads View was created");
        Assert.assertTrue(leadViewDetail.validateNameView(viewSalesForce.getViewName()),
                "View name does not match " + viewSalesForce.getViewName());
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        leadViewDetail.clickDeleteLnk(true);
        LOGGER.info("Lead View was deleted");
    }
}
