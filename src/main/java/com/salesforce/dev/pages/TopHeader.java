package com.salesforce.dev.pages;

import com.salesforce.dev.pages.Home.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.utils.Constants.WEB_ELEMENT_COULD_NOT_BE_FOUNT;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class TopHeader extends AbstractBasePage {

    private static final Logger LOGGER = Logger.getLogger(TopHeader.class.getName());

    @FindBy(id = "userNavLabel")
    private WebElement userMenu;

    @FindBy(id = "phHeaderLogoImage")
    private WebElement salesforceLogo;

    @FindBy(css = "a.menuButtonMenuLink.firstMenuItem")
    private WebElement userMyProfileMenu;

    @FindBy(xpath = "//a[contains(@href, '/secur/logout.jsp')]")
    private WebElement logoutMenuOption;



    public void clickUserNameMenu() {
        try {
            clickWebElement(userMenu);
        } catch (WebDriverException e) {
            e = new WebDriverException(e);
            LOGGER.error(WEB_ELEMENT_COULD_NOT_BE_FOUNT, e);
        }
    }

    public String getUserName() {
        String userLogged = "";
        try {
            driver.manage().timeouts().implicitlyWait(8, SECONDS);
            userLogged = this.userMenu.getText();
        } catch (WebDriverException e) {
            e = new WebDriverException(e);
            LOGGER.error(WEB_ELEMENT_COULD_NOT_BE_FOUNT, e);
        }finally {
            driver.manage().timeouts().implicitlyWait(15, SECONDS);
        }
        return userLogged;
    }

    public LoginPage clickLogoutOption() {
        try {
            clickWebElement(logoutMenuOption);
        } catch (WebDriverException e) {
            e = new WebDriverException(e);
            LOGGER.error(WEB_ELEMENT_COULD_NOT_BE_FOUNT, e);
        }
        return new LoginPage();
    }

    public boolean checkIfCookieIsPresent() {
        wait.until(ExpectedConditions.visibilityOf(userMenu));
        return this.driver.manage().getCookieNamed("com.salesforce.LocaleInfo").getDomain().equals(".salesforce.com");
    }
}
