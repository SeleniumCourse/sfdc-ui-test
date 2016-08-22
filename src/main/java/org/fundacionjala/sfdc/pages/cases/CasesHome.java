package org.fundacionjala.sfdc.pages.cases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Cases page and its options.
 *
 * @author Monica Pardo.
 */
public class CasesHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Cases:')]")
    private WebElement casesSection;

    public boolean isUserInCasesTab() {
        return isWebElementVisible(casesSection);
    }
}
