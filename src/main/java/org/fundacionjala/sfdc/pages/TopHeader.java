package org.fundacionjala.sfdc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.utils.Constants.TIMEOUT_MIN;
import static org.fundacionjala.sfdc.framework.utils.Constants.TIMEOUT_NORMAL;
import static org.fundacionjala.sfdc.framework.utils.Constants.WEB_ELEMENT_COULD_NOT_BE_FOUNT;

/**
 * This class will be used to get Salesforce cookies.
 *
 * @author Jimmy Vargas.
 * @author Bruno Barrios.
 */
public class TopHeader extends AbstractBasePage {

    private static final Logger LOGGER = Logger.getLogger(TopHeader.class.getName());

    @FindBy(id = "userNavLabel")
    private WebElement userMenu;

    @FindBy(xpath = "//a[contains(@href, '/secur/logout.jsp')]")
    private WebElement logoutMenuOption;

    /**
     * This method click user menu options.
     */
    public void clickUserNameMenu() {
        try {
            clickWebElement(userMenu);
        } catch (WebDriverException e) {
            LOGGER.error(WEB_ELEMENT_COULD_NOT_BE_FOUNT, e);
            throw new WebDriverException(e);
        }
    }

    /**
     * This method gets the user account name.
     *
     * @return the user account name.
     */
    public String getUserName() {
        String userLogged = "";
        try {
            driver.manage().timeouts().implicitlyWait(TIMEOUT_MIN, SECONDS);
            userLogged = this.userMenu.getText();
        } catch (WebDriverException e) {
            LOGGER.error(WEB_ELEMENT_COULD_NOT_BE_FOUNT, e);
        } finally {
            driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, SECONDS);
        }
        return userLogged;
    }

    /**
     * This method logs out a user from Sales force
     *
     * @return LoginPage
     */
    public LoginPage clickLogoutOption() {
        try {
            clickWebElement(logoutMenuOption);
            LOGGER.info("Logout from SalesForce");
        } catch (WebDriverException e) {
            LOGGER.error(WEB_ELEMENT_COULD_NOT_BE_FOUNT, e);
            throw new WebDriverException(e);
        }
        return new LoginPage();
    }

    /**
     * This method verifies whether a cookie is present.
     *
     * @return true if so and false if not.
     */
    public boolean checkIfCookieIsPresent() {
        String cookieName = "com.salesforce.LocaleInfo";
        String cookieDomain = ".salesforce.com";
        LOGGER.info("Verifying Cookies");
        wait.until(ExpectedConditions.visibilityOf(userMenu));
        return this.driver.manage().getCookieNamed(cookieName).getDomain().equals(cookieDomain);
    }
}
