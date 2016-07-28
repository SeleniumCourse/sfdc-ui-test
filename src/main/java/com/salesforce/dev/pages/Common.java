package com.salesforce.dev.pages;

import com.salesforce.dev.framework.Objects.Lead;
import com.salesforce.dev.framework.Objects.Opportunity;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Leads.LeadBuilder;
import com.salesforce.dev.pages.Leads.LeadForm;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Opportunities.OpportunityBuilder;
import com.salesforce.dev.pages.Opportunities.OpportunityForm;

/**
 * Created by jimmy vargas on 6/23/2015.
 */
public class Common extends AbstractBasePage {

    public static void createOpportunity(Opportunity oppEnum) {
        MainPage mainPage = LoginPage.loginAsPrimaryUser ();
        NavigationBar navBar = mainPage.gotoNavBar();

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm = new OpportunityBuilder(oppEnum.opportunityName, oppEnum.closeDate, oppEnum.stage)
                .setOpDescription(oppEnum.description)
                .setOrderNumber(oppEnum.orderNumber)
                .build();
        opForm.clickSaveBtn();
    }

    public static void createLead(Lead lead) {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lead.lastName, lead.company, lead.leadStatus)
                .build();
        leadForm.clickSaveBtn();
    }
}
