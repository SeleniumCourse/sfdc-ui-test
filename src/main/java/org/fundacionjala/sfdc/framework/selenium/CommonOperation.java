package org.fundacionjala.sfdc.framework.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.framework.utils.Constants;
import org.fundacionjala.sfdc.pages.base.DetailsBase;

/**
 * This class will be used to perform some common operation through pages.
 *
 * @author dante
 */
public final class CommonOperation {

    private static final Logger LOGGER = Logger.getLogger(DetailsBase.class.getName());

    private static final WebDriver DRIVER = DriverManager.getInstance().getDriver();

    private static final WebDriverWait WAIT = DriverManager.getInstance().getWait();

    private CommonOperation() {
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            LOGGER.info("Element not found", e);
            return false;
        }
    }

    /**
     * this method sets a webelement textbox.
     *
     * @param webElement
     * @param text
     */
    public static void setWebElement(WebElement webElement, String text) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    /**
     * This method click on a web element.
     *
     * @param webElement
     */
    public static void clickWebElement(WebElement webElement) {
        WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void setComboBox(WebElement element, String value) {
        WAIT.until(ExpectedConditions.visibilityOf(element));
        Select comboBox = new Select(element);
        comboBox.selectByValue(value);
    }

    public static void setCheckBox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public static void setComboBoxByItem(WebElement webElement, String value) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        Select comboBox = new Select(webElement);
        comboBox.selectByVisibleText(value);
    }

    /**
     * this method verifies whether a webelement is visible.
     *
     * @param webElement
     * @return true if so and false if not
     */
    public static boolean isWebElementVisible(WebElement webElement) {
        try {

            WAIT.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (WebDriverException e) {
            LOGGER.info("Web element not visible", e);
            return false;
        }
    }

    /**
     * This mehod wait for a web element
     *
     * @param webElement
     */
    public static void waitForWebElement(WebElement webElement) {
        try {
            WAIT.withTimeout(Constants.TIMEOUT_NORMAL, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            WAIT.withTimeout(Constants.TIMEOUT_NORMAL, TimeUnit.SECONDS);
        }
    }

    /**
     * This method gets the text of a web element.
     *
     * @param webElement
     * @return the text of a web element.
     */
    public static String getTextWebElement(WebElement webElement) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * This method moves the scroll of the web browser.
     *
     * @param driver
     * @param webElement
     * @param horizontal
     */
    public static void moveHorizontalWebElementScroll(WebDriver driver, WebElement webElement, int horizontal) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft+=arguments[1];", webElement, horizontal);
    }

    /**
     * this method get the first option of a combo box
     *
     * @param webElement
     * @return
     */
    public static String getFirstSelectOption(WebElement webElement) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * This method confirms an alert option.
     */
    public static void clickConfirmAlert() {
        Alert alert;
        try {
            alert = DRIVER.switchTo().alert();
            alert.accept();
            LOGGER.info("Delete Button was clicked");
        } catch (WebDriverException e) {
            LOGGER.fatal("The Delete button couldn't be found", e);
        }
    }
}
