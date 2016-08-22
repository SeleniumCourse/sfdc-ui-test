package org.fundacionjala.sfdc.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Contract page and its options.
 *
 * @author marcelo
 */
public class ContractsHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Contracts:')]")
    private WebElement contractsSection;

    public boolean isUserInContractsTab() {
        return isWebElementVisible(contractsSection);
    }

}
