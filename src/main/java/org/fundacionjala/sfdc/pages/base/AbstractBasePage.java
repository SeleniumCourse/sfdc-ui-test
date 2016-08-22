package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.framework.selenium.DriverManager;

/**
 * This class will be used as Base page of all base pages.
 *
 * @author Dante Villarroel
 */
public abstract class AbstractBasePage {

    protected WebDriverWait wait;

    protected WebDriver driver;

    protected Actions action;

    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
