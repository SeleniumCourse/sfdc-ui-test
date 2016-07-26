package com.salesforce.dev;

import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Lead;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.*;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
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

    Lead lead;



    @BeforeMethod(groups = {"Acceptance"})
    public void setUp(){
        System.out.println();
        mainPage = Transporter.driverMainPage();
        navBar = mainPage.gotoNavBar();

        lead = JSONMapper.getLead("src\\test\\resources\\CreateLead.json");
    }

    @Test(groups = {"Acceptance"})
    public void testCreateLead(){
        LeadsHome leadsHome = navBar.gotToLeadsHome();
        leadsHome.clickNewBtn();

        LeadForm leadForm = new LeadBuilder(lead.lastName, lead.company, lead.leadStatus)
                .setCampaign(lead.campaignLookup)
                .setSalutation(lead.nameSalutation)
                .setFirstName(lead.firstName)
                .setTitle(lead.title)
                .setLeadSource(lead.leadSource)
                .setIndustry(lead.industry)
                .setAnnualRevenue(lead.annualRevenue)
                .setPhone(lead.phone)
                .setMobile(lead.mobile)
                .setFax(lead.fax)
                .setEmail(lead.email)
                .setWebsite(lead.website)
                .setLeadStatus(lead.leadStatus)
                .setRating(lead.rating)
                .setNumEmployees(lead.numEmployees)
                .setStreet(lead.street)
                .setCity(lead.city)
                .setStateProvince(lead.stateProvince)
                .setZipPostalCode(lead.zipCode)
                .setCountry(lead.country)
                .setProductInterest(lead.productInterest)
                .setSICcode(lead.SICCode)
                .setNumberLocations(lead.numberLocations)
                .setCurrentGenerators(lead.currentGenerators)
                .setPrimary(lead.primary)
                .setDescription(lead.description)
                .build();
        LeadDetail leadDetail = leadForm.clickSaveBtn();

        //Assertions
        Assert.assertTrue(leadDetail.getName().contains(lead.lastName), "The actual name doesn't contain the lastname" + lead.lastName);
        Assert.assertEquals(leadDetail.getCompany(), lead.company, "The company are not equal");
        Assert.assertEquals(leadDetail.getTitle(), lead.title, "The title is not correct");
        Assert.assertEquals(leadDetail.getLeadSource(), lead.leadSource,"The lead source is not correct");
        Assert.assertEquals(leadDetail.getIndustry(), lead.industry, "The industry is not correct");
        Assert.assertEquals(leadDetail.getPhone(), lead.phone,"The phone is not correct");
        Assert.assertEquals(leadDetail.getMobile(), lead.mobile,"The mobile is not correct");
        Assert.assertEquals(leadDetail.getFax(), lead.fax,"The fax is not correct");
        Assert.assertEquals(leadDetail.getEmail(), lead.email,"The email is not correct");
        Assert.assertEquals(leadDetail.getWebsite(), "http://"+lead.website,"The website is not correct");
        Assert.assertEquals(leadDetail.getLeadStatus(), lead.leadStatus,"The lead status is not correct");
        Assert.assertEquals(leadDetail.getRating(), lead.rating,"The rating is not correct");
        Assert.assertEquals(leadDetail.getNumEmployees(), lead.numEmployees,"The number of employees is not correct");
        Assert.assertEquals(leadDetail.getAddress(), lead.street + "\n" +
                lead.city + ", " +
                lead.stateProvince + " " +
                lead.zipCode + "\n" +
                lead.country, "The address is not correct");//needs to review


        Assert.assertEquals(leadDetail.getProductInterest(), lead.productInterest,"The product interest is not correct");
        Assert.assertEquals(leadDetail.getSICcode(), lead.SICCode,"The SICCode is not correct");
        Assert.assertEquals(leadDetail.getNumLocations(), lead.numberLocations,"The number of locations is not correct");
        Assert.assertEquals(leadDetail.getDescription(), lead.description,"The description is not correct");
        Assert.assertEquals(leadDetail.getCurrentGenerators(), lead.currentGenerators,"The current generators is not correct");
        Assert.assertEquals(leadDetail.getPrimary(), lead.primary,"The primary is not correct");
    }

    @AfterMethod(groups={"Acceptance"})
    public void tearDown(){
        LeadsHome leadsHome = mainPage.gotoNavBar().gotToLeadsHome();
        LeadDetail leadDetail = leadsHome.openLead(lead.lastName+", "+lead.firstName);
        leadDetail.deleteLead();

    }
}
