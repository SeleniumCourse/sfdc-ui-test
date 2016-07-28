package com.salesforce.dev;

import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Marcelo.Vargas on 6/24/2015.
 */
public class TestCookies {
    private static final Logger LOGGER = Logger.getLogger(TestCookies.class.getName());

    private MainPage mainPage;

    @BeforeMethod(groups = {"BVT"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
    }

    @Test(groups = {"BVT"})
    public void testCookies() {
        TopHeader topHeader = mainPage.gotoTopHeader();
        LOGGER.info("Verifying Cookies");
        assertTrue(topHeader.checkIfCookieIsPresent());
    }
}
