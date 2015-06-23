package com.salesforce.dev.pages;

import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Opportunities.*;

/**
 * Created by jimmy vargas on 6/23/2015.
 */
public class Common {

    public static void createOpportunity(OpportunityEnum oppEnum){
        System.out.println("creating an basic opportunity");

        HomePage homePage = new HomePage();
        MainPage mainPage = homePage.loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm= new OpportunityBuilder(oppEnum.opportunityName,oppEnum.closeDate,oppEnum.stage)
                .setOpDescription(oppEnum.description)
                .setOrderNumber(oppEnum.orderNumber)
                .build();
        opForm.clickSaveBtn();

    }
}
