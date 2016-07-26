package com.salesforce.dev.pages.Login;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.TopHeader;


/**
 * Created by Veronica Prado on 8/25/2015.
 */
public class Transporter {
    private static HomePage homePage;
    private static MainPage mainPage;
    public static void login(){
        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();

    }

    public static MainPage driverMainPage(){
        return mainPage;
    }

    public static void logout(){
        TopHeader topHeader = mainPage.gotoTopHeader();
        String displayName= Environment.getInstance().getDisplayName();
        topHeader.clickUserNameMenu();
        topHeader.clickLogoutOption();

    }
}
