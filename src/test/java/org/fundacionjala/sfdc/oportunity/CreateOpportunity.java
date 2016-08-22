package org.fundacionjala.sfdc.oportunity;

import org.fundacionjala.sfdc.framework.dto.Opportunity;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.opportunities.OpportunitiesHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityBuilder;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class will be used to test the creation of an Opportunity in Salesforce web application.
 *
 * @author Jimmy Vargas.
 * @since 6/10/2015.
 */
public class CreateOpportunity {



    private MainPage mainPage;

    private NavigationBar navBar;

    private Opportunity oppEnum;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();
        oppEnum = JSONMapper.getGeneric(Opportunity.class,"CreateOpportunityBase.json");
    }

    @Test(groups = {"Acceptance"})
    public void testCreateOpportunity() {
        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        opTab.clickNewBtn();

        OpportunityForm opForm = new OpportunityBuilder(oppEnum.opportunityName, oppEnum.closeDate, oppEnum.stage)
                .setPrivate(oppEnum.privateChk)
                .setType(oppEnum.type)
                .setLeadSource(oppEnum.leadSource)
                .setAmount(oppEnum.amount)
                .setNextStep(oppEnum.nextStep)
                .setProbability(oppEnum.probability)
                .setOrderNumber(oppEnum.orderNumber)
                .setTrackingNumber(oppEnum.trackingNumber)
                .setMainCompetitors(oppEnum.mainCompetitors)
                .setDeliveryInstallationStatus(oppEnum.deliveryStatus)
                .setOpDescription(oppEnum.description)

                .build();
        OpportunityDetail opportunityDetails = opForm.clickSaveBtn();
        opportunityDetails.validateFields(oppEnum);
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        OpportunitiesHome opHome = navBar.goToOpportunitiesHome();
        DetailsBase opDetail = opHome.openOpportunity(oppEnum.opportunityName);
        opDetail.clickDeleteButton();
    }
}
