package org.fundacionjala.sfdc.framework.testng;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import org.fundacionjala.sfdc.framework.selenium.DriverManager;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.TopHeader;


/**
 * @author Marcelo.Vargas on 6/22/2015.
 */
public class TestListener implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(TestListener.class.getName());
    LoginPage loginPage;
    private WebDriver driver;
    private String filePath = "build\\reports\\tests\\html\\screenshots";

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("On Execution Test Star");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("On Test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("***** Error " + result.getName() + " test has failed *****");
        LOGGER.error("On Execution Test failure", null);
        String methodName = result.getName().toString().trim();
        takeScreenShot(methodName);
    }

    public void takeScreenShot(String methodName) {
        driver = DriverManager.getInstance().getDriver();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File myFile = new File(filePath + "/" + methodName + ".png");
            FileUtils.copyFile(scrFile, myFile);
            LOGGER.info("***Placed screen shot in " + filePath + " ***");
            reportLogScreenshot(myFile);
        } catch (IOException e) {
            LOGGER.warn("The properties file couldn't be found", e);
        }
    }

    protected void reportLogScreenshot(File file) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Reporter.log("<p align=\"left\">Error screenshot at " + new Date() + "</p>");
        Reporter.log("<p>&nbsp;</p>");
        Reporter.log("<a href='logs/log4j-application.log'>Open Logs</a>");
        Reporter.log("<p>&nbsp;</p>");
        Reporter.log("<p><img width=\"1024\" src=\"" + file.getAbsoluteFile() + "\" alt=\"screenshot at " + new Date() + "\"/></p><br />");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onStart(ITestContext context) {
        LOGGER.error("Test suite Start", null);
        LoginPage.loginAsPrimaryUser();
    }

    @Override
    public void onFinish(ITestContext context) {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        TopHeader topHeader = mainPage.gotoTopHeader();
        topHeader.clickUserNameMenu();
        loginPage = topHeader.clickLogoutOption();
        DriverManager.getInstance().close();
        DriverManager.getInstance().quit();
        LOGGER.info("On Finish");
    }
}
