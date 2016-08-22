package org.fundacionjala.sfdc.accounts;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.Account;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountSteps;
import org.fundacionjala.sfdc.pages.accounts.AccountsHome;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.NavigationBar;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to the creation of a new account
 *
 * @author Walter
 * @author Mijhail Villarroel
 */
public class CreateAccount {

    private MainPage mainPage;

    private DetailsBase accountDetail;

    private Map<AccountSteps, Object> mapAccount;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mapAccount = JSONMapper.getGeneric(Account.class, "CreateAccountBase.json").convertToMap();
        mainPage = LoginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateAccount() {
        NavigationBar navigationBar = mainPage.gotoNavBar();
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        AccountForm accountForm = accountsHome.clickNewBtn();
        mapAccount.keySet().forEach(step -> accountForm.getStrategyStepMap(mapAccount).get(step).executeStep());
        accountDetail = accountForm.clickSaveBtn();
        Map<Enum, Object> mapExpected = accountDetail.getAssertionMap();
        mapAccount.keySet().forEach(step -> assertEquals(String.valueOf(mapExpected.get(step)), String.valueOf(mapAccount.get(step))));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
