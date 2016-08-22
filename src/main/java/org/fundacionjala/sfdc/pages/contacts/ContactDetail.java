package org.fundacionjala.sfdc.pages.contacts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class will be used to represent Contact page and its options.
 *
 * @author Marcelo.Vargas
 */
public class ContactDetail extends DetailsBase {

    private static final Logger LOGGER = Logger.getLogger(ContactDetail.class.getName());

    @FindBy(id = "con2_ileinner")
    private WebElement contactName;

    public ContactForm clickEditBtn(){
        clickEditButton();
        return new ContactForm();
    }

    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        LOGGER.info("Contact was deleted");
        return new ContactsHome();
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        return null;
    }

    public MainPage gotoMainPage(){
        return new MainPage();
    }

    public Boolean validateContactName(String value) {
        return contactName.getText().equals(value);
    }
}
