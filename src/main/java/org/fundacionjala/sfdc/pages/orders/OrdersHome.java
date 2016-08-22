package org.fundacionjala.sfdc.pages.orders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonOperation;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * This class will be used to represent Order page and its options.
 *
 * @author marcelo
 */
public class OrdersHome extends AbstractBasePage {

    @FindBy(xpath = "//h1[contains(.,'Orders:')]")
    private WebElement ordersSection;

    public boolean isUserInOrdersTab() {
        return CommonOperation.isWebElementVisible(ordersSection);
    }

}
