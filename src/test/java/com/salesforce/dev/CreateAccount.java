package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Account;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by Walter on 13/06/2015.
 */
public class CreateAccount {

    private LoginPage loginPage;

    private HomePage homePage;
    private MainPage mainPage;
    private AccountDetail accountDetail;
    private NavigationBar navigationBar;
    private DataDrivenManager dataDrivenManager;


    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        dataDrivenManager = new DataDrivenManager();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateAccount() {

        NavigationBar navigationBar = mainPage.gotoNavBar();
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        AccountForm accountForm = accountsHome.clickNewBtn();
        Account account = JSONMapper.getAccountBase();
        accountForm.setAccountNameFld(account.getAccountName());
        accountForm.setAccountRatingFld(account.getRating());
        accountForm.setAccountOwnershipFld(account.getOwnership());
        accountForm.setAccountPhoneFld(account.getPhone());
        accountForm.setAccountFaxFld(account.getFax());
        accountForm.setAccountNumberFld(account.getNumber());
        accountForm.setAccountWebsiteFld(account.getWebsite());
        accountForm.setAccountSiteFld(account.getAccountSite());
        accountForm.setAccountThickerFld(account.getTickerSymbol());
        accountForm.setAccountTypeFld(account.getType());
        accountForm.setAccountIndustryFld(account.getIndustry());
        accountForm.setAccountEmployeesFld(account.getEmployees());
        accountForm.setAccountAnnualRevenueFld(account.getAnnualRevenue());
        accountForm.setAccountSICCodeFld(account.getSicCode());
        accountForm.setAccountBillingStreetFld(account.getBillingAddress());
        accountForm.setAccountShippingStreetFld(account.getShippingAddress());
        accountForm.setAccountCustomerPriorityFld(account.getCustomerPriority());
        accountForm.setAccountSLAFld(account.getSla());
        accountForm.setAccountUpsellOpportunityFld(account.getUpsellOpportunity());
        accountForm.setAccountActiveFld(account.getActive());
        accountForm.setAccountSLAExpirationDateFld(account.getSlaExpirationDate());
        //accountForm.setAccountSLAExpirationDateFld(6,15,2016);
        accountForm.setAccountSLASerialNumberFld(account.getSlaSerialNumber());
        accountForm.setAccountNumberLocationsFld(account.getNumberOfLocations());
        accountForm.setAccountDescriptionFld(account.getAccountDesc());

        accountDetail = accountForm.clickSaveBtn();

        Assert.assertTrue(accountDetail.validateAccountNameFld(account.getAccountName()));
        Assert.assertTrue(accountDetail.validateAccountRatingFld(account.getRating()));
        Assert.assertTrue(accountDetail.validateAccountOwnershipFld(account.getOwnership()));
        Assert.assertTrue(accountDetail.validateAccountPhoneFld(account.getPhone()));
        Assert.assertTrue(accountDetail.validateAccountFaxFld(account.getFax()));
        Assert.assertTrue(accountDetail.validateAccountNumberFld(account.getNumber()));
        Assert.assertTrue(accountDetail.validateAccountWebsiteFld(account.getWebsite()));
        Assert.assertTrue(accountDetail.validateAccountSiteFld(account.getAccountSite()));
        Assert.assertTrue(accountDetail.validateAccountTickerSymbolFld(account.getTickerSymbol()));
        Assert.assertTrue(accountDetail.validateAccountTypeFld(account.getType()));
        Assert.assertTrue(accountDetail.validateAccountIndustryFld(account.getIndustry()));
        Assert.assertTrue(accountDetail.validateAccountEmployeesFld(account.getEmployees()));
        Assert.assertTrue(accountDetail.validateAccountAnnualRevenueFld(account.getAnnualRevenue()));
        Assert.assertTrue(accountDetail.validateAccountSICCodeFld(account.getSicCode()));
        Assert.assertTrue(accountDetail.validateAccountBillingAddressFld(account.getBillingAddress()));
        Assert.assertTrue(accountDetail.validateAccountShippingAddressFld(account.getShippingAddress()));
        Assert.assertTrue(accountDetail.validateAccountCustomPriorityFld(account.getCustomerPriority()));
        Assert.assertTrue(accountDetail.validateAccountSLAFld(account.getSla()));
        Assert.assertTrue(accountDetail.validateAccountUpSellOpportunityFld(account.getUpsellOpportunity()));
        Assert.assertTrue(accountDetail.validateAccountActiveFld(account.getActive()));
        Assert.assertTrue(accountDetail.validateAccountSLAExpirationDateFld(account.getSlaExpirationDate()));
        Assert.assertTrue(accountDetail.validateAccountSerialNumberFld(account.getSlaSerialNumber()));
        Assert.assertTrue(accountDetail.validateAccountNumberOfLocationsFld(account.getNumberOfLocations()));
        Assert.assertTrue(accountDetail.validateAccountDescriptionFld(account.getAccountDesc()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountDetail.clickDeleteBtn(true);

    }
}
