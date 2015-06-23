package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.*;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class CreateLead {
    HomePage homePage;
    MainPage mainPage;
    NavigationBar navBar;


    String lastName = "JVLastName";
    String company = "JVCompany";
    String leadStatus = "Working - Contacted";

    @BeforeMethod(groups = {"BVT"})
    public void setUp(){

        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"BVT"})
    public void createLead(){
        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lastName,company,leadStatus)
                .setTitle("Tester")
                .setDescription("Desciption Test")
                .build();
        LeadDetail leadDetail = leadForm.clickSaveBtn();

        //todo: Assertions

    }

    @AfterMethod(groups={"BVT"})
    public void tearDown(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(lastName);
        leadDetail.deleteLead();

    }
}
