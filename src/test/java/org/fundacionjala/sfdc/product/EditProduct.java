package org.fundacionjala.sfdc.product;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.product.ProductBuilder;
import org.fundacionjala.sfdc.pages.product.ProductDetails;
import org.fundacionjala.sfdc.pages.product.ProductForm;
import org.fundacionjala.sfdc.pages.product.ProductsHome;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class will be used  to test the edition of a product.
 *
 * @author Monica Pardo.
 * @author Bruno Barrios.
 * @since 6/10/2015.
 */


public class EditProduct {

    private ProductsHome productsHome;
    private ProductDetails productDetails;
    private ProductForm productForm;
    private MainPage mainPage;
    private NavigationBar navigationBar;

    @DataProvider
    public Object[][] getProductValues() {
        return new Object[][]{{"New product update", "Codigo2", "this is an update product"}};
    }

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        final String productName = "New product";
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();
        productForm = productsHome.clickNewBtn();
        ProductForm productForm = new ProductBuilder(productName)
                .setProductName(productName).build();
        productDetails = productForm.saveProduct();

    }

    @Test(groups = {"Acceptance"}, dataProvider = "getProductValues")
    public void testEditProduct(String productNewName, String prodNewCode, String prodNewDesc) {
        productDetails.clickEditBtn();
        ProductForm productForm = new ProductBuilder(productNewName)
                .setProductName(productNewName)
                .setProductCode(prodNewCode)
                .setProductDesc(prodNewDesc).build();
        productForm.setProductActive();
        productDetails = productForm.saveProduct();
        Assert.assertTrue(productDetails.verifyProduct(productNewName), "product Name was not updated");

    }

    @AfterMethod
    public void tearDown() {
        productDetails.clickDeleteButton();

    }
}


