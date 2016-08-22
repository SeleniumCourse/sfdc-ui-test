package org.fundacionjala.sfdc.lead;

import org.fundacionjala.sfdc.framework.dto.Campaign;
import org.fundacionjala.sfdc.framework.dto.Lead;
import org.fundacionjala.sfdc.framework.soap.CampaignGenie;
import org.fundacionjala.sfdc.framework.utils.JSONMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.leads.LeadBuilder;
import org.fundacionjala.sfdc.pages.leads.LeadDetail;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadsHome;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class will be used to test the creation of a lead.
 *
 * @author Jimmy Vargas.
 * @since 6/15/2015.
 */
public class CreateLead {
    
    private NavigationBar navBar;

    private Lead lead;

    private CampaignsHome campaignsHome;

    private CampaignDetail campaignDetail;

    private String parentCampaign = "CampaignParent";

    private MainPage mainPage; 

    private NavigationBar navigationBar;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        lead = JSONMapper.getGeneric(Lead.class,"CreateLead.json");
        Campaign campaign = JSONMapper.getGeneric(Campaign.class,"CreateCampaign.json");
        mainPage = LoginPage.loginAsPrimaryUser();
        navBar = mainPage.gotoNavBar();
        CampaignGenie.createParentCampaign(campaign.getParentCampaign());
    }

    @Test(groups = {"Acceptance"})
    public void testCreateLead() {
        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lead.getLastName(), lead.getCompany(), lead.getLeadStatus())
                .setCampaign(lead.getCampaignLookup())
                .setSalutation(lead.getNameSalutation())
                .setFirstName(lead.getFirstName())
                .setTitle(lead.getTitle())
                .setLeadSource(lead.getLeadSource())
                .setIndustry(lead.getIndustry())
                .setAnnualRevenue(lead.getAnnualRevenue())
                .setPhone(lead.getPhone())
                .setMobile(lead.getMobile())
                .setFax(lead.getFax())
                .setEmail(lead.getEmail())
                .setWebsite(lead.getWebsite())
                .setLeadStatus(lead.getLeadStatus())
                .setRating(lead.getRating())
                .setNumEmployees(lead.getNumEmployees())
                .setStreet(lead.getStreet())
                .setCity(lead.getCity())
                .setStateProvince(lead.getStateProvince())
                .setZipPostalCode(lead.getZipCode())
                .setCountry(lead.getCountry())
                .setProductInterest(lead.getProductInterest())
                .setSicCode(lead.getSicCode())
                .setNumberLocations(lead.getNumberLocations())
                .setCurrentGenerators(lead.getCurrentGenerators())
                .setPrimary(lead.getPrimary())
                .setDescription(lead.getDescription())
                .build();
        LeadDetail leadDetail = leadForm.clickSaveBtn();
        Assert.assertEquals(leadDetail.getWebsite(), "http://" + lead.getWebsite(), "The website is not correct");
        Assert.assertEquals(leadDetail.getAddress(), lead.getStreet() + "\n" +
                lead.getCity() + ", " +
                lead.getStateProvince ()+ " " +
                lead.getZipCode() + "\n" +
                lead.getCountry(), "The address is not correct");
        leadDetail.validateFields(lead);
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        DetailsBase leadDetail = leadsHome.openLead(lead.getLastName() + ", " + lead.getFirstName());
        leadDetail.clickDeleteButton();
        navigationBar = mainPage.gotoNavBar();
        campaignsHome = navigationBar.goToCampaignsHome();
        campaignDetail = campaignsHome.selectRecentItem(parentCampaign);
        campaignDetail.clickDeleteButton();
    }
}
