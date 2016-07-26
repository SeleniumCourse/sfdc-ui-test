package com.salesforce.dev.pages.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.AbstractBasePage;
import com.salesforce.dev.pages.MainPage;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;
import static com.salesforce.dev.framework.CommonOperation.setWebElement;
import static com.salesforce.dev.framework.utils.Constants.ENVIRONMENT;

/**
 * Created by Monica Pardo on 6/4/2015.
 */
public class LoginPage extends AbstractBasePage {

    private MainPage mainPage=null;
    @FindBy(id = "username")
    WebElement userNameFld;

    @FindBy(id = "password")
    WebElement passwordFld;

    @FindBy(id = "Login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public MainPage clickLoginBtn() {
        clickWebElement(loginBtn);
        return new MainPage(this.driver);
    }

    /**
     * Returns the Main Page which contains the TopHeader and Navigation Bar
     * And the Main Page is the one who initializes those objects
     *
     * @author: Jimmy Vargas
     */
    public MainPage loginAs(String userName, String password) {
        if(mainPage==null){
            this.setUserName(userName);
            this.setPassword(password);
            return this.clickLoginBtn();
        }
        return mainPage;
    }

    public MainPage loginAsPrimaryUser() {
        return this.loginAs(ENVIRONMENT.getPrimaryUser(),Environment.getInstance().getPrimaryPassword());
    }

    public boolean isLoginButtonPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginBtn));
            return loginBtn.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    public void setUserName(String Name) {
        setWebElement(userNameFld, Name);
    }

    public void setPassword(String Password) {
        setWebElement(passwordFld, Password);
    }


}