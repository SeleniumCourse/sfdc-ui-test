package org.fundacionjala.sfdc.accounts;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.Account;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountSteps;
import org.fundacionjala.sfdc.pages.accounts.AccountsHome;
import org.fundacionjala.sfdc.pages.base.NavigationBar;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to test the edition of an account.
 *
 * @author Walter.
 */
public class EditAccount {

    private AccountDetail accountDetail;

    private NavigationBar navigationBar;

    private AccountsHome accountsHome;

    private AccountForm accountForm;

    private Account account;

    private String accountName = "AccountName";

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        account = JSONMapper.getGeneric(Account.class, "CreateAccountBase.json");
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountForm = accountsHome.clickNewBtn();
        accountName = "AccountName";
        accountForm.setAccountNameFld(accountName);
        accountDetail = accountForm.clickSaveBtn();
        mainPage = accountDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void testEditAccount() {
        accountsHome = navigationBar.goToAccountsHome();
        accountDetail = accountsHome.selectRecentItem(accountName);
        accountForm = accountDetail.clickEditBtn();
        Map<AccountSteps, Object> mapAccount = account.convertToMap();
        mapAccount.keySet().stream().forEach(step -> accountForm.getStrategyStepMap(mapAccount).get(step).executeStep());
        accountDetail = accountForm.clickSaveBtn();
        Map<Enum, Object> mapExpected = accountDetail.getAssertionMap();
        mapAccount.keySet().stream().forEach(step -> assertEquals(String.valueOf(mapExpected.get(step)), String.valueOf(mapAccount.get(step))));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
