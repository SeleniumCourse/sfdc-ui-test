package org.fundacionjala.sfdc.pages.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonOperation;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class will be used to represent Contacts home page and its options.
 *
 * @author Marcelo Vargas
 */
public class ContactsHome extends HomeBase {
    @FindBy(xpath = "//h1[contains(.,'Contacts:')]")
    private WebElement contactSection;

    /**
     * this method clicks on new btn.
     *
     * @return ContactForm
     */
    @Override
    public ContactForm clickNewBtn() {
        clickNewButton();
        return new ContactForm();
    }

    @Override
    public ContactView clickNewViewLnk() {
        clickNewViewLink();
        return new ContactView();
    }

    @Override
    protected AbstractBasePage selectRecentViewItem(String value) {
        return null;
    }

    @Override
    public ContactView clickEditViewLnk(String value) {
        editViewLnk(value);
        return new ContactView();
    }

    @Override
    public ContactDetail selectRecentItem(String opportunity) {
        super.clickRecentItem(opportunity);
        return new ContactDetail();
    }

    public boolean isUserInContactsTab() {
        return CommonOperation.isWebElementVisible(contactSection);
    }
}
