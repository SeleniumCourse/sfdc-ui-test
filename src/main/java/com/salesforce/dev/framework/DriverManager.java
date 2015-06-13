package com.salesforce.dev.framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jimmy Vargas on 6/4/2015.
 */
public class DriverManager {
    private WebDriver driver;
    private WebDriverWait wait;

    private static DriverManager instance = null;
    String browser = "Firefox";

    private DriverManager(){
        browser = Environment.getInstance().getBrowser();
        this.initializer();

    }

    private void initializer(){
        if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if(browser.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);

        driver.get("https://www.salesforce.com");

        driver.manage().window().maximize();

    }

    public static DriverManager getInstance(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriverWait getWait(){
        return this.wait;

    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void quit(){
        /*driver.close();
        driver.quit();*/
    }
}
