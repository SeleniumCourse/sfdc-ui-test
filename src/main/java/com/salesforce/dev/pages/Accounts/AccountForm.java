package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.FormBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Walter on 10/06/2015.
 */
public class AccountForm extends FormBase{

    //Account Information

    @FindBy(id = "acc2")
    private WebElement accountNameFld;

    @FindBy(id = "acc3")
    private WebElement parentAccountFld;

    @FindBy(id = "acc5")
    private WebElement accountNumberFld;

    @FindBy(id = "acc23")
    private WebElement accountSiteFld;

    @FindBy(id = "acc6")
    private WebElement accountTypeFld;

    @FindBy(id = "acc7")
    private WebElement accountIndustryFld;

    @FindBy(id = "acc8")
    private WebElement accountAnnualRevenueFld;

    @FindBy(id = "acc9")
    private WebElement accountRatingFld;

    @FindBy(id = "acc10")
    private WebElement accountPhoneFld;

    @FindBy(id = "acc11")
    private WebElement accountFaxFld;

    @FindBy(id = "acc12")
    private WebElement accountWebsiteFld;

    @FindBy(id = "acc13")
    private WebElement accountThickerFld;

    @FindBy(id = "acc14")
    private WebElement accountOwnershipFld;

    @FindBy(id = "acc15")
    private WebElement accountEmployeesFld;

    @FindBy(id = "acc16")
    private WebElement accountSICCodeFld;

    //AddressAddress Information

    @FindBy(id = "acc17street")
    private WebElement accountBillingStreetFld;

    @FindBy(id = "acc17city")
    private WebElement accountBillingCityFld;

    @FindBy(id = "acc17state")
    private WebElement accountBillingStateFld;

    @FindBy(id = "acc17zip")
    private WebElement accountBillingZipFld;

    @FindBy(id = "acc17country")
    private WebElement accountBillingCountryFld;

    @FindBy(id = "acc18street")
    private WebElement accountShippingStreetFld;

    @FindBy(id = "acc18city")
    private WebElement accountShippingCityFld;

    @FindBy(id = "acc18state")
    private WebElement accountShippingStateFld;

    @FindBy(id = "acc18zip")
    private WebElement accountShippingZipFld;

    @FindBy(id = "acc18country")
    private WebElement accountShippingCountryFld;

    // Additional Information

    @FindBy(xpath = "//label[contains(.,'Customer Priority')]/following::select")
    private WebElement accountCustomerPriorityFld;

    @FindBy(xpath = "//label[contains(.,'SLA Expiration Date')]/following::input")
    private WebElement accountSLAExpirationDateFld;

    @FindBy(xpath = "//label[contains(.,'Number of Locations')]/following::input")
    private WebElement accountNumberLocationsFld;

    @FindBy(xpath = "//label[contains(.,'Active')]/following::select")
    private WebElement accountActiveFld;

    @FindBy(xpath = "//label[contains(.,'SLA')]/following::select")
    private WebElement accountSLAFld;

    @FindBy(xpath = "//label[contains(.,'SLA Serial Number')]/following::input")
    private WebElement accountSLASerialNumberFld;

    @FindBy(id = "00N50000006coqc")
    private WebElement accountUpsellOpportunityFld;

    //Description Information

    @FindBy(name = "acc20")
    private WebElement accountDescriptionFld;

    public AccountForm(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(super.driver, this);
    }

    @Override
    public Object clickSaveNewBtn() {
        return null;
    }

    @Override
    public Object clickCancelBtn() {
        return null;
    }

    @Override
    public AccountDetail clickSaveBtn() {
        clickSaveButton();
        return new AccountDetail(driver);
    }

    public AccountForm setAccountNameFld(String accountName) {
        fillTextBox(accountNameFld, accountName);
        return this;
    }

    public AccountForm setAccountNumberFld(String accountNumber) {
        fillTextBox(accountNumberFld, accountNumber);
        return this;
    }

    public AccountForm setAccountSiteFld(String accountSite) {
        fillTextBox(accountSiteFld, accountSite);
        return this;
    }

    public AccountForm setAccountTypeFld(String accountType) {
        selectItemComboBox(accountTypeFld, accountType);
        return this;
    }

    public AccountForm setAccountIndustryFld(String accountIndustry) {
        selectItemComboBox(accountIndustryFld, accountIndustry);
        return this;
    }

    public AccountForm setAccountAnnualRevenueFld(Integer accountAnnualRevenue) {
        fillTextBox(accountAnnualRevenueFld, accountAnnualRevenue.toString());
        return this;
    }

