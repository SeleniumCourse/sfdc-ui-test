package org.fundacionjala.sfdc.pages.forecasts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isWebElementVisible;

/**
 * This class will be used to represent Forecast page and its options.
 *
 * @author Marcelo
 */
public class ForecastsHome extends AbstractBasePage {
    @FindBy(xpath = "//h1[contains(.,'Introducing Forecasts')]")
    private WebElement forecastSection;

    public boolean isUserInForecastsTab() {
        return isWebElementVisible(forecastSection);
    }

}
