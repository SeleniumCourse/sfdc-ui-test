package org.fundacionjala.sfdc.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.clickWebElement;
import static org.fundacionjala.sfdc.framework.selenium.CommonOperation.isElementPresent;

/**
 * This class will be used to represents product home page.
 *
 * @author monica
 */
public class ProductsHome extends HomeBase {

    @FindBy(xpath = "//h1[contains(.,'Products:')]")
    private WebElement productsSection;

    @Override
    protected AbstractBasePage clickNewViewLnk() {
        return null;
    }

    @Override
    protected AbstractBasePage clickEditViewLnk(String value) {
        return null;
    }

    @Override
    protected AbstractBasePage selectRecentViewItem(String value) {
        return null;
    }

    @Override
    public ProductForm clickNewBtn() {
        clickWebElement(newBtn);
        return new ProductForm();
    }

    @Override
    public ProductDetails selectRecentItem(String value) {
        clickRecentItem(value);
        return new ProductDetails();
    }

    public ProductDetails openProduct(String nameProduct) {
        super.driver.findElement(By.xpath("//a[contains(.,'" + nameProduct + "')]")).click();
        return new ProductDetails();
    }

    public boolean isUserInProductsTab() {
        return isElementPresent(productsSection);
    }

}