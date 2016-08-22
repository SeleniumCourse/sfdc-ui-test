package org.fundacionjala.sfdc.pages.base;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.MainPage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickConfirmAlert;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;

/**
 * This class will contain the common objects for the Details pages.
 *
 * @author Jimmy Vargas
 * @author Walter
 * @author Mijhail
 */
public abstract class DetailsBase extends AbstractBasePage {

    @FindBy(name = "edit")
    private WebElement editBtn;

    @FindBy(name = "del")
    private WebElement deleteBtn;

    @FindBy(css = "input[title='Delete']")
    private WebElement deleteAccBtn;

    @FindBy(name = "clone")
    private WebElement cloneBtn;

    public MainPage gotoMainPage() {
        return new MainPage();
    }

    /**
     * Clicks the Edit button
     */
    protected void clickEditButton() {
        clickWebElement(editBtn);
    }

    /**
     * Clicks delete button
     */
    protected void clickDeletedButton() {
        clickWebElement(deleteAccBtn);
        clickConfirmAlert();
    }

    /**
     * Return Home page when do click delete button
     */
    public abstract AbstractBasePage clickDeleteButton();

    /**
     * Returns the corresponding form
     */
    protected abstract AbstractBasePage clickEditBtn();

    /**
     * Return Map the assertions
     */
    public abstract Map<Enum, Object> getAssertionMap();
}
