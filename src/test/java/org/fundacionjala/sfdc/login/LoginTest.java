package org.fundacionjala.sfdc.login;

import org.fundacionjala.sfdc.framework.soap.UserInformation;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.TopHeader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * This class will be used to test the login into SalesForce web application.
 *
 * @author Monica.
 * @author Bruno Barrios.
 * @since 6/22/2015
 */
public class LoginTest {

    @Test(groups = {"Smoke"})
    public void testLogin1() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        TopHeader topHeader = mainPage.gotoTopHeader();
        String expectedUser = UserInformation.getUserFullName();
        String actualUser = topHeader.getUserName();
        assertEquals(expectedUser, actualUser, actualUser + "is logged");
    }
}
