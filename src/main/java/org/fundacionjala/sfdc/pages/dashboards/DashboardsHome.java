package org.fundacionjala.sfdc.pages.dashboards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Dashboard web page and its options.
 *
 * @author Monica Pardo
 */
public class DashboardsHome extends AbstractBasePage {

    @FindBy(id = "ext-gen3")
    private WebElement dashboardSection;

    public boolean isUserInDashboardsTab(){
       return isWebElementVisible(dashboardSection);
    }

}

