package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class LeadsHome {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//a[contains(text(),'Create New View')]")
    WebElement createNewViewLink;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    WebElement deleteViewLink;

    @FindBy(xpath  =  "//select[contains(@id,'_listSelect')]")
    WebElement leadCombobox;

    public LeadsHome(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver, this);

    }

}
