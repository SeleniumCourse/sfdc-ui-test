package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.dto.Lead;
import org.fundacionjala.sfdc.framework.dto.Opportunity;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.leads.LeadBuilder;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadsHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunitiesHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityBuilder;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;

/**
 * This class will be used as an Object Genie for Opportunity and Lead
 *
 * @author Jimmy Vargas.
 */
public class ObjectGenie {

    /**
     * This method creates an opportunity.
     *
     * @param oppEnum
     */
    public static void createOpportunity(Opportunity oppEnum) {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm = new OpportunityBuilder(oppEnum.opportunityName, oppEnum.closeDate, oppEnum.stage)
                .setOpDescription(oppEnum.description)
                .setOrderNumber(oppEnum.orderNumber)
                .build();
        opForm.clickSaveBtn();
    }

    /**
     * This method create a Lead.
     *
     * @param lead
     */
    public static void createLead(Lead lead) {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        NavigationBar navBar = mainPage.gotoNavBar();

        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lead.getLastName(), lead.getCompany(), lead.getLeadStatus())
                .build();
        leadForm.clickSaveBtn();
    }
}
