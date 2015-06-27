package com.salesforce.dev.pages.SearchLookup;

import com.salesforce.dev.pages.Accounts.AccountForm;
import com.salesforce.dev.pages.Campaigns.CampaignForm;
import com.salesforce.dev.pages.Contacts.ContactForm;
import com.salesforce.dev.pages.Leads.LeadForm;
import com.salesforce.dev.pages.Opportunities.OpportunityForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Marcelo.Vargas on 17-06-15.
 */
public class SearchLookupBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "lksrch")
    @CacheLookup
    WebElement searchTxt;

    @FindBy(name = "go")
    @CacheLookup
    WebElement goBtn;

   public SearchLookupBase(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public void searchText(String text) {

        Set<String> windows = driver.getWindowHandles();

        LinkedList<String> windowsArray = new LinkedList(windows);
        try {
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("searchFrame")));

            searchTxt.sendKeys(text);

            goBtn.click();
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("resultsFrame")));

            driver.findElement(By.linkText(text)).click();
            driver.switchTo().window(windowsArray.getFirst());
        }
        catch (WebDriverException e){
            throw new WebDriverException(e);
        }
    }

    public ContactForm goToContactForm() {
        return new ContactForm(driver);
    }
    public CampaignForm goToCampaignForm() {
        return new CampaignForm(driver);
    }
    public LeadForm goToLeadForm() {
        return new LeadForm(driver);
    }
    public AccountForm goToAccountForm() {
        return new AccountForm(driver);
    }
    public OpportunityForm goToOpportunityForm() {
        return new OpportunityForm(driver);
    }
}