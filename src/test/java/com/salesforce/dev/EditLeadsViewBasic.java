package com.salesforce.dev;

import java.util.Iterator;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Leads.LeadView;
import com.salesforce.dev.pages.Leads.LeadViewDetail;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Objects.LeadGenie;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Ariel Mattos on 07/09/2015.
 */
public class EditLeadsViewBasic {
    private static final Logger LOGGER = Logger.getLogger(EditLeadsViewBasic.class.getName());
    private LeadsHome leadsHome;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private LeadView leadView;
    private String viewName;
    private LeadViewDetail leadViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("EditLeadsViewBasic.json");
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        ViewSalesForce viewSalesForce = LeadGenie.getLeadsView("CreateLeadsViewBasic.json");
        viewName = viewSalesForce.getViewName();
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        leadsHome = navigationBar.gotToLeadsHome();
        leadView = leadsHome.clickNewViewLnk()
                .setViewName(viewName)
                .setUniqueViewName(viewSalesForce.getUniqueViewName());
        leadViewDetail = leadView.clickSaveBtn();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testEditCampaign(ViewSalesForce viewSalesForceUpdate) {
        navigationBar = mainPage.gotoNavBar();
        leadsHome = navigationBar.gotToLeadsHome();
        leadView = leadsHome.clickEditViewLnk(viewName)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwner(viewSalesForceUpdate.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        leadViewDetail = leadView.clickSaveBtn();
        Assert.assertTrue(leadViewDetail.validateNameView(viewSalesForceUpdate.getViewName()));
        LOGGER.info("Leads View has been updated");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        leadViewDetail.clickDeleteLnk(true);
        LOGGER.info("Leads View was deleted");
    }
}
