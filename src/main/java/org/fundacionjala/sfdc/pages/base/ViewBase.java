package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * This class will be used to represent all base views.
 *
 * @author Administrator
 */
public abstract class ViewBase extends AbstractBasePage {

    @FindBy(name = "save")
    protected WebElement saveBtn;

    @FindBy(name = "fname")
    protected WebElement viewNameFld;

    @FindBy(name = "devname")
    protected WebElement uniqueViewNameFld;

    @FindBy(id = "fscope0")
    protected WebElement filterOwnerAll;

    @FindBy(id = "fscope1")
    protected WebElement filterOwnerMy;
    ///id for Filter By Additional Fields (Optional):
    protected String idFieldField = "fcol";
    protected String idFieldOperator = "fop";
    protected String idFieldValue = "fval";

    //available fields
    @FindBy(xpath = "//label[text()='Available Fields']/following::select")
    private WebElement availableFields;

    @FindBy(xpath = "//img[@title='Add']")
    private WebElement addFieldsBtn;

    @FindBy(xpath = "//input[@value='fsharenone']")
    private WebElement visibilityOnlyMeRadio;

    @FindBy(xpath = "//input[@value='fshareall']")
    private WebElement visibilityAllRadio;

    @FindBy(xpath = "//input[@value='fsharegroups']")
    private WebElement visibilityGroupsRadio;

    private Select availableFieldsMultiSelect;

    protected abstract ViewDetailBase clickSaveBtn();

    protected abstract Object clickCancelBtn();

    protected abstract Object setViewName(String viewName);

    protected abstract Object setUniqueViewName(String uniqueViewName);

    protected abstract Object checkFilterByOwnerAll();

    protected abstract Object checkFilterByOwnerMy();

    protected abstract Object checkFilterByOwner(String filter);

    protected abstract Object addAdditionalFiltersByField(int numberField, String field, String operator, String value);

    protected abstract Object addNewFieldToDisplay(String newField);

    protected abstract Object selectRestrictVisibility(String optionVisibility);

    protected void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
    }

    protected void setViewNameFld(String viewName) {
        wait.until(ExpectedConditions.visibilityOf(viewNameFld));
        viewNameFld.clear();
        viewNameFld.sendKeys(viewName);
    }

    protected void setUniqueViewNameFld(String uniqueViewName) {
        wait.until(ExpectedConditions.visibilityOf(uniqueViewNameFld));
        uniqueViewNameFld.clear();
        uniqueViewNameFld.sendKeys(uniqueViewName);
    }

    protected void checkFilterOwnerAll() {
        wait.until(ExpectedConditions.visibilityOf(filterOwnerAll));
        filterOwnerAll.click();
    }

    protected void checkFilterOwnerMy() {
        wait.until(ExpectedConditions.visibilityOf(filterOwnerMy));
        filterOwnerMy.click();
    }


    public void addAdditionalFilterByField(int numberField, String field, String operator, String value) {
        By filterField = By.id(idFieldField + "" + numberField);
        By filterOperator = By.id(idFieldOperator + "" + numberField);
        By filterValue = By.id(idFieldValue + "" + numberField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterField));
        driver.findElement(filterField).click();
        driver.findElement(filterField).sendKeys(field);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterOperator));
        driver.findElement(filterOperator).click();
        driver.findElement(filterOperator).sendKeys(operator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterValue));
        driver.findElement(filterValue).clear();
        driver.findElement(filterValue).sendKeys(value);
    }

    protected void selectAvailableFldToDisplay(String field) {
        wait.until(ExpectedConditions.visibilityOf(availableFields));
        availableFields.click();
        availableFieldsMultiSelect.selectByVisibleText(field);
    }

    protected void clickAddNewFieldButton() {
        wait.until(ExpectedConditions.visibilityOf(addFieldsBtn));
        addFieldsBtn.click();
    }

    protected void addNewFldToDisplay(String newField) {
        availableFieldsMultiSelect = new Select(availableFields);
        selectAvailableFldToDisplay(newField);
        clickAddNewFieldButton();
    }

    protected void selectRestrictVisibilityRadio(String visibility) {
        switch (visibility) {
            case "only to me":
                wait.until(ExpectedConditions.visibilityOf(visibilityOnlyMeRadio));
                visibilityOnlyMeRadio.click();
                break;
            case "all users":
                wait.until(ExpectedConditions.visibilityOf(visibilityAllRadio));
                visibilityAllRadio.click();
                break;
            case "groups of users":
                wait.until(ExpectedConditions.visibilityOf(visibilityGroupsRadio));
                visibilityGroupsRadio.click();
                break;
        }
    }
}
