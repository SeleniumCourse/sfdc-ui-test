package com.salesforce.dev;
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



public class EditProduct {

    private LoginPage loginPage;
    private ProductsHome productsHome;
    private ProductDetails productDetails;
    private ProductForm productForm;
    private HomePage homePage;
    private MainPage mainPage;
    private String productName="New product";
    private String prodCode="Codigo1";
    private String prodDesc="this is a new product";
    private String productNewName="New product update";
    private String prodNewCode="Codigo2";
    private String prodNewDesc="this is a new product update";


    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        String userNameValue=Environment.getInstance().getPrimaryUser();
        String passwordValue= Environment.getInstance().getPrimaryPassword();
        mainPage = homePage.loginAs(userNameValue, passwordValue);
        //productsHome=mainPage.clickProductTab();
        productForm=productsHome.clickNewProduct();
        productDetails=productForm.SetProduct(productName,prodCode,prodDesc);

    }

    @Test
    public void testEditProduct() {
        productDetails.EditProduct();
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
        productDetails.DeleteProduct();

    }
}


