package org.fundacionjala.sfdc.pages.contacts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.framework.utils.RandomGenerator;
import org.fundacionjala.sfdc.pages.base.ViewBase;

/**
 * This class will be used to represent Contact view and its options.
 *
 * @author veronica
 */
public class ContactView extends ViewBase {

    private static final Logger LOGGER = Logger.getLogger(ContactView.class.getName());

    @FindBy(id = "fentityvalue2")
    protected WebElement filterByCampaign;

    public ContactView() {
        try {
            wait.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(saveBtn));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    @Override
    protected Object clickCancelBtn() {
        return null;
    }

    @Override
    public ContactView setViewName(String viewName) {
        setViewNameFld(viewName + RandomGenerator.getInstance().getRandomString());
        return this;
    }

    @Override
    public ContactView setUniqueViewName(String uniqueViewName) {
        setUniqueViewNameFld(uniqueViewName + RandomGenerator.getInstance().getRandomString());
        return this;
    }

    @Override
    public ContactView checkFilterByOwnerAll() {
        checkFilterOwnerAll();
        return this;
    }

    @Override
    public ContactView checkFilterByOwnerMy() {
        checkFilterOwnerMy();
        return this;
    }

    public ContactView setFilterByCampaign(String filterByCompaingName) {
        filterByCampaign.sendKeys(filterByCompaingName);
        return this;
    }

    @Override
    public ContactView checkFilterByOwner(String filter) {
        return this;
    }

    @Override
    public ContactView addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        addAdditionalFilterByField(numberField, field, operator, value);
        return this;
    }

    @Override
    public ContactView addNewFieldToDisplay(String newField) {
        addNewFldToDisplay(newField);
        return this;
    }

    @Override
    public ContactView selectRestrictVisibility(String optionVisibility) {
        selectRestrictVisibilityRadio(optionVisibility);
        return this;
    }

    @Override
    public ContactViewDetail clickSaveBtn() {
        clickSaveButton();
        LOGGER.info("Contact was created");
        return new ContactViewDetail();
    }
}
