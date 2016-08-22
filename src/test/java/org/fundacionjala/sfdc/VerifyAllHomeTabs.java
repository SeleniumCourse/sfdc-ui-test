package org.fundacionjala.sfdc;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.accounts.AccountsHome;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.cases.CasesHome;
import org.fundacionjala.sfdc.pages.chatter.ChatterHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsHome;
import org.fundacionjala.sfdc.pages.contracts.ContractsHome;
import org.fundacionjala.sfdc.pages.forecasts.ForecastsHome;
import org.fundacionjala.sfdc.pages.leads.LeadsHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunitiesHome;
import org.fundacionjala.sfdc.pages.orders.OrdersHome;
import org.fundacionjala.sfdc.pages.solutions.SolutionsHome;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * This class will test all tabs pages from Salesforce.
 *
 * @author Monica Pardo.
 * @author Bruno Barrios.
 * @since 6/24/2015.
 */
public class VerifyAllHomeTabs {

    private NavigationBar navigationBar;

    @BeforeMethod(groups = {"Smoke"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Smoke"})
    public void testVerifyAllHomeTabs() {
        ChatterHome chatterHome = navigationBar.goToChatterHome();
        assertTrue(chatterHome.isUserInChatterTab(), "Chatter page not displayed");

        CampaignsHome campaignsHome = navigationBar.goToCampaignsHome();
        assertTrue(campaignsHome.isUserInCampaignsTab(), "Campaings page not displayed");

        LeadsHome leadsHome = navigationBar.gotToLeadsHome();
        assertTrue(leadsHome.isUserInLeadsTab(), "lead page not displayed");

        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        assertTrue(accountsHome.isUserInAccountsTab(), "Accounts page not displayed");

        ContactsHome contactsHome = navigationBar.goToContactsHome();
        assertTrue(contactsHome.isUserInContactsTab(), "Contacts page not displayed");

        OpportunitiesHome opportunitiesHome = navigationBar.goToOpportunitiesHome();
        assertTrue(opportunitiesHome.isUserInOpportunitiesTab(), "Opportunities page not displayed");

        ForecastsHome forecastsHome = navigationBar.goToForesCastsHome();
        assertTrue(forecastsHome.isUserInForecastsTab(), "Forecasts page not displayed");

        ContractsHome contractsHome = navigationBar.goToContractsHome();
        assertTrue(contractsHome.isUserInContractsTab(), "Contracts page not displayed");

        OrdersHome ordersHome = navigationBar.goToOrdersHome();
        assertTrue(ordersHome.isUserInOrdersTab(), "Orders page not displayed");

        CasesHome casesHome = navigationBar.goToCasesHome();
        assertTrue(casesHome.isUserInCasesTab(), "Cases page not displayed");

        SolutionsHome solutionsHome = navigationBar.goToSolutionsHome();
        assertTrue(solutionsHome.isUserInSolutionsTab(), "Solutions page not displayed");
    }
}
