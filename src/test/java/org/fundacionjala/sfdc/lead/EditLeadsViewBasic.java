package org.fundacionjala.sfdc.lead;

import org.fundacionjala.sfdc.framework.dto.ViewSalesForce;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.leads.LeadView;
import org.fundacionjala.sfdc.pages.leads.LeadViewDetail;
import org.fundacionjala.sfdc.pages.leads.LeadsHome;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class will be used to test the basic view of the edition of a lead.
 *
 * @author Ariel Mattos.
 * @since 07/09/2015.
 */
public class EditLeadsViewBasic {

    private LeadsHome leadsHome;

    private MainPage mainPage;

    private NavigationBar navigationBar;

    private LeadView leadView;

    private String viewName;

    private LeadViewDetail leadViewDetail;

    private ViewSalesForce viewSalesForceUpdate;


    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        viewSalesForceUpdate = JSONMapper.getGeneric(ViewSalesForce.class,"EditLeadsViewBasic.json");
        ViewSalesForce viewSalesForce =  JSONMapper.getGeneric(ViewSalesForce.class,"CreateLeadsViewBasic.json");
        viewName = viewSalesForce.getViewName();
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        leadsHome = navigationBar.gotToLeadsHome();
        leadView = leadsHome.clickNewViewLnk()
                .setViewName(viewName)
                .setUniqueViewName(viewSalesForce.getUniqueViewName());
        leadViewDetail = leadView.clickSaveBtn();
    }

    @Test(groups = {"Acceptance"})
    public void testEditCampaign() {
        navigationBar = mainPage.gotoNavBar();
        leadsHome = navigationBar.gotToLeadsHome();
        leadView = leadsHome.clickEditViewLnk(viewName)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwner(viewSalesForceUpdate.getFilterByOwner())
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        leadViewDetail = leadView.clickSaveBtn();
        Assert.assertTrue(leadViewDetail.validateNameView(viewSalesForceUpdate.getViewName()));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        leadViewDetail.clickDeleteLnk();
    }
}
