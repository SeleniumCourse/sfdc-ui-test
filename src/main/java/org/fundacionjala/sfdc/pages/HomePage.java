package org.fundacionjala.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isElementPresent;
import static org.fundacionjala.sfdc.framework.utils.Constants.SALESFORCE_URL;

/**
 * This class represents HomePage of Salesforce web application.
 *
 * @author Monica Pardo.
 * @author Bruno Barrios.
 */
public class HomePage extends AbstractBasePage {

    @FindBy(id = "button-login")
    private WebElement loginBtn;

    @FindBy(id = "nav-open-btn")
    private WebElement homePageOptions;

    @FindBy(xpath = "//span[contains(.,'Login')]")
    private WebElement loginOption;

    /**
     * This method clicks on login btn from homepage.
     * @return LoginPage.
     */
    public LoginPage clickLoginBtn() {
        if (!isElementPresent(loginBtn)) {
            driver.navigate().to(SALESFORCE_URL);
            clickWebElement(homePageOptions);
            clickWebElement(loginOption);
        } else {
            clickWebElement(loginBtn);
        }
        return new LoginPage();
    }
}
