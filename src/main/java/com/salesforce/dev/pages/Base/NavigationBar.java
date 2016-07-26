package com.salesforce.dev.pages.Base;
import com.salesforce.dev.pages.Accounts.AccountsHome;
import com.salesforce.dev.pages.Campaigns.CampaignsHome;
import com.salesforce.dev.pages.Cases.CasesHome;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Contacts.ContactsHome;
import com.salesforce.dev.pages.Contracts.ContractsHome;
import com.salesforce.dev.pages.Dashboards.DashboardsHome;
import com.salesforce.dev.pages.Forecasts.ForecastsHome;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.Opportunities.OpportunitiesHome;
import com.salesforce.dev.pages.Orders.OrdersHome;
import com.salesforce.dev.pages.Product.ProductsHome;
import com.salesforce.dev.pages.Reports.ReportsHome;
import com.salesforce.dev.pages.Solutions.SolutionsHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.dev.framework.DriverManager;

/**
 * Created by Monica Pardo on 6/5/2015.
 */
public class NavigationBar {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText ="Campaigns")
    WebElement campaignsTab;

    @FindBy(linkText ="Leads")
    WebElement leadsTab;

    @FindBy(linkText = "Accounts")
    WebElement accountsTab;

    @FindBy(linkText = "Contacts")
    WebElement contactsTab;

    @FindBy(linkText = "Opportunities")
    WebElement opportunitiesTab;

    @FindBy(linkText = "Products")
    WebElement productsTab;

    @FindBy(linkText = "Chatter")
    WebElement chatterTab;

    @FindBy(linkText ="Forecasts")
    WebElement forecastsTab;

    @FindBy(linkText ="Contracts")
    WebElement contractsTab;

    @FindBy(linkText ="Orders")
    WebElement ordersTab;

    @FindBy(linkText ="Cases")
    WebElement casesTab;

    @FindBy(linkText ="Solutions")
    WebElement solutionsTab;

    @FindBy(linkText ="Reports")
    WebElement reportsTab;

    @FindBy(linkText ="Dashboards")
    WebElement dashboardTab;

    public NavigationBar(WebDriver driver){
        this.driver=driver;
        this.wait= DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);

    }

    public CampaignsHome goToCampaignsHome(){
        wait.until(ExpectedConditions.visibilityOf(campaignsTab));
        campaignsTab.click();
        return new CampaignsHome(driver);
    }

    public LeadsHome gotToLeadsHome(){
        wait.until(ExpectedConditions.visibilityOf(leadsTab));
        leadsTab.click();
        return new LeadsHome(driver);
    }

    public AccountsHome goToAccountsHome(){
        wait.until(ExpectedConditions.visibilityOf(accountsTab));
        accountsTab.click();
        return new AccountsHome(driver);
    }

    public ContactsHome goToContactsHome(){
        wait.until(ExpectedConditions.elementToBeClickable(contactsTab));
        contactsTab.click();
        return new ContactsHome(this.driver);
    }

    /**
     * This method returns an instance from OpportunitiesTab
     *
     * @author: Jimmy Vargas
     * @version: 1.0
     * @since: 6/10/2015
     * */
    public OpportunitiesHome goToOpportunitiesHome(){
        wait.until(ExpectedConditions.elementToBeClickable(opportunitiesTab));
        opportunitiesTab.click();

        return new OpportunitiesHome(this.driver);
    }

    public ProductsHome goToProductsHome(){
        wait.until(ExpectedConditions.visibilityOf(productsTab));
        productsTab.click();
        return new ProductsHome(driver);
    }

    public boolean IsElementPresent(WebElement webElement){
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    
    public ChatterHome goToChatterHome(){
        wait.until(ExpectedConditions.visibilityOf(chatterTab));
        chatterTab.click();
        return new ChatterHome(driver);
    }


    public ForecastsHome goToForescastsHome(){
        wait.until(ExpectedConditions.elementToBeClickable(forecastsTab));
        forecastsTab.click();
        return new ForecastsHome(this.driver);
    }

    public ContractsHome goToContractsHome(){
        wait.until(ExpectedConditions.elementToBeClickable(contractsTab));
        contractsTab.click();
        return new ContractsHome(this.driver);
    }

    public OrdersHome goToOrdersHome(){
        wait.until(ExpectedConditions.elementToBeClickable(ordersTab));
        ordersTab.click();
        return new OrdersHome(this.driver);
    }

    public CasesHome goToCasesHome(){
        wait.until(ExpectedConditions.elementToBeClickable(casesTab));
        casesTab.click();
        return new CasesHome(this.driver);
    }

    public SolutionsHome goToSolutionsHome(){
        wait.until(ExpectedConditions.elementToBeClickable(solutionsTab));
        solutionsTab.click();
        return new SolutionsHome(this.driver);
    }

    public ReportsHome goToReportsHome(){
        wait.until(ExpectedConditions.elementToBeClickable(reportsTab));
        reportsTab.click();
        return new ReportsHome(this.driver);
    }

    public DashboardsHome goToDashboardsHome(){
        wait.until(ExpectedConditions.elementToBeClickable(dashboardTab));
        dashboardTab.click();
        return new DashboardsHome(this.driver);
    }

}
