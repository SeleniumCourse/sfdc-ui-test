package org.fundacionjala.sfdc.pages.product;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.base.DetailsBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class will be used to represents all detail view of a product.
 *
 * @author Monica
 */
public class ProductDetails extends DetailsBase {

    @FindBy(id = "Name_ileinner")
    private WebElement productNameReg;

    @Override
    public FormBase clickEditBtn() {
        super.clickEditButton();
        return new ProductForm();
    }

    @Override
    public HomeBase clickDeleteButton() {
        clickDeletedButton();
        return new ProductsHome();
    }

    @Override
    public Map<Enum, Object> getAssertionMap() {
        return null;
    }

    public boolean verifyProduct(String nameValue) {
        return productNameReg.getText().equals(nameValue);
    }
}