    public AccountForm setAccountRatingFld(String accountRating) {
        selectItemComboBox(accountRatingFld, accountRating);
        return this;
    }

    public AccountForm setAccountPhoneFld(String accountPhone) {
        fillTextBox(accountPhoneFld, accountPhone);
        return this;
    }

    public AccountForm setAccountFaxFld(String accountFax) {
        fillTextBox(accountFaxFld, accountFax);
        return this;
    }

    public AccountForm setAccountWebsiteFld(String accountWebsite) {
        fillTextBox(accountWebsiteFld, accountWebsite);
        return this;
    }

    public AccountForm setAccountThickerFld(String accountThicker) {
        fillTextBox(accountThickerFld, accountThicker);
        return this;
    }

    public AccountForm setAccountOwnershipFld(String accountOwnership) {
        selectItemComboBox(accountOwnershipFld, accountOwnership);
        return this;
    }

    public AccountForm setAccountEmployeesFld(Integer accountEmployees) {
        fillTextBox(accountEmployeesFld, accountEmployees.toString());
        return this;
    }

    public AccountForm setAccountSICCodeFld(String accountSICCode) {
        fillTextBox(accountSICCodeFld, accountSICCode);
        return this;
    }

    public AccountForm setAccountBillingStreetFld(String accountBillingStreet) {
        fillTextBox(accountBillingStreetFld, accountBillingStreet);
        return this;
    }

    public AccountForm setAccountBillingCityFld(String accountBillingCity) {
        fillTextBox(accountBillingCityFld, accountBillingCity);
        return this;
    }

    public AccountForm setAccountBillingStateFld(String accountBillingState) {
        fillTextBox(accountBillingStateFld, accountBillingState);
        return this;
    }

    public AccountForm setAccountBillingZipFld(String accountBillingZip) {
        fillTextBox(accountBillingZipFld, accountBillingZip);
        return this;
    }

    public AccountForm setAccountBillingCountryFld(String accountBillingCountry) {
        fillTextBox(accountBillingCountryFld, accountBillingCountry);
        return this;
    }

    public AccountForm setAccountShippingStreetFld(String accountShippingStreet) {
        fillTextBox(accountShippingStreetFld, accountShippingStreet);
        return this;
    }

    public AccountForm setAccountShippingCityFld(String accountShippingCity) {
        fillTextBox(accountShippingCityFld, accountShippingCity);
        return this;
    }

    public AccountForm setAccountShippingStateFld(String accountShippingState) {
        fillTextBox(accountShippingStateFld, accountShippingState);
        return this;
    }

    public AccountForm setAccountShippingZipFld(String accountShippingZip) {
        fillTextBox(accountShippingZipFld, accountShippingZip);
        return this;
    }

    public AccountForm setAccountShippingCountryFld(String accountShippingCountry) {
        fillTextBox(accountShippingCountryFld, accountShippingCountry);
        return this;
    }

    public AccountForm setAccountCustomerPriorityFld(String accountCustomerPriority) {
        selectItemComboBox(accountCustomerPriorityFld, accountCustomerPriority);
        return this;
    }

    public AccountForm setAccountSLAExpirationDateFld(String accountSLAExpirationDate) {
        fillTextBox(accountSLAExpirationDateFld, accountSLAExpirationDate);
        return this;
    }

    public AccountForm setAccountSLAExpirationDateFld(Integer month, Integer day, Integer year){
        accountSLAExpirationDateFld.click();
        selectDatePicker(month, day, year);
        return this;
    }

    public AccountForm setAccountNumberLocationsFld(Integer accountNumberLocations) {
        fillTextBox(accountNumberLocationsFld, accountNumberLocations.toString());
        return this;
    }

    public AccountForm setAccountActiveFld(String activeState) {
        selectItemComboBox(accountActiveFld, activeState);
        return this;
    }

    public AccountForm setAccountSLAFld(String accountSLA) {
        selectItemComboBox(accountSLAFld, accountSLA);
        return this;
    }

    public AccountForm setAccountSLASerialNumberFld(String accountSLASerialNumber) {
        fillTextBox(accountSLASerialNumberFld, accountSLASerialNumber);
        return this;
    }

    public AccountForm setAccountUpsellOpportunityFld(String accountUpsellOpportunity) {
        selectItemComboBox(accountUpsellOpportunityFld, accountUpsellOpportunity);
        return this;
    }

    public AccountForm setAccountDescriptionFld(String accountDescription) {
        fillTextBox(accountDescriptionFld, accountDescription);
        return this;
    }

}
