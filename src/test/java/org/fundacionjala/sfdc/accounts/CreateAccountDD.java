package org.fundacionjala.sfdc.accounts;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.Account;
import org.fundacionjala.sfdc.framework.utils.DataDrivenManager;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountSteps;
import org.fundacionjala.sfdc.pages.accounts.AccountsHome;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.NavigationBar;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to test the creation of a new account.
 *
 * @author Walter
 * @author Mijhail Villarroel
 */
public class CreateAccountDD {

    private MainPage mainPage;

    private DetailsBase accountDetail;

    private NavigationBar navigationBar;

    @DataProvider(name = "dataDriven")
    public Iterator<Object[]> getValues() {
        return DataDrivenManager.getObjects("AccountsBaseDD.json", Account.class);
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testCreateAccount(Account account) {
        AccountsHome accountsHome = navigationBar.goToAccountsHome();
        AccountForm accountForm = accountsHome.clickNewBtn()
                .setAccountNameFld(account.getAccountName())
                .setAccountDescriptionFld(account.getAccountDesc());
        accountDetail = accountForm.clickSaveBtn();
        Map<AccountSteps, Object> mapExpected = account.convertToMap();
        Map<Enum, Object> mapActual = accountDetail.getAssertionMap();
        mapExpected.keySet().forEach(step -> assertEquals(String.valueOf(mapActual.get(step)), String.valueOf(mapExpected.get(step))));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
