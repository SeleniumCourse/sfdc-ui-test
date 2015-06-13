package com.salesforce.dev.pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/11/2015.
 */
public abstract class TabPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "fcf")
    protected WebElement viewCombobox;

    @FindBy(name = "new")
    protected WebElement newBtn;

    /**
     * Method clicks the New button in the home page for each different category
     *
     * @author: Jimmy
     */
    abstract protected Object clickNewBtn();

    /**
     * Method that encapsulates the the operations waiting for the elemeent and the action
     *
     * @author: Jimmy
     */
    protected void clickNewButton() {
        this.wait.until(ExpectedConditions.visibilityOf(newBtn));
        newBtn.click();

    }
}