package com.salesforce.dev.pages.Base;

import com.salesforce.dev.pages.AbstractBasePage;
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
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.salesforce.dev.framework.CommonOperation.clickWebElement;

/**
 * Created by Monica Pardo on 6/5/2015.
 */
public class NavigationBar extends AbstractBasePage {

    @FindBy(linkText = "Orders")
    private WebElement ordersTab;

    @FindBy(id ="Campaign_Tab")
    WebElement campaignsTab;

    @FindBy(linkText = "Leads")
    private WebElement leadsTab;

    @FindBy(linkText = "Accounts")
    private WebElement accountsTab;

    @FindBy(linkText = "Contacts")
    private WebElement contactsTab;

    @FindBy(id = "Opportunity_Tab")
    WebElement opportunitiesTab;

    @FindBy(linkText = "Products")
    private WebElement productsTab;

    @FindBy(linkText = "Chatter")
    private WebElement chatterTab;

    @FindBy(linkText = "Forecasts")
    private WebElement forecastsTab;

    @FindBy(linkText = "Contracts")
    private WebElement contractsTab;

    @FindBy(linkText = "Cases")
    private WebElement casesTab;

    @FindBy(linkText = "Solutions")
    private WebElement solutionsTab;

    @FindBy(linkText = "Reports")
    private WebElement reportsTab;

    @FindBy(linkText = "Dashboards")
    private WebElement dashboardTab;

    public CampaignsHome goToCampaignsHome() {
        clickWebElement(campaignsTab);
        return new CampaignsHome();
    }

    public LeadsHome gotToLeadsHome() {
        clickWebElement(leadsTab);
        return new LeadsHome();
    }

    public AccountsHome goToAccountsHome() {
        clickWebElement(accountsTab);
        return new AccountsHome();
    }

    public ContactsHome goToContactsHome() {
        clickWebElement(contactsTab);
        return new ContactsHome();
    }

    /**
     * This method returns an instance from OpportunitiesTab
     *
     * @author: Jimmy Vargas
     * @version: 1.0
     * @since: 6/10/2015
     */
    public OpportunitiesHome goToOpportunitiesHome() {
        clickWebElement(opportunitiesTab);
        return new OpportunitiesHome();
    }

    public ProductsHome goToProductsHome() {
        clickWebElement(productsTab);
        return new ProductsHome();
    }

    public boolean IsElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    public ChatterHome goToChatterHome() {
        clickWebElement(chatterTab);
        return new ChatterHome(driver);
    }


    public ForecastsHome goToForescastsHome() {
        clickWebElement(forecastsTab);
        return new ForecastsHome(this.driver);
    }

    public ContractsHome goToContractsHome() {
        clickWebElement(contractsTab);
        return new ContractsHome(this.driver);
    }

    public OrdersHome goToOrdersHome() {
        clickWebElement(ordersTab);
        return new OrdersHome(this.driver);
    }

    public CasesHome goToCasesHome() {
        clickWebElement(casesTab);
        return new CasesHome(this.driver);
    }

    public SolutionsHome goToSolutionsHome() {
        clickWebElement(solutionsTab);
        return new SolutionsHome(this.driver);
    }

    public ReportsHome goToReportsHome() {
        clickWebElement(reportsTab);
        return new ReportsHome(this.driver);
    }

    public DashboardsHome goToDashboardsHome() {
        clickWebElement(dashboardTab);
        return new DashboardsHome(this.driver);
    }
}
