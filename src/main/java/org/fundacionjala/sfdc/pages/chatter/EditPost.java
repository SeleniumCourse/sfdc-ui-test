package org.fundacionjala.sfdc.pages.chatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.setWebElement;

/**
 * This class will be used to represent edit post.
 *
 * @author brunobarrios
 */
public class EditPost extends AbstractBasePage {

    @FindBy(css = ".cke_wysiwyg_frame.cke_reset")
    private WebElement text;

    @FindBy(css = ".chatterPublisherRTE.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders")
    private WebElement editTextBox;

    @FindBy(id = "quickActionContainer")
    private WebElement editContainer;

    @FindBy(xpath = "//input[contains(@value,' Save ')]")
    private WebElement saveEdit;

    public EditPost setEditTextBox(String textToEdit) {
        driver.switchTo().frame(text);
        setWebElement(editTextBox, textToEdit);
        driver.switchTo().defaultContent();
        return this;
    }

    public ChatterHome clickSaveEditBtn() {
        saveEdit.click();

        return new ChatterHome();
    }

}
