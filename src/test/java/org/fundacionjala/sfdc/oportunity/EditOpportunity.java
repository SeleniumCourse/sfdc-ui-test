package org.fundacionjala.sfdc.oportunity;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.Opportunity;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.ObjectGenie;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.opportunities.OpportunitiesHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;

/**
 * This class is used to test the edition of an Opportunity.
 *
 * @author Jimmy Vargas
 * @since 6/20/2015.
 */
public class EditOpportunity {

    private MainPage mainPage;

    private NavigationBar navBar;

    private Opportunity oppEnum;

    private Opportunity oppEditEnum;

    @BeforeMethod(groups = {"Acceptance"})
    public void setup() {
        oppEnum = JSONMapper.getGeneric(Opportunity.class, "CreateOpportunityBase.json");
        oppEditEnum = JSONMapper.getGeneric(Opportunity.class, "EditOpportunity.json");
        mainPage = LoginPage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();

        ObjectGenie.createOpportunity(oppEnum);
    }

    @Test(groups = {"Acceptance"})
    public void testEditOpportunity() {
        OpportunitiesHome opTab = navBar.goToOpportunitiesHome();
        OpportunityDetail opDetail = opTab.openOpportunity(oppEnum.opportunityName);
        OpportunityForm opForm = opDetail.clickEditBtn();
        opForm.setOpportunityName(oppEditEnum.opportunityName);
        opForm.setCloseDate(oppEditEnum.closeDate);
        opForm.selectStageByVisibleText(oppEditEnum.stage);
        opForm.setPrivateCheckBox(oppEditEnum.privateChk);
        opForm.selectTypeByVisibleText(oppEditEnum.type);
        opForm.selectLeadSourceByVisibleText(oppEditEnum.leadSource);
        opForm.setNextStep(oppEditEnum.nextStep);
        opForm.setAmount(oppEditEnum.amount);
        opForm.setProbability(oppEditEnum.probability);
        opForm.setOrderNumber(oppEditEnum.orderNumber);
        opForm.setTrackingNumber(oppEditEnum.trackingNumber);
        opForm.setMainCompetitors(oppEditEnum.mainCompetitors);
        opForm.selectDeliveryStatusByVisibleText(oppEditEnum.deliveryStatus);
        opForm.setDescription(oppEditEnum.description);
        OpportunityDetail oppDetail = opForm.clickSaveBtn();
        oppDetail.validateFields(oppEditEnum);
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        OpportunitiesHome opHome = mainPage.gotoNavBar().goToOpportunitiesHome();
        DetailsBase opDetail = opHome.openOpportunity(oppEditEnum.opportunityName);
        opDetail.clickDeleteButton();
    }
}
