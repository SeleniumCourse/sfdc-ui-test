package org.fundacionjala.sfdc.product;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.product.ProductBuilder;
import org.fundacionjala.sfdc.pages.product.ProductDetails;
import org.fundacionjala.sfdc.pages.product.ProductForm;
import org.fundacionjala.sfdc.pages.product.ProductsHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * This class will be used to test the creation of a product and product's options.
 *
 * @author Monica Pardo.
 * @since 6/13/2015
 */
public class CreateProduct {

    private NavigationBar navigationBar;
    private ProductForm productForm;
    private ProductDetails productDetails;

    @DataProvider
    public Object[][] getProductValues() {
        return new Object[][]{{"New product", "Code", "this is an new product"}};
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"}, dataProvider = "getProductValues")
    public void testCreateProduct(String productName, String prodCode, String prodDesc) {
        ProductsHome productsHome = navigationBar.goToProductsHome();
        productForm = productsHome.clickNewBtn();
        productForm = new ProductBuilder(productName)
                .setProductName(productName)
                .setProductCode(prodCode)
                .setProductDesc(prodDesc)
                .setProductActive(true).build();
        productDetails = productForm.saveProduct();
        assertTrue(productDetails.verifyProduct(productName), "product Was not Created");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        productDetails.clickDeleteButton();
    }
}
