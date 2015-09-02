package com.salesforce.dev.pages.Accounts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.ViewBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Carlos Orellana on 9/2/2015.
 */
public class AccountView extends ViewBase {

    public AccountView(WebDriver driver) {
        super.driver = driver;
        super.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
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
    protected Object clickSaveBtn() {
        return null;
    }

    @Override
    protected Object clickCancelBtn() {
        return null;
    }

    @Override
    protected Object setViewName(String viewName) {
        return null;
    }

    @Override
    protected Object setUniqueViewName(String uniqueViewName) {
        return null;
    }

    @Override
    protected Object checkFilterByOwnerAllAccounts() {
        return null;
    }

    @Override
    protected Object checkFilterByOwnerMyAccount() {
        return null;
    }

    @Override
    protected Object checkFilterByOwner(String filter) {
        return null;
    }

    @Override
    protected Object addAdditionalFiltersByField(int numberField, String field, String operator, String value) {
        return null;
    }

    @Override
    protected Object addNewFieldToDisplay(String newField) {
        return null;
    }

    @Override
    protected Object selectRestrictVisibility(String optionVisibility) {
        return null;
    }
}
