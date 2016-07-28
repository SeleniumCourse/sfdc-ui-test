package com.salesforce.dev;

/**
 * Created by Luffy on 22/06/2015.
 */

import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Walter on 13/06/2015.
 */
public class LogoutTest {

    private static final Logger LOGGER = Logger.getLogger(LogoutTest.class.getName());

    private MainPage mainPage;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"BVT"})
    public void testLogout() {
        TopHeader topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        LoginPage loginPage = topHeader.clickLogoutOption();
        assertTrue(loginPage.isLoginButtonPresent());
        LOGGER.info("Logout from SalesForce");
    }
}
