package org.fundacionjala.sfdc.framework.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.framework.utils.Constants;
import org.fundacionjala.sfdc.framework.utils.Environment;

/**
 * @author Jimmy Vargas
 * @author Henrry Salinas
 */
public class DriverManager {

    private static final String LOG4J_PROPERTIES_FILE = "src/main/resources/log4j.properties";

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    private DriverManager() {
        PropertyConfigurator.configure(LOG4J_PROPERTIES_FILE);
        this.initializer();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }

    private void initializer() {
        driver = FactoryDriver.getDriver(Environment.getInstance().getBrowser()).initDriver();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_NORMAL, TimeUnit.SECONDS);
        driver.get(Constants.SALESFORCE_URL);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Constants.TIMEOUT_NORMAL);
    }
}
