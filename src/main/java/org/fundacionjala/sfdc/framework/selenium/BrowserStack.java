package org.fundacionjala.sfdc.framework.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.sfdc.framework.utils.Environment;

import static org.fundacionjala.sfdc.framework.utils.Constants.HTTP_PROXY_HOST;
import static org.fundacionjala.sfdc.framework.utils.Constants.HTTP_PROXY_PORT;

/**
 * This class initialize the Remote Selenium Web Driver given the required values in properties file
 *
 * @author Henrry Salinas.
 */
public class BrowserStack implements IDriver {

    private static final Logger LOGGER = Logger.getLogger(BrowserStack.class.getSimpleName());

    private static final Environment ENVIRONMENT = Environment.getInstance();

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        System.getProperties().put(HTTP_PROXY_HOST, ENVIRONMENT.getProxyHost());
        System.getProperties().put(HTTP_PROXY_PORT, ENVIRONMENT.getProxyPort());
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, ENVIRONMENT.getRemoteBrowser());
        caps.setCapability(CapabilityType.VERSION, ENVIRONMENT.getRemoteBrowserVersion());
        caps.setCapability(CapabilityType.PLATFORM, ENVIRONMENT.getRemotePlatform());
        final String sauceUrl = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub",
                ENVIRONMENT.getRemoteUserName(), ENVIRONMENT.getRemoteKey());
        URL url = null;
        try {
            url = new URL(sauceUrl);
        } catch (MalformedURLException e) {
            LOGGER.warn("The url is not correct", e);
        }
        return new RemoteWebDriver(url, caps);
    }
}
