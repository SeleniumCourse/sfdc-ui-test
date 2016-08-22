package org.fundacionjala.sfdc.pages.chatter;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.framework.selenium.CommonOperation;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.setWebElement;

/**
 * This class will be used to represent Chatter home page and its options.
 *
 * @author Monica Pardo
 */
public class ChatterHome extends AbstractBasePage {

    private static final Logger LOGGER = Logger.getLogger(ChatterHome.class.getName());

    @FindBy(id = "publisherAttachTextPost")
    private WebElement postLink;

    @FindBy(css = ".chatterPublisherRTE.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders.placeholder")
    private WebElement postDescField;

    @FindBy(id = "publishersharebutton")
    private WebElement shareBtn;

    @FindBy(xpath = "//textarea[@title='Write a comment...']")
    private WebElement commentField;

    @FindBy(xpath = "//input[@title='Comment']")
    private WebElement commentBtn;

    @FindBy(xpath = "//a[@title='More Actions']")
    private WebElement postMenu;

    @FindBy(xpath = "//a[@title='Delete this post']")
    private WebElement deletePostOption;

    @FindBy(xpath = "//a[@title='Edit this post']")
    private WebElement editPostOption;

    @FindBy(className = "publisherattachtext ")
    private WebElement postSection;

    @FindBy(id = "quickActionFeedBodyInput")
    private WebElement editPostTextArea;

    @FindBy(name = "quickActionSubmitButton")
    private WebElement saveEditBtn;

    @FindBy(id = "quickActionContainer")
    private WebElement editContainer;
    @FindBy(className = "cke_wysiwyg_frame cke_reset")
    private WebElement editFrame;
    @FindBy(css = ".cke_wysiwyg_frame.cke_reset")
    private WebElement richTextEditorFrame;

    public ChatterHome clickPost() {
        clickWebElement(postLink);
        return this;
    }

    public ChatterHome setPost(String postDesc) {
        driver.switchTo().frame(richTextEditorFrame);
        wait.until(ExpectedConditions.visibilityOf(postDescField));
        setWebElement(postDescField, postDesc);
        driver.switchTo().defaultContent();
        return this;
    }

    public EditPost editPost(String postName) {
        clickWebElement(driver.findElement(By.xpath("//div[@id='feedwrapper']/descendant::span[contains(.,'" + postName + "')]/following::a[contains(@title,'More Actions')]")));
        clickWebElement(editPostOption);
        return new EditPost();
    }

    public ChatterHome clickShareBtn() {
        shareBtn.click();
        return this;
    }

    public ChatterHome clickCommentForPost(String postValue) {
        driver.findElement(By.xpath("//div[@id='feedwrapper']/descendant::span[contains(.,'" + postValue + "')]/following::a[contains(.,'Comment')]")).click();
        return this;
    }

    public ChatterHome setComment(String comment) {
        wait.until(ExpectedConditions.visibilityOf(commentField));
        commentField.sendKeys(comment);
        return this;
    }

    public ChatterHome clickCommentBtn() {
        commentBtn.click();
        return this;
    }

    public ChatterHome deletePost() {
        postMenu.click();
        deletePostOption.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        return this;
    }

    public boolean verifyPostCreated(String post) {
        try {
            WebElement postValuePage = driver.findElement(By.xpath("//div[@id='feedwrapper']/descendant::span[contains(.,'" + post + "')]"));
            wait.until(ExpectedConditions.visibilityOf(postValuePage));
            return true;
        } catch (WebDriverException e) {
            LOGGER.error("Web element Verify Post Created not found", e);
            return false;
        }
    }

    public boolean verifyCommentCreated(String comment) {
        try {
            WebElement commentValuePage = driver.findElement(By.xpath("//div[@class='feeditemcommentbody']/descendant::span[contains(.,'" + comment + "')]"));
            wait.until(ExpectedConditions.visibilityOf(commentValuePage));
            return true;
        } catch (WebDriverException e) {
            LOGGER.error("Web element Verify Comment Created not found", e);
            return false;
        }
    }

    public boolean isUserInChatterTab() {
        return CommonOperation.isWebElementVisible(postSection);
    }

}
