package org.fundacionjala.sfdc.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.TopHeader;

import static org.junit.Assert.assertTrue;

/**
 * This class will be used to test the logout option of Salesforce web application
 *
 * @author Walter.
 * @author Luffy.
 * @author Bruno Barrios.
 */
public class LogoutTest {

    private MainPage mainPage;

    @BeforeMethod(groups = {"Smoke"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"Smoke"})
    public void testLogout() {
        TopHeader topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        LoginPage loginPage = topHeader.clickLogoutOption();
        assertTrue(loginPage.isLoginButtonPresent());
    }
}
