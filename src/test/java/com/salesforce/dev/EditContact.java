package com.salesforce.dev;

import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Contact;
import com.salesforce.dev.pages.Accounts.AccountDetail;
import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Base.SearchLookupBase;
import com.salesforce.dev.pages.Contacts.ContactDetail;
import com.salesforce.dev.pages.Contacts.ContactForm;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Marcelo.Vargas on 6/21/2015.
 */

public class EditContact {
    private static final Logger LOGGER = Logger.getLogger(EditContact.class.getName());
    Contact contact = JSONMapper.getContactToUpdate();

    private ContactsHome contactsHome;
    private ContactDetail contactDetail;
    private ContactForm contactForm;
    private MainPage mainPage;
    private AccountDetail accountDetail;
    private NavigationBar navigationBar;
    private AccountsHome accountsHome;
    private AccountForm accountForm;
    private SearchLookupBase searchLookup;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();

        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountForm = accountsHome.clickNewBtn();
        accountForm.setAccountNameFld(contact.getAccountName());
        accountDetail = accountForm.clickSaveBtn();
        mainPage = accountDetail.gotoMainPage();

        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();
        contactForm = contactsHome.clickNewBtn();
        contactForm.setLastName(contact.getLastNameastName());
        contactDetail = contactForm.clickSaveBtn();

        mainPage = contactDetail.gotoMainPage();
    }

    @Test(groups = {"Acceptance"})
    public void testEditContact() {
        navigationBar = mainPage.gotoNavBar();
        contactsHome = navigationBar.goToContactsHome();

        contactDetail = contactsHome.selectRecentItem(contact.getLastNameastName());
        contactForm = contactDetail.clickEditBtn();
        contactForm.setLastName(contact.getLastNameastName());

        contactForm.setFirstNameRole(contact.getcontactRole());
        contactForm.setFirstName(contact.getFirstName());

        searchLookup = contactForm.clickLookupAccount();
        searchLookup.searchText(contact.getAccountName());
        contactForm = searchLookup.goToContactForm();

        contactForm.setTitle(contact.getTitle());
        contactForm.setDepartment(contact.getDepartment());
        contactForm.setBirthDate(6, 6, 2015);

        searchLookup = contactForm.clickLookupReportsTo();
        searchLookup.searchText(contact.getReportsTo());
        contactForm = searchLookup.goToContactForm();

        contactForm.setLeadSource(contact.getLeadSource());
        contactForm.setPhone(contact.getPhone());
        contactForm.setHomePhone(contact.getHomePhone());
        contactForm.setMobile(contact.getMobile());
        contactForm.setOtherPhone(contact.getOtherPhone());
        contactForm.setFax(contact.getFax());
        contactForm.setEmail(contact.getEmail());
        contactForm.setAssistant(contact.getassistant());
        contactForm.setAssistantPhone(contact.getAssistantPhone());
        contactForm.setMailingStreet(contact.getMailingStreet());
        contactForm.setMailingCity(contact.getMailingCity());
        contactForm.setMailingState(contact.getMailingState());
        contactForm.setMailingZip(contact.getMailingZip());
        contactForm.setMailingCountry(contact.getMailingCountry());
        contactForm.setOtherStreet(contact.getOtherStreet());
        contactForm.setOtherCity(contact.getOtherCity());
        contactForm.setOtherState(contact.getOtherState());
        contactForm.setOtherZip(contact.getOtherZip());
        contactForm.setOtherCountry(contact.getOtherCountry());
        contactForm.setLanguages(contact.getLanguages());
        contactForm.setLevel(contact.getLevel());
        contactForm.setDescription(contact.getDescription());
        contactDetail = contactForm.clickSaveBtn();

        Assert.assertTrue(contactDetail.validateContactName(String.format ("%s %s %s", contact.getcontactRole(), contact.getFirstName(), contact.getLastNameastName())));
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        contactDetail.clickDeleteBtn(true);
        LOGGER.info("Contact was deleted");
        mainPage = accountDetail.gotoMainPage();
        navigationBar = mainPage.gotoNavBar();
        accountsHome = navigationBar.goToAccountsHome();
        accountDetail = accountsHome.selectRecentItem(contact.getAccountName());
        accountDetail.clickDeleteBtn(true);
        LOGGER.info("Account was deleted");
    }
}
