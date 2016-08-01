package com.salesforce.dev.oportunity;

import com.salesforce.dev.framework.dto.Opportunity;
import com.salesforce.dev.framework.utils.JSONMapper;
import com.salesforce.dev.pages.HomePage;
import com.salesforce.dev.pages.LoginPage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.base.NavigationBar;
import com.salesforce.dev.pages.opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.opportunities.OpportunityBuilder;
import com.salesforce.dev.pages.opportunities.OpportunityDetail;
import com.salesforce.dev.pages.opportunities.OpportunityForm;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Jimmy Vargas on 6/10/2015.
 */
public class CreateOpportunity {

    private HomePage homePage;

    private MainPage mainPage;

    private NavigationBar navBar;

    private Opportunity oppEnum;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();
        oppEnum = JSONMapper.getOpportunity("CreateOpportunity.json");
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
        OpportunityDetail opDetail = opHome.openOpportunity(oppEnum.opportunityName);
        opDetail.deleteOpportunity();
    }
}
