package com.salesforce.dev;

import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Cases.CasesHome;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.Contracts.ContractsHome;
import com.salesforce.dev.pages.Dashboards.DashboardsHome;
import com.salesforce.dev.pages.Forecasts.ForecastsHome;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Orders.OrdersHome;
import com.salesforce.dev.pages.Reports.ReportsHome;
import com.salesforce.dev.pages.Solutions.SolutionsHome;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Monica Pardo on 6/24/2015.
 */
public class VerifyAllHomeTabs {

    private static final Logger LOGGER = Logger.getLogger(VerifyAllHomeTabs.class.getName());

    private MainPage mainPage;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"BVT"})
    public void testVerifyAllHomeTabs() {
        NavigationBar navigationBar = mainPage.gotoNavBar();
        ChatterHome chatterHome = navigationBar.goToChatterHome();
        assertTrue(chatterHome.IsUserInChatterTab());
        CampaignsHome campaignsHome = navigationBar.goToCampaignsHome();
        assertTrue(campaignsHome.IsUserInCampaignsTab());
        LeadsHome leadsHome = navigationBar.gotToLeadsHome();
        assertTrue(leadsHome.IsUserInLeadsTab());
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        assertTrue(accountsHome.IsUserInAccountsTab());
        ContactsHome contactsHome = navigationBar.goToContactsHome();
        assertTrue(contactsHome.IsUserInContactsTab());
        OpportunitiesHome opportunitiesHome = navigationBar.goToOpportunitiesHome();
        assertTrue(opportunitiesHome.IsUserInOpportunitiesTab());
        ForecastsHome forecastsHome = navigationBar.goToForescastsHome();
        assertTrue(forecastsHome.IsUserInForecastsTab());
        ContractsHome contractsHome = navigationBar.goToContractsHome();
        assertTrue(contractsHome.IsUserInContractsTab());
        OrdersHome ordersHome = navigationBar.goToOrdersHome();
        assertTrue(ordersHome.IsUserInOrdersTab());
        CasesHome casesHome = navigationBar.goToCasesHome();
        assertTrue(casesHome.IsUserInCasesTab());
        SolutionsHome solutionsHome = navigationBar.goToSolutionsHome();
        assertTrue(solutionsHome.IsUserInSolutionsTab());
        ReportsHome reportsHome = navigationBar.goToReportsHome();
        assertTrue(reportsHome.IsUserInReportsTab());
        DashboardsHome dashboardsHome = navigationBar.goToDashboardsHome();
        assertTrue(dashboardsHome.IsUserInDashboardsTab());
        LOGGER.info("Verifying all Home Tabs");
    }
}
