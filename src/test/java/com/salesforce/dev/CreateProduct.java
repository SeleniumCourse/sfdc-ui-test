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
import org.testng.annotations.Test;
import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.*;

/**
 * Created by Monica Pardo on 6/10/2015.
 */
public class CreateProduct {
    private LoginPage loginPage;
    private ProductsHome productsHome;
    private ProductDetails productDetails;
    private ProductForm productForm;
    private HomePage homePage;
    private MainPage mainPage;
    private NavigationBar navigationBar;
    private String productName="New product";
    private String prodCode="Codigo1";
    private String prodDesc="this is a new product";


    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        String userNameValue= Environment.getInstance().getPrimaryUser();
        String passwordValue=Environment.getInstance().getPrimaryPassword();
        mainPage = homePage.loginAs(userNameValue,passwordValue);

    }

    @Test
    public void testCreateProduct() {

        //productsHome=mainPage.clickProductTab();
        productForm=productsHome.clickNewProduct();
        ProductForm productForm= new ProductBuilder(productName)
                .setProductName(productName)
                .setProductCode(prodCode)
                .setProductDesc(prodDesc)
                .setProductActive(true).build();
        productDetails=productForm.saveProduct();


        Assert.assertTrue( productDetails.VerifyProduct(productName), "product Was not Created");

    }

    @AfterMethod
    public void tearDown() {
        productDetails.DeleteProduct();

    }
}
