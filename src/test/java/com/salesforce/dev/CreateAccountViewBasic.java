package com.salesforce.dev;

import java.util.Iterator;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.framework.RandomGenerator;
import com.salesforce.dev.pages.Accounts.AccountView;
import com.salesforce.dev.pages.Accounts.AccountViewDetail;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Carlos Orellana on 8/22/2015.
 */
public class CreateAccountViewBasic {
    private static final Logger LOGGER = Logger.getLogger(CreateAccountViewBasic.class.getName());
    private AccountsHome accountsHome;
    private AccountView accountView;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private AccountViewDetail accountViewDetail;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("CreateAccountsViewBasic.json");
    }


    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateCampaignView(ViewSalesForce viewSalesForce) {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountView = accountsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName() + RandomGenerator.getInstance().getRandomString())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwner(viewSalesForce.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());
        accountViewDetail = accountView.clickSaveBtn();
        LOGGER.info("Account was created");
        assertTrue(accountViewDetail.validateNameView(viewSalesForce.getViewName()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountViewDetail.clickDeleteLnk(true);
        LOGGER.info("Account View was deleted");
    }
}
