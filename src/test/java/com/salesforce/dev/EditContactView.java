package com.salesforce.dev;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.LoggerManager;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.framework.RamdonGenerator;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Contacts.ContactView;
import com.salesforce.dev.pages.Contacts.ContactViewDetail;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.MainPage;
import com.salesforce.dev.pages.Objects.CampaignGenie;

import java.util.Iterator;

/**
 * Created by alex on 06/09/2015.
 */

public class EditContactView {
    private ContactsHome contactsHome;
    private ContactViewDetail contactViewDetail;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private DataDrivenManager dataDriveManager = new DataDrivenManager();
    private ContactView contactView;
    private String nameView;

    @DataProvider(name = "dataDriven")
    public Iterator<ViewSalesForce[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getDataView("EditContactView.json");
    }
    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        ViewSalesForce viewSalesForce = CampaignGenie.getCampaignView("CreateContactView.json");
        nameView = viewSalesForce.getViewName();

        homePage = new HomePage();
        mainPage = homePage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();

        contactsHome = navigationBar.goToContactsHome();
        contactView = contactsHome.clickNewViewLnk()
                .setViewName(viewSalesForce.getViewName())
                .setUniqueViewName(viewSalesForce.getUniqueViewName());
        contactViewDetail = contactView.clickSaveBtn();
    }


    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testEditContact(ViewSalesForce viewSalesForceUpdate) {
        homePage = new HomePage();
        mainPage = homePage.getLogin ();
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        String fieldToUpdate ="View Name";
        String newValue = "viewUpdatedContact" + RamdonGenerator.getInstance().getRamdonString();
        contactView = contactsHome.clickEditViewLnk(nameView)
                .setViewName(viewSalesForceUpdate.getViewName())
                .setUniqueViewName(viewSalesForceUpdate.getUniqueViewName())
                .checkFilterByOwnerAll()
                .checkFilterByOwnerMy()
                .selectRestrictVisibility(viewSalesForceUpdate.getRestrictVisibility());
        contactViewDetail  = contactView.clickSaveBtn();
        Assert.assertFalse(contactViewDetail.validateNameView("anyname"));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        contactViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Contact was deleted");
        mainPage = contactViewDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        //Añadir paso
        contactViewDetail.clickDeleteLnk(true);
        LoggerManager.getInstance().addInfoLog(this.getClass().getName(),
                "Contact Parent was deleted");
    }
}
