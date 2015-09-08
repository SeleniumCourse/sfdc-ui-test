package com.salesforce.dev;
import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.JSONMapper;
import com.salesforce.dev.framework.Objects.Product;
import com.salesforce.dev.framework.Objects.ViewSalesForce;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.Login.Transporter;
import com.salesforce.dev.pages.Product.ProductBuilder;
import com.salesforce.dev.pages.Product.ProductDetails;
import com.salesforce.dev.pages.Product.ProductForm;
import com.salesforce.dev.pages.Product.ProductsHome;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.*;

import java.util.Iterator;

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
    Product oppPro;


    @DataProvider(name = "dataDriven")
    public Iterator<Product[]> getProduct() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getProduct("EditProduct.json");
    }
    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();

    }

    @Test(groups = {"Acceptance"}, dataProvider = "dataDriven")
    public void testEditProduct(Product product) {
        mainPage = Transporter.driverMainPage();
        navigationBar = mainPage.gotoNavBar();
        productsHome = navigationBar.goToProductsHome();
        productDetails = productsHome.selectRecentItem(product.getProductName());
        productDetails.clickEditBtn();
        ProductForm productForm= new ProductBuilder(product.productName, product.productCode, product.productDescription)
                .setProductName(product.productName)
                .setProductCode(product.productCode)
                .setProductDesc(product.productDescription).build();
                productForm.setProductActive();
        productDetails=productForm.saveProduct();

        Assert.assertTrue(productDetails.VerifyProduct(product.productName), "product Name Was not updated");

    }

    @AfterMethod
    public void tearDown() {
        productDetails.clickDeleteBtn(true);

    }

}


