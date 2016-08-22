package org.fundacionjala.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.soap.UserInformation;
import org.fundacionjala.sfdc.framework.utils.Environment;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.setWebElement;

/**
 * This class represents the login page of salesforce.
 *
 * @author Monica Pardo.
 * @author Bruno Barrios.
 */
public class LoginPage extends AbstractBasePage {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    @FindBy(id = "username")
    private WebElement userNameFld;

    @FindBy(id = "password")
    private WebElement passwordFld;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    /**
     * Returns the Main Page which contains the TopHeader and Navigation Bar
     * And the Main Page is the one who initializes those objects
     */
    private static MainPage loginAs(String userName, String password) {
        MainPage mainPage = new MainPage();
        if (!mainPage.gotoTopHeader().getUserName().equalsIgnoreCase(UserInformation.getUserFullName())) {
            HomePage homePage = new HomePage();
            LoginPage loginPage = homePage.clickLoginBtn();
            loginPage.setUserName(userName);
            loginPage.setPassword(password);
            return loginPage.clickLoginBtn();
        }
        return mainPage;
    }

    /**
     * This method is used to login into Salesforce.
     *
     * @return the username that is already logged in.
     */
    public static MainPage loginAsPrimaryUser() {
        return loginAs(ENVIRONMENT.getPrimaryUser(), ENVIRONMENT.getPrimaryPassword());
    }

    /**
     * This method click the login btn.
     *
     * @return MainPage
     */
    public MainPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new MainPage();
    }

    public boolean isLoginButtonPresent() {
        isWebElementVisible(loginBtn);
        return loginBtn.isDisplayed();
    }

    private void setUserName(String name) {
        setWebElement(userNameFld, name);
    }

    private void setPassword(String password) {
        setWebElement(passwordFld, password);
    }

}
