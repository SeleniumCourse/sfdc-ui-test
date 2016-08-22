package org.fundacionjala.sfdc.pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Lead home and its options.
 *
 * @author Jimmy Vargas
 */
public class LeadsHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Leads:')]")
    @CacheLookup
    private WebElement leadSection;

    @Override
    public LeadForm clickNewBtn() {
        super.clickNewButton();
        return new LeadForm();
    }

    @Override
    public LeadView clickNewViewLnk() {
        clickNewViewLink();
        return new LeadView();
    }

    @Override
    public LeadView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new LeadView();
    }

    @Override
    public Object selectRecentItem(String item) {
        super.clickRecentItem(item);
        return new LeadsHome();

    }

    @Override
    public AbstractBasePage selectRecentViewItem(String value) {
        return null;
    }

    public LeadDetail openLead(String lead) {
        WebElement linkLead = driver.findElement(By.linkText(lead));
        wait.until(ExpectedConditions.elementToBeClickable(linkLead));

        linkLead.click();
        return new LeadDetail();
    }

    public boolean isUserInLeadsTab() {
        return isWebElementVisible(leadSection);
    }

}
