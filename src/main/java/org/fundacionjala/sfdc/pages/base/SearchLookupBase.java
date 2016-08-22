package org.fundacionjala.sfdc.pages.base;

import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;

/**
 * This class will be used to represent searchlookup
 *
 * @author Marcelo.Vargas
 */
public class SearchLookupBase extends AbstractBasePage {

    private static final Logger LOGGER = Logger.getLogger(SearchLookupBase.class.getName());

    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement searchTxt;

    @FindBy(name = "go")
    @CacheLookup
    private WebElement goBtn;

    public void searchText(String text) {

        LinkedList<String> windowsArray = new LinkedList(driver.getWindowHandles());
        try {
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("searchFrame")));
            searchTxt.clear();
            searchTxt.sendKeys(text);

            goBtn.click();
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("resultsFrame")));

            driver.findElement(By.linkText(text)).click();
            driver.switchTo().window(windowsArray.getFirst());

            LOGGER.info("Object was serach and selected in SearchLookup");
        } catch (WebDriverException e) {
            LOGGER.fatal("The Frames couldn't be found", e);
        }
    }

    public ContactForm goToContactForm() {
        return new ContactForm();
    }

    public CampaignForm goToCampaignForm() {
        return new CampaignForm();
    }
}
