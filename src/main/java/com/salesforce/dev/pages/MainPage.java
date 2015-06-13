package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Leads.LeadsHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Jimmy Vargas on 6/4/2015.
 */
public class MainPage {

    NavigationBar navBar;
    TopHeader topHeader;

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        topHeader = new TopHeader(this.driver);
        navBar = new NavigationBar(this.driver);

        PageFactory.initElements(this.driver, this);
    }
    public TopHeader gotoTopHeader(){
        return this.topHeader;
    }

    /**
     * Returns the navigation bar where all the HOMEs are located
     *
     * @author: Jimmy Vargas
     * */
    public NavigationBar gotoNavBar(){
        return this.navBar;
    }


}
