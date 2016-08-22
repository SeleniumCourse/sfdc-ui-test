package org.fundacionjala.sfdc.pages.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.HomeBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isElementPresent;

/**
 * This class will be used to represent Opportunities home page.
 *
 * @author Jimmy Vargas
 */
public class OpportunitiesHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Opportunities:')]")
    @CacheLookup
    private WebElement opportunitiesSection;

    @Override
    public OpportunityForm clickNewBtn() {
        clickWebElement(newBtn);
        return new OpportunityForm();
    }

    @Override
    public OpportunityView clickNewViewLnk() {
        clickNewViewLink();
        return new OpportunityView();
    }

    @Override
    public OpportunityView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new OpportunityView();
    }

    @Override
    public OpportunityDetail selectRecentItem(String opportunity) {
        super.clickRecentItem(opportunity);
        return new OpportunityDetail();
    }

    @Override
    protected OpportunitiesHome selectRecentViewItem(String value) {
        selectRecentView(value);
        return this;
    }

    public OpportunityDetail openOpportunity(String opportunity) {
        WebElement linkOpportunity = driver.findElement(By.linkText(opportunity));
        clickWebElement(linkOpportunity);
        return new OpportunityDetail();
    }

    public boolean isUserInOpportunitiesTab() {
        return isElementPresent(opportunitiesSection);
    }
}
