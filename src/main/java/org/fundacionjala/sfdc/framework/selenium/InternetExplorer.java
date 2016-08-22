package org.fundacionjala.sfdc.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * This class initialize the Chrome Selenium Web Driver
 *
 * @author Henrry Salinas.
 */
public class InternetExplorer implements IDriver {

    private static final String WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";

    private static final String DRIVER_PATH = "drivers/IEDriverServer.exe";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        System.setProperty(WEBDRIVER_IE_DRIVER, DRIVER_PATH);
        return new InternetExplorerDriver();
    }
}
