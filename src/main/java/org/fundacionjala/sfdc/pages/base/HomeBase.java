package org.fundacionjala.sfdc.pages.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.setWebElement;

/**
 * This class will be used to represent the HOme page of SalesForce.
 *
 * @author Jimmy Vargas
 * @author veronica
 */
public abstract class HomeBase extends AbstractBasePage {

    private static final Logger LOGGER = Logger.getLogger(HomeBase.class.getName());

    @FindBy(name = "new")
    protected WebElement newBtn;

    @FindBy(name = "go")
    protected WebElement goBtn;

    @FindBy(id = "fcf")
    private WebElement viewCombobox;

    @FindBy(linkText = "Create New View")
    private WebElement newViewLnk;

    @FindBy(linkText = "Edit")
    private WebElement editViewLnk;


    /**
     * Method clicks the New button in the home page for each different category
     */
    protected abstract FormBase clickNewBtn();

    /**
     * Method clicks the New Link in the home page for each different category
     */
    protected abstract AbstractBasePage clickNewViewLnk();

    /**
     * Method clicks the NEdit view in the home page for each different category
     */
    protected abstract AbstractBasePage clickEditViewLnk(String value);

    /**
     * Method that encapsulates the the operations waiting for the element and the action
     */
    protected void clickNewButton() {
        try {
            clickWebElement(newBtn);
            LOGGER.info("New button was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The New button couldn't be found", e);
        }
    }

    /**
     * Method that encapsulates the the operations waiting for the element and the action
     */
    protected void clickNewViewLink() {
        try {
            clickWebElement(newViewLnk);
            LOGGER.info("New View Link was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The New View Link couldn't be found", e);
        }
    }

    protected abstract Object selectRecentItem(String value);

    protected void clickRecentItem(String value) {
        try {
            WebElement recentItem = driver.findElement(
                    By.xpath("//div[@class='hotListElement']/descendant::a[contains(.,'" + value + "')]"));
            recentItem.click();
            LOGGER.info("Recent Item was selected");
        } catch (WebDriverException e) {
            LOGGER.info("The Recent Item button couldn't be found", e);
        }
    }

    protected abstract AbstractBasePage selectRecentViewItem(String value);

    protected void selectRecentView(String value) {
        setWebElement(viewCombobox, value);
    }

    protected void editViewLnk(String value) {
        selectRecentView(value);
        editViewLnk.click();
    }
}
