package com.salesforce.dev;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Product.ProductBuilder;
import com.salesforce.dev.pages.Product.ProductDetails;
import com.salesforce.dev.pages.Product.ProductForm;
import com.salesforce.dev.pages.Product.ProductsHome;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.salesforce.dev.pages.*;
/**
 * Created by Monica Pardo on 6/10/2015.
 */


public class EditProduct {

    private ProductsHome productsHome;
    private ProductDetails productDetails;
    private ProductForm productForm;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private String productName="New product";

    @BeforeMethod
    public void setUp() {
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        productsHome=navigationBar.goToProductsHome();
        productForm=productsHome.clickNewBtn();
        ProductForm productForm= new ProductBuilder(productName)
                .setProductName(productName).build();
        productDetails=productForm.saveProduct();

    }

    @Test(groups = {"Acceptance"}, dataProvider = "getProductValues")
    public void testEditProduct(String productNewName,String prodNewCode,String prodNewDesc) {
        productDetails.clickEditBtn();
        ProductForm productForm= new ProductBuilder(productNewName)
                .setProductName(productNewName)
                .setProductCode(prodNewCode)
                .setProductDesc(prodNewDesc).build();
                productForm.setProductActive();
        productDetails=productForm.saveProduct();

        Assert.assertTrue(productDetails.VerifyProduct(productNewName), "product Name Was not updated");

    }

    @AfterMethod
    public void tearDown() {
        productDetails.clickDeleteBtn(true);

    }
    @DataProvider
    public Object[][] getProductValues() {
        return new Object[][]{{"New product update","Codigo2","this is an update product"}};
    }
}


