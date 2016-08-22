package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;

/**
 * This class will be used to represent base form.
 *
 * @author Walter
 */
public abstract class FormBase extends AbstractBasePage {

    private static final String VALUE_CANNOT_BE_NULL = "The value cannot be null.";

    @FindBy(name = "save")
    protected WebElement saveBtn;

    @FindBy(name = "save_new")
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    private WebElement cancelBtn;

    //Calendar
    @FindBy(id = "calMonthPicker")
    private WebElement monthPicker;

    @FindBy(id = "calYearPicker")
    private WebElement yearPicker;

    /**
     * Method clicks the New button in the home page for each different category
     */
    protected abstract DetailsBase clickSaveBtn();


    protected abstract AbstractBasePage clickCancelBtn();

    /**
     * Methods that encapsulates the the operations waiting for the element and the action
     */
    protected void clickSaveButton() {
        clickWebElement(saveBtn);
    }

    protected void clickSaveNewButton() {
        clickWebElement(saveNewBtn);
    }

    protected void clickCancelButton() {
        clickWebElement(cancelBtn);
    }

    protected void selectDatePicker(Integer month, Integer day, Integer year) {
        this.selectItemComboBox(monthPicker, month.toString());
        this.selectItemComboBox(yearPicker, year.toString());
        WebElement selectDate = driver.findElement(By.xpath("//div[@class='calBody']/descendant::td[contains(.,'" + day + "')]"));
        selectDate.click();
    }

    protected void selectItemComboBox(WebElement webElement, String value) {
        if (value == null) {
            throw new IllegalArgumentException(VALUE_CANNOT_BE_NULL);
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            Select comboBox = new Select(webElement);
            comboBox.selectByVisibleText(value);
        } catch (WebDriverException e) {
            throw new WebDriverException("The value " + value + " couldn't be selected", e);
        }
    }

    protected void fillTextBox(WebElement webElement, String value) {
        if (value == null) {
            throw new IllegalArgumentException(VALUE_CANNOT_BE_NULL);
        }
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value);
    }
}
