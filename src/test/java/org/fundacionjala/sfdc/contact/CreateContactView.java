package org.fundacionjala.sfdc.contact;

import java.util.List;

import org.fundacionjala.sfdc.framework.dto.FieldToDisplayView;
import org.fundacionjala.sfdc.framework.dto.FilterView;
import org.fundacionjala.sfdc.framework.dto.ViewSalesForce;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.framework.utils.RandomGenerator;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.contacts.ContactView;
import org.fundacionjala.sfdc.pages.contacts.ContactViewDetail;
import org.fundacionjala.sfdc.pages.contacts.ContactsHome;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

/**
 * This class will be used to test the view of the cretion of a contact.
 *
 * @author Alexander Apaza.
 * @since 6/12/2015.
 */
public class CreateContactView {

    private ContactsHome contactHome;

    private ContactView contactView;

    private ContactViewDetail contactViewDetail;

    private CampaignsHome campaignsHome;

    private MainPage mainPage;

    private NavigationBar navigationBar;

    private String campaignName;

    private CampaignForm campaignForm;

    private ViewSalesForce viewSalesForce;


    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        viewSalesForce = JSONMapper.getGeneric(ViewSalesForce.class,"CreateContactView.json");
        campaignName = "Camp" + RandomGenerator.getInstance().getRandomString();
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignForm = campaignsHome.clickNewBtn();
        campaignForm.setCampaignName(campaignName);
        campaignForm.checkActiveCheckbox();
        campaignForm.clickSaveBtn();
    }

    @Test(groups = {"Acceptance"})
    public void testCreateContactView() {
        contactHome = navigationBar.goToContactsHome();
        contactView = contactHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName())
                .checkFilterByOwnerAll()
                .checkFilterByOwnerMy()
                .setFilterByCampaign(campaignName)
                .selectRestrictVisibility(viewSalesForce.getRestrictVisibility());

        List<FilterView> additionalField = viewSalesForce.getAdditionalFields();
        int count = 1;
        for (FilterView addFilter : additionalField) {
            contactView = contactView.addAdditionalFiltersByField(count, addFilter.getFieldFilter(),
                    addFilter.getOperatorFilter(), addFilter.getValueFilter());
            count++;
        }
        List<FieldToDisplayView> fieldToDisplayViews = viewSalesForce.getFieldsDisplay();
        for (FieldToDisplayView fields : fieldToDisplayViews)
            contactView = contactView.addNewFieldToDisplay(fields.getFieldToDisplay());
        contactViewDetail = contactView.clickSaveBtn();
        assertFalse(contactViewDetail.validateNameView("AnyName"));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        contactViewDetail.clickDeleteLnk();
    }
}
