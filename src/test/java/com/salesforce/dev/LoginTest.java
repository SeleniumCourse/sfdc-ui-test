package com.salesforce.dev;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;

import static com.salesforce.dev.framework.utils.Constants.LOGGER_MANAGER;
import static org.testng.Assert.assertEquals;

/**
 * Created by monica on 6/22/2015.
 */
public class LoginTest {
    private static final String LOGIN_TEST = LoginTest.class.getName();
    private HomePage homePage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private TopHeader topHeader;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        homePage = new HomePage();
        loginPage = homePage.clickLoginBtn();
    }

    @Test(groups = {"BVT"})
    public void testLogin() {
        mainPage = loginPage.loginAsPrimaryUser();
        topHeader = mainPage.gotoTopHeader();
        assertEquals(topHeader.getUserName(), Environment.getInstance().getDisplayName());
        LOGGER_MANAGER.addInfoLog(LOGIN_TEST,"Login on Sales Force");
    }
}