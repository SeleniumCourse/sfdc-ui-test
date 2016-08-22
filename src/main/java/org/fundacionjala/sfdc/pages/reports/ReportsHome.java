package org.fundacionjala.sfdc.pages.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Reports page and its options.
 *
 * @author Monica Pardo
 */
public class ReportsHome extends AbstractBasePage {

    @FindBy(id = "ext-gen3")
    private WebElement reportSection;

    public boolean isUserInReportsTab() {
        return isWebElementVisible(reportSection);
    }

}
