package com.salesforce.dev.pages.Base;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Walter on 13/06/2015.
 */
public abstract class FormBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "save")
    protected WebElement saveBtn;

    @FindBy(name = "save_new")
    protected WebElement saveNewBtn;

    @FindBy(name = "cancel")
    protected WebElement cancelBtn;

    //Calendar
    @FindBy(id = "calMonthPicker")
    protected WebElement monthPicker;

    @FindBy(id = "calYearPicker")
    protected WebElement yearPicker;

    protected String[] months;

    /**
     * This method initialize the driver and wait when creating the
     * page with a builder specifically
     *
     * @author: Jimmy Vargas
     * */
    protected void initializer(){
        if(driver == null){
            driver = DriverManager.getInstance().getDriver();
        }
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver,this);
    }
    /**
     * Method clicks the New button in the home page for each different category
     *
     * @author: Walter
     */
    protected abstract Object clickSaveBtn();
    protected abstract Object clickSaveNewBtn();
    protected abstract Object clickCancelBtn();

    /**
     * Methods that encapsulates the the operations waiting for the element and the action
     *
     * @author: Walter
     */
    protected void clickSaveButton() {
        this.wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();

    }

    protected void clickSaveNewButton() {
        wait.until(ExpectedConditions.visibilityOf(saveNewBtn));
        saveNewBtn.click();

    }

    protected void clickCancelButton() {
        wait.until(ExpectedConditions.visibilityOf(cancelBtn));
        cancelBtn.click();

    }

    protected void selectDatePicker(Integer month, Integer day, Integer year){
        months = new String []{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.selectItemComboBox(monthPicker, months[month - 1]);
        this.selectItemComboBox(yearPicker, year.toString());
        WebElement selectDate = driver.findElement(
                By.xpath("//div[@class='calBody']/descendant::td[contains(.,'" + day + "')]"));
        selectDate.click();
    }

    protected void selectItemComboBox(WebElement webElement, String value){
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            Select comboBox = new Select(webElement);
            comboBox.selectByVisibleText(value);
        }
        catch(WebDriverException e){
            throw new WebDriverException("The value " +value+ "couldn't be selected");
        }
    }

    protected void fillTextBox(WebElement webElement, String value){
        webElement.clear();
        webElement.sendKeys(value);
    }
}
