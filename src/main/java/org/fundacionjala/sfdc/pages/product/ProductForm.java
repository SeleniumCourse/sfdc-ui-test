package org.fundacionjala.sfdc.pages.product;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * This class will be used to represent the form of Products.
 *
 * @author Monica Pardo
 */
public class ProductForm extends FormBase {

    @FindBy(id = "Name")
    private WebElement productNameField;

    @FindBy(id = "ProductCode")
    private WebElement productCodeField;

    @FindBy(id = "Description")
    private WebElement descField;

    @FindBy(id = "IsActive")
    private WebElement activeOption;

    @FindBy(xpath = "//input[@title='Save']")
    private WebElement saveBtn;

    private String prodName;

    private String prodCode;

    private String prodDesc;

    private boolean activeProduct;

    public ProductForm(ProductBuilder builder) {
        this.prodName = builder.getProductName();
        this.prodCode = builder.getProductCode();
        this.prodDesc = builder.getProductDesc();
        this.activeProduct = builder.getProductActive();

    }

    public ProductForm() {
    }

    public ProductDetails saveProduct() {
        if (prodName != null) {
            setProductName(prodName);
        }
        if (prodCode != null) {
            setProductCode(prodCode);
        }
        if (prodDesc != null) {
            setProductDesc(prodDesc);
        }
        if (!activeProduct) {
            setProductActive();
        }

        return clickSaveBtn();
    }

    @Override
    public ProductDetails clickSaveBtn() {
        saveBtn.click();
        return new ProductDetails();
    }

    @Override
    protected AbstractBasePage clickCancelBtn() {
        return null;
    }

    public void setProductName(String name) {
        wait.until(ExpectedConditions.visibilityOf(productNameField));
        productNameField.clear();
        productNameField.sendKeys(name);
    }

    public void setProductCode(String code) {
        wait.until(ExpectedConditions.visibilityOf(productCodeField));
        productCodeField.clear();
        productCodeField.sendKeys(code);
    }

    public void setProductDesc(String desc) {
        wait.until(ExpectedConditions.visibilityOf(descField));
        descField.clear();
        descField.sendKeys(desc);
    }

    public void setProductActive() {
        activeOption.click();
    }

    public ProductDetails setProduct(String name, String code, String desc) {
        productNameField.sendKeys(name);
        productCodeField.sendKeys(code);
        descField.sendKeys(desc);
        saveBtn.click();
        return new ProductDetails();

    }

}
